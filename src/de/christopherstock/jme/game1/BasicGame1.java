
    package de.christopherstock.jme.game1;

    import com.jme3.app.SimpleApplication;
    import com.jme3.material.Material;
    import com.jme3.math.ColorRGBA;
    import com.jme3.math.Vector3f;
    import com.jme3.renderer.RenderManager;
    import com.jme3.scene.Geometry;
    import com.jme3.scene.shape.Box;

    /***************************************************************************
    *   This is the application's main class. It contains the main method
    *   and the ToDo-list.
    *
    *   TODO ASAP   Create and synchronize as GIT project.
    *   TODO ASAP   Create alternate source folder (src_lib) for library sources!
    *   TODO ASAP   Pick libraries for general purposes.
    *   TODO ASAP   Try the car example.
    *   TODO ASAP   Try assets and materials.
    *
    *   @author  stock
    *   @version 0.1
    ***************************************************************************/
    public class BasicGame1 extends SimpleApplication
    {
        /***************************************************************************
        *   This is the application's entry point.
        *
        *   @param  args    All parameters being passed from the command line.
        ***************************************************************************/
        public static void main( String[] args )
        {
            BasicGame1 app = new BasicGame1();
            app.start();
        }

        /***************************************************************************
        *   Being invoked on initializing the application.
        ***************************************************************************/
        @Override
        public void simpleInitApp()
        {
            Box      b    = new Box( 1, 1, 1 );
            Geometry geom = new Geometry("Box", b);

            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);

            rootNode.attachChild(geom);
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
