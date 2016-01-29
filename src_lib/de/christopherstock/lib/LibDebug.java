
    package de.christopherstock.lib;

    /*********************************************************************************
    *   This class represents an abstract debug system.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    *********************************************************************************/
    public abstract interface LibDebug
    {
        /*********************************************************************************
        *   An output being logged if this debug group is enabled.
        *********************************************************************************/
        public abstract void out( Object msg );

        /*********************************************************************************
        *   An output being logged UNCONDITIONAL.
        *********************************************************************************/
        public abstract void err( Object msg );

        /*********************************************************************************
        *   A stacktrace being logged if this debug group is enabled.
        *********************************************************************************/
        public abstract void trace( Throwable msg );

        /*********************************************************************************
        *   Displays memory info.
        *********************************************************************************/
        public abstract void mem();
    }
