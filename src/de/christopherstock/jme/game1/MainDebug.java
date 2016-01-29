
    package de.christopherstock.jme.game1;

    import  de.christopherstock.lib.*;
    import  de.christopherstock.lib.ui.*;

    /**************************************************************************************
    *   The debug system consisting of switchable debug groups.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    **************************************************************************************/
    public enum MainDebug implements LibDebug
    {
        geometry(           Lib.YES    ),       //logs geometry

        bugfix(             Lib.YES     ),      //prior debug group
        major(              Lib.YES     ),      //prior debug group
        error(              Lib.YES     ),      //prior debug group

        ;

        /************************************************************************************
         *   The global debug switch that disables all debug outputs.
         ************************************************************************************/
        public      static  final   boolean         DEBUG_MODE                          = Lib.YES;

        public      static  final   boolean         DEBUG_DRAW_PLAYER_CIRCLE            = Lib.YES;
        public      static  final   boolean         DEBUG_DRAW_ITEM_CIRCLE              = Lib.YES;
        public      static  final   boolean         DEBUG_DRAW_BOT_CIRCLES              = Lib.NO;
        public      static  final   boolean         DEBUG_SHOW_FPS                      = Lib.YES;

        private                     boolean         iDebugEnabled                       = false;

        private MainDebug( boolean aDebugEnabled )
        {
            iDebugEnabled = aDebugEnabled;
        }

        @Override
        public final void out( Object obj )
        {
            if ( DEBUG_MODE && iDebugEnabled    ) System.out.println( "[" + LibStringFormat.getSingleton().formatDateTime() + "] " + obj );
        }

        @Override
        public final void err( Object obj )
        {
            if ( DEBUG_MODE                     ) System.err.println( "[" + LibStringFormat.getSingleton().formatDateTime() + "] " + obj );
        }

        @Override
        public final void trace( Throwable obj )
        {
            if ( DEBUG_MODE                     ) obj.printStackTrace();
        }

        @Override
        public final void mem()
        {
            if ( DEBUG_MODE && iDebugEnabled )
            {
                Runtime r = Runtime.getRuntime();
                out( "========================================================"                         );
                out( " free:  [" + LibStringFormat.getSingleton().formatNumber( r.freeMemory()  ) + "]" );
                out( " total: [" + LibStringFormat.getSingleton().formatNumber( r.totalMemory() ) + "]" );
                out( "  max:  [" + LibStringFormat.getSingleton().formatNumber( r.maxMemory()   ) + "]" );
            }
        }
    }
