
    package de.christopherstock.jme.game1.ui.scene;

    import  com.jme3.app.SimpleApplication;
    import  com.jme3.material.Material;
    import  com.jme3.math.ColorRGBA;
    import  com.jme3.math.Quaternion;
    import  com.jme3.scene.Geometry;
    import  com.jme3.scene.Node;
    import  com.jme3.scene.shape.Box;

    /***************************************************************************
    *   This is the 2nd example scene.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    ***************************************************************************/
    public class Scene2
    {
        /***************************************************************************
        *   Adds this scene.
        *
        *   @param  app     The application.
        ***************************************************************************/
        public static void add( SimpleApplication app )
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

            Material mat1 = new Material( app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md" );
            mat1.setColor( "Color", ColorRGBA.Red );

            Material mat2 = new Material( app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md" );
            mat2.setColor( "Color", ColorRGBA.Green );

            Material mat3 = new Material( app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md" );
            mat3.setColor( "Color", ColorRGBA.Blue );

            Node pivot1 = new Node( "pivot" );
            pivot1.attachChild( geom3 );
            pivot1.rotate( 45.0f, 0.0f, 0.0f );

            geom1.setMaterial( mat1 );
            geom2.setMaterial( mat2 );
            geom3.setMaterial( mat3 );

            app.getRootNode().attachChild( geom1  );
            app.getRootNode().attachChild( geom2  );
            app.getRootNode().attachChild( pivot1 );
        }
    }
