
    package de.christopherstock.jme.game1;

    import  com.jme3.app.SimpleApplication;
    import  com.jme3.renderer.RenderManager;
    import  de.christopherstock.jme.game1.ui.scene.*;

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



            app.start();
        }

        /***************************************************************************
        *   Being invoked on initializing the application.
        ***************************************************************************/
        @Override
        public void simpleInitApp()
        {
            Scene2.add( this );
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
