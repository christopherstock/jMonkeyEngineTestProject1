
    package de.christopherstock.jme.game1;

    /**************************************************************************************
    *   The current version enumeration.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    **************************************************************************************/
    enum MainVersion
    {
        V_0_0_1(    "0.0.1",    "29.01.2016  10:57:13 GMT+1", "" ),
        ;

        private     String  version = null;
        private     String  date    = null;

        @SuppressWarnings( "unused" )
        private     String  log     = null;

        private MainVersion( String aVersion, String aDate, String aLog )
        {
            version = aVersion;
            date    = aDate;
            log     = aLog;
        }

        public static final String getCurrentVersionDesc()
        {
            return "v. " + values()[ 0 ].version + ", " + values()[ 0 ].date;
        }
    }
