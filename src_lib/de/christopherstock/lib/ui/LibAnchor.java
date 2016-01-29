
    package de.christopherstock.lib.ui;

    /**************************************************************************************
    *   The Image-Loader.
    *
    *   @author     Christopher Stock
    *   @version    0.0.1
    **************************************************************************************/
    public enum LibAnchor
    {
        /**     Anchor for left top.            */  EAnchorLeftTop,
        /**     Anchor for left middle.         */  EAnchorLeftMiddle,
        /**     Anchor for left bottom.         */  EAnchorLeftBottom,
        /**     Anchor for center top.          */  EAnchorCenterTop,
        /**     Anchor for center middle.       */  EAnchorCenterMiddle,
        /**     Anchor for center bottom.       */  EAnchorCenterBottom,
        /**     Anchor for right left.          */  EAnchorRightTop,
        /**     Anchor for right middle.        */  EAnchorRightMiddle,
        /**     Anchor for right bottom.        */  EAnchorRightBottom,
        ;

        /**************************************************************************************
        *   Defines one anchor.
        *
        *   @param  aVal     The int-value to use for this anchor.
        **************************************************************************************/
        private LibAnchor()
        {
        }
    }
