
    package de.christopherstock.lib.io;

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
        *   @param  settings    The app settings.
        *   @param  debug       The debug context.
        **************************************************************************************/
        public static void setIcons( AppSettings settings, LibDebug debug )
        {
            settings.setIcons
            (
                new BufferedImage[]
                {
                    read( "/Interface/icons/logo256x256.png", debug ),
                    read( "/Interface/icons/logo128x128.png", debug ),
                    read( "/Interface/icons/logo32x32.png",   debug ),
                    read( "/Interface/icons/logo16x16.png",   debug ),
                }
            );
        }

        /**************************************************************************************
        *   Set altered application startup splash.
        *
        *   @param  settings    The app settings.
        *   @param  debug       The debug context.
        **************************************************************************************/
        public static void setTitleImage( AppSettings settings, LibDebug debug )
        {
            settings.setSettingsDialogImage( "/Interface/title/splash.png" );
        }

        /**************************************************************************************
        *   Reads via basic Image IO.
        *
        *   @param  string  The target file path.
        *   @param  debug   The debug context.
        **************************************************************************************/
        public static BufferedImage read( String path, LibDebug debug )
        {
            try
            {
                return ImageIO.read( LibIO.class.getResourceAsStream( path ) );
            }
            catch ( IOException ioe )
            {
                debug.trace( ioe );
            }
            return null;
        }
    }
