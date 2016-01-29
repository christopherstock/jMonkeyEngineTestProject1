
    package de.christopherstock.jme.game1;

    import  com.jme3.app.SimpleApplication;
    import  com.jme3.bounding.BoundingBox;
    import  com.jme3.bullet.BulletAppState;
    import  com.jme3.bullet.PhysicsSpace;
    import  com.jme3.bullet.collision.shapes.CollisionShape;
    import  com.jme3.bullet.control.VehicleControl;
    import  com.jme3.bullet.objects.VehicleWheel;
    import  com.jme3.bullet.util.CollisionShapeFactory;
    import  com.jme3.input.KeyInput;
    import  com.jme3.input.controls.ActionListener;
    import  com.jme3.input.controls.KeyTrigger;
    import  com.jme3.light.DirectionalLight;
    import  com.jme3.math.FastMath;
    import  com.jme3.math.Matrix3f;
    import  com.jme3.math.Vector3f;
    import  com.jme3.renderer.RenderManager;
    import  com.jme3.renderer.queue.RenderQueue;
    import  com.jme3.scene.Geometry;
    import  com.jme3.scene.Node;
    import  com.jme3.scene.Spatial;
    import  com.jme3.shadow.BasicShadowRenderer;
    import  com.jme3.system.AppSettings;
    import  de.christopherstock.lib.io.LibIO;

    /***************************************************************************
    *   This is the application's main class. It contains the main method
    *   and the ToDo-list.
    *
    *   TODO ASAP   Pick the car example to own project
    *   TODO ASAP   Follow the tutorial in order to check out materials, scene etc.
    *   TODO INIT   Try assets and materials.
    *   TODO WEAK   Browse more examples!
    *
    *   DONE        Browsed examples.
    *   DONE        Ajusted app splashscreen.
    *   DONE        Ajusted app icon.
    *   DONE        Tried the car example.
    *   DONE        Explore simple scene setup.
    *   DONE        Adjust version specifier for all classes.
    *   DONE        Unify author and version for all classes.
    *   DONE        Created version system.
    *   DONE        Created debug system.
    *   DONE        Created settings system.
    *   DONE        Created and synchronize GIT project.
    *   DONE        Created alternate source folder (src_lib) for library sources.
    *   DONE        Picked libraries for general purposes.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    ***************************************************************************/
    public class Main extends SimpleApplication implements ActionListener
    {
        private BulletAppState  bulletAppState                      = null;

        private VehicleControl  player                              = null;

        private VehicleWheel    fr                                  = null;
        private VehicleWheel    fl                                  = null;
        private VehicleWheel    br                                  = null;
        private VehicleWheel    bl                                  = null;

        private Node            node_fr                             = null;
        private Node            node_fl                             = null;
        private Node            node_br                             = null;
        private Node            node_bl                             = null;

        private float           wheelRadius                         = 0.0f;
        private float           steeringValue                       = 0.0f;
        private float           accelerationValue                   = 0.0f;

        private Node            carNode                             = null;

        /***************************************************************************
        *   This is the application's entry point.
        *
        *   @param  args    All parameters being passed from the command line.
        ***************************************************************************/
        public static void main( String[] args )
        {
            MainDebug.major.out
            (
                    "Welcome to [" + MainSettings.General.TITLE + "] "
                +   "version [" + MainVersion.getCurrentVersionDesc() + "]"
            );

            //create app and settings
            Main        app         = new Main();
            AppSettings appSettings = new AppSettings( true );

            //modify settings
            appSettings.setTitle( MainSettings.General.TITLE );
            LibIO.setIcons(      appSettings, MainDebug.error );
            LibIO.setTitleImage( appSettings, MainDebug.error );

            //assign settings and start
            app.setSettings( appSettings );
            app.start();
        }

        /***************************************************************************
        *   Being invoked on initializing the application.
        ***************************************************************************/
        @Override
        public void simpleInitApp()
        {
/*
            Scene2.add( this );
             if ( true ) return;
*/
            bulletAppState = new BulletAppState();
            stateManager.attach(bulletAppState);

//          bulletAppState.getPhysicsSpace().enableDebug(assetManager);

            if (settings.getRenderer().startsWith("LWJGL"))
            {
                BasicShadowRenderer bsr = new BasicShadowRenderer(assetManager, 512);
                bsr.setDirection(new Vector3f(-0.5f, -0.3f, -0.3f).normalizeLocal());
             //   viewPort.addProcessor(bsr);
            }
            cam.setFrustumFar(150f);
            flyCam.setMoveSpeed(10);

            setupKeys();
            PhysicsTestHelper.createPhysicsTestWorld(rootNode, assetManager, bulletAppState.getPhysicsSpace());
    //        setupFloor();
            buildPlayer();

            DirectionalLight dl = new DirectionalLight();
            dl.setDirection(new Vector3f(-0.5f, -1f, -0.3f).normalizeLocal());
            rootNode.addLight(dl);

            dl = new DirectionalLight();
            dl.setDirection(new Vector3f(0.5f, -0.1f, 0.3f).normalizeLocal());

         //   rootNode.addLight(dl);
        }

        /***************************************************************************
        *   Being invoked on updating the application. (?)
        ***************************************************************************/
        @Override
        public void simpleUpdate(float tpf)
        {
            cam.lookAt(carNode.getWorldTranslation(), Vector3f.UNIT_Y);
        }

        /***************************************************************************
        *   Being invoked on rendering the application and the 3d canvas?
        ***************************************************************************/
        @Override
        public void simpleRender(RenderManager rm)
        {
            //TODO: add render code
        }

        private void setupKeys()
        {
            inputManager.addMapping( "Lefts",  new KeyTrigger( KeyInput.KEY_LEFT   ) );
            inputManager.addMapping( "Rights", new KeyTrigger( KeyInput.KEY_RIGHT  ) );
            inputManager.addMapping( "Ups",    new KeyTrigger( KeyInput.KEY_UP     ) );
            inputManager.addMapping( "Downs",  new KeyTrigger( KeyInput.KEY_DOWN   ) );
            inputManager.addMapping( "Space",  new KeyTrigger( KeyInput.KEY_SPACE  ) );
            inputManager.addMapping( "Reset",  new KeyTrigger( KeyInput.KEY_RETURN ) );

            inputManager.addListener( this, "Lefts"  );
            inputManager.addListener( this, "Rights" );
            inputManager.addListener( this, "Ups"    );
            inputManager.addListener( this, "Downs"  );
            inputManager.addListener( this, "Space"  );
            inputManager.addListener( this, "Reset"  );
        }

        private PhysicsSpace getPhysicsSpace()
        {
            return bulletAppState.getPhysicsSpace();
        }

        private Geometry findGeom(Spatial spatial, String name)
        {
            if (spatial instanceof Node) {
                Node node = (Node) spatial;
                for (int i = 0; i < node.getQuantity(); i++) {
                    Spatial child = node.getChild(i);
                    Geometry result = findGeom(child, name);
                    if (result != null) {
                        return result;
                    }
                }
            } else if (spatial instanceof Geometry) {
                if (spatial.getName().startsWith(name)) {
                    return (Geometry) spatial;
                }
            }
            return null;
        }

        private void buildPlayer()
        {
            float stiffness = 120.0f;//200=f1 car
            float compValue = 0.2f; //(lower than damp!)
            float dampValue = 0.3f;
            final float mass = 400;

            //Load model and get chassis Geometry
            carNode = (Node)assetManager.loadModel("Models/Ferrari/Car.scene");
            carNode.setShadowMode(RenderQueue.ShadowMode.Cast);
            Geometry chasis = findGeom(carNode, "Car");
            BoundingBox box = (BoundingBox) chasis.getModelBound();

            //Create a hull collision shape for the chassis
            CollisionShape carHull = CollisionShapeFactory.createDynamicMeshShape(chasis);

            //Create a vehicle control
            player = new VehicleControl(carHull, mass);
            carNode.addControl(player);

            //Setting default values for wheels
            player.setSuspensionCompression(compValue * 2.0f * FastMath.sqrt(stiffness));
            player.setSuspensionDamping(dampValue * 2.0f * FastMath.sqrt(stiffness));
            player.setSuspensionStiffness(stiffness);
            player.setMaxSuspensionForce(10000);

            //Create four wheels and add them at their locations
            //note that our fancy car actually goes backwards..
            Vector3f wheelDirection = new Vector3f(0, -1, 0);
            Vector3f wheelAxle = new Vector3f(-1, 0, 0);

            Geometry wheel_fr = findGeom(carNode, "WheelFrontRight");
            wheel_fr.center();
            box = (BoundingBox) wheel_fr.getModelBound();
            wheelRadius = box.getYExtent();
            float back_wheel_h = (wheelRadius * 1.7f) - 1f;
            float front_wheel_h = (wheelRadius * 1.9f) - 1f;
            player.addWheel(wheel_fr.getParent(), box.getCenter().add(0, -front_wheel_h, 0),
                    wheelDirection, wheelAxle, 0.2f, wheelRadius, true);

            Geometry wheel_fl = findGeom(carNode, "WheelFrontLeft");
            wheel_fl.center();
            box = (BoundingBox) wheel_fl.getModelBound();
            player.addWheel(wheel_fl.getParent(), box.getCenter().add(0, -front_wheel_h, 0),
                    wheelDirection, wheelAxle, 0.2f, wheelRadius, true);

            Geometry wheel_br = findGeom(carNode, "WheelBackRight");
            wheel_br.center();
            box = (BoundingBox) wheel_br.getModelBound();
            player.addWheel(wheel_br.getParent(), box.getCenter().add(0, -back_wheel_h, 0),
                    wheelDirection, wheelAxle, 0.2f, wheelRadius, false);

            Geometry wheel_bl = findGeom(carNode, "WheelBackLeft");
            wheel_bl.center();
            box = (BoundingBox) wheel_bl.getModelBound();
            player.addWheel(wheel_bl.getParent(), box.getCenter().add(0, -back_wheel_h, 0),
                    wheelDirection, wheelAxle, 0.2f, wheelRadius, false);

            player.getWheel(2).setFrictionSlip(4);
            player.getWheel(3).setFrictionSlip(4);

            rootNode.attachChild(carNode);
            getPhysicsSpace().add(player);
        }

        public void onAction(String binding, boolean value, float tpf)
        {
            if (binding.equals("Lefts")) {
                if (value) {
                    steeringValue += .5f;
                } else {
                    steeringValue += -.5f;
                }
                player.steer(steeringValue);
            } else if (binding.equals("Rights")) {
                if (value) {
                    steeringValue += -.5f;
                } else {
                    steeringValue += .5f;
                }
                player.steer(steeringValue);
            } //note that our fancy car actually goes backwards..
            else if (binding.equals("Ups")) {
                if (value) {
                    accelerationValue -= 800;
                } else {
                    accelerationValue += 800;
                }
                player.accelerate(accelerationValue);
                player.setCollisionShape(CollisionShapeFactory.createDynamicMeshShape(findGeom(carNode, "Car")));
            } else if (binding.equals("Downs")) {
                if (value) {
                    player.brake(40f);
                } else {
                    player.brake(0f);
                }
            } else if (binding.equals("Reset")) {
                if (value) {
                    System.out.println("Reset");
                    player.setPhysicsLocation(Vector3f.ZERO);
                    player.setPhysicsRotation(new Matrix3f());
                    player.setLinearVelocity(Vector3f.ZERO);
                    player.setAngularVelocity(Vector3f.ZERO);
                    player.resetSuspension();
                } else {
                }
            }
        }
    }
