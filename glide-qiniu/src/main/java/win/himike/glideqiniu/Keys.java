package win.himike.glideqiniu;

/**
 * Created by HiMike on 2017/7/14.
 */

public class Keys {
    public static final String AUTO_ORIENT = "ao";
    public static final String STRIP = "strip";
    public static final String ROTATE = "rotate";
    public static final String FORMAT = "format";

    public static final String BLUR = "blur";
    public static final String BLUR_RADIUS = "bR";
    public static final String BLUR_SIGMA = "bS";

    public static final String JPG_QUALITY = "quality";
    public static final String SHARPEN = "sharpen";

    public static final String IMAGE_W = "w";
    public static final String IMAGE_H = "h";

    //指定宽高强行缩放,一般会变形
    public static final String FIX_SCALE_W_H = "fixWH";
    //等比缩放,取较小缩放值
    public static final String FIT_W_H_MIN = "fitMin";
    //等比缩放,取较大的缩放值
    public static final String FIT_W_H_MAX = "fitMax";
    public static final String ZOOM_OUT = "zoomOut";
    public static final String ZOOM_IN = "zoomIn";
    //根据ImageView宽度,缩放高度
    public static final String FIT_VIEW_WIDTH = "fitWidth";
    public static final String FIT_VIEW_HEIGHT = "fitHeight";
    public static final String FIT_VIEW = "fitView";
}
