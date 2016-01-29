
    package de.christopherstock.lib.io;

    import  com.jme3.app.SimpleApplication;
    import  com.jme3.system.AppSettings;
    import  de.christopherstock.lib.LibDebug;
    import  java.awt.image.BufferedImage;
    import  java.io.IOException;
    import  javax.imageio.ImageIO;

    /**************************************************************************************
    *   Basic IO operations.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    **************************************************************************************/
    public abstract class LibIO
    {
        /**************************************************************************************
        *   Set altered application icons.
        *
        *   @param  app     The app context.
        *   @param  debug   The debug context.
        **************************************************************************************/
        public static void setIcons( SimpleApplication app, LibDebug debug )
        {
            AppSettings settings = new AppSettings( true );

            try
            {
                settings.setIcons(
                    new BufferedImage[]
                    {
                        ImageIO.read( LibIO.class.getResourceAsStream( "/Interface/icons/logo256x256.png" ) ),
                        ImageIO.read( LibIO.class.getResourceAsStream( "/Interface/icons/logo128x128.png" ) ),
                        ImageIO.read( LibIO.class.getResourceAsStream( "/Interface/icons/logo32x32.png"   ) ),
                        ImageIO.read( LibIO.class.getResourceAsStream( "/Interface/icons/logo16x16.png"   ) ),
                    }
                );
            }
            catch ( IOException ioe )
            {
                debug.trace( ioe );
            }

            app.setSettings(settings);
        }
    }
