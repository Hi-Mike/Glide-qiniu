package win.himike.glideqiniu.extension;

import android.support.annotation.IntRange;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by HiMike on 2017/7/14.
 */

@GlideExtension
public class QiniuGlideExtension {

    private QiniuGlideExtension() {
    }

    @GlideOption
    public static void autoOrient(RequestOptions options, boolean autoOrient) {
        options.set(Option.memory(Keys.AUTO_ORIENT), autoOrient);
    }

    @GlideOption
    public static void strip(RequestOptions options) {
        options.set(Option.memory(Keys.STRIP), true);
    }

    @GlideOption
    public static void format(RequestOptions options, Format format) {
        options.set(Option.memory(Keys.FORMAT, Format.origin), format);
    }

    @GlideOption
    public static void rotate(RequestOptions options, @IntRange(from = 1, to = 360) int rotate) {
        options.set(Option.memory(Keys.ROTATE), rotate);
    }

    @GlideOption
    public static void blur(RequestOptions options,
                            @IntRange(from = 1, to = 50) int radius,
                            @IntRange(from = 1) int sigma) {
        options.set(Option.memory(Keys.BLUR), true);
        options.set(Option.memory(Keys.BLUR_RADIUS, 1), radius);
        options.set(Option.memory(Keys.BLUR_SIGMA, 1), sigma);
    }

    @GlideOption
    public static void jpgQuality(RequestOptions options,
                                  @IntRange(from = 1, to = 100) int quality) {
        options.set(Option.memory(Keys.JPG_QUALITY), quality);
    }

    @GlideOption
    public static void sharpen(RequestOptions options) {
        options.set(Option.memory(Keys.SHARPEN), true);
    }

    @GlideOption
    public static void w(RequestOptions options, int width) {
        options.set(Option.memory(Keys.IMAGE_W), width);
    }

    @GlideOption
    public static void h(RequestOptions options, int height) {
        options.set(Option.memory(Keys.IMAGE_H), height);
    }

    @GlideOption
    public static void size(RequestOptions options, int width, int height) {
        options.set(Option.memory(Keys.IMAGE_W), width);
        options.set(Option.memory(Keys.IMAGE_H), height);
    }

    @GlideOption
    public static void fixScale(RequestOptions options) {
        options.set(Option.memory(Keys.FIX_SCALE_W_H), true);
    }

    @GlideOption
    public static void fitWHMin(RequestOptions options) {
        options.set(Option.memory(Keys.FIT_W_H_MIN), true);
    }

    @GlideOption
    public static void fitWHMax(RequestOptions options) {
        options.set(Option.memory(Keys.FIT_W_H_MAX), true);
    }

    @GlideOption
    public static void zoomOut(RequestOptions options) {
        options.set(Option.memory(Keys.ZOOM_OUT), true);
    }

    @GlideOption
    public static void zoomIn(RequestOptions options) {
        options.set(Option.memory(Keys.ZOOM_IN), true);
    }

    @GlideOption
    public static void fitView(RequestOptions options) {
        options.set(Option.memory(Keys.FIT_VIEW), true);
    }

    @GlideOption
    public static void fitViewWidth(RequestOptions options) {
        options.set(Option.memory(Keys.FIT_VIEW_WIDTH), true);
    }

    @GlideOption
    public static void fitViewHeight(RequestOptions options) {
        options.set(Option.memory(Keys.FIT_VIEW_HEIGHT), true);
    }

    @GlideOption
    public static void autoSize(RequestOptions options) {
        options.set(Option.memory(Keys.AUTO_SIZE), true);
    }

    @GlideOption
    public static void debug(RequestOptions options) {
        options.set(Option.memory(Keys.DEBUG), true);
    }
}
