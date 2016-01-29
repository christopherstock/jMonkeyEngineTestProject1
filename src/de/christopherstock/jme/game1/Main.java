
    package de.christopherstock.jme.game1;

    import com.jme3.app.SimpleApplication;
    import com.jme3.material.Material;
    import com.jme3.math.ColorRGBA;
    import com.jme3.renderer.RenderManager;
    import com.jme3.scene.Geometry;
    import com.jme3.scene.shape.Box;
    import com.jme3.system.AppSettings;

    /***************************************************************************
    *   This is the application's main class. It contains the main method
    *   and the ToDo-list.
    *
    *   TODO ASAP   Follow the tutorial in order to check out materials, scene etc.
    *   TODO HIGH   Browse examples.
    *
    *   TODO INIT   Try the car example.
    *   TODO INIT   Try assets and materials.
    *
    *   TODO LOW    Ajust app splashscreen.
    *   TODO WEAK   Ajust app icon.
    *
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
    public class Main extends SimpleApplication
    {
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

            Main app = new Main();

            //app.get

            app.start();
        }

        /***************************************************************************
        *   Being invoked on initializing the application.
        ***************************************************************************/
        @Override
        public void simpleInitApp()
        {
            Box      b1    = new Box( 1.0f, 1.0f, 1.0f );
            Box      b2    = new Box( 1.0f, 1.0f, 1.0f );
            Box      b3    = new Box( 1.0f, 1.0f, 1.0f );

            Geometry geom1 = new Geometry( "Box1", b1 );
            Geometry geom2 = new Geometry( "Box2", b2 );
            Geometry geom3 = new Geometry( "Box3", b3 );

            geom1.setLocalTranslation( -3.0f, 0.0f, 0.0f );
            geom2.setLocalTranslation( 0.0f,  0.0f, 0.0f );
            geom3.setLocalTranslation( 3.0f,  0.0f, 0.0f );

            Material mat1 = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md" );
            mat1.setColor( "Color", ColorRGBA.Red );

            Material mat2 = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md" );
            mat2.setColor( "Color", ColorRGBA.Green );

            Material mat3 = new Material( assetManager, "Common/MatDefs/Misc/Unshaded.j3md" );
            mat3.setColor( "Color", ColorRGBA.Blue );

            geom1.setMaterial( mat1 );
            geom2.setMaterial( mat2 );
            geom3.setMaterial( mat3 );

            rootNode.attachChild(geom1);
            rootNode.attachChild(geom2);
            rootNode.attachChild(geom3);
        }

        /***************************************************************************
        *   Being invoked on updating the application. (?)
        ***************************************************************************/
        @Override
        public void simpleUpdate(float tpf)
        {
            //TODO: add update code
        }

        /***************************************************************************
        *   Being invoked on rendering the application and the 3d canvas?
        ***************************************************************************/
        @Override
        public void simpleRender(RenderManager rm)
        {
            //TODO: add render code
        }
    }
