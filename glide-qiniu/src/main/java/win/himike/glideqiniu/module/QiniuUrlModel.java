package win.himike.glideqiniu.module;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;

import win.himike.glideqiniu.Format;
import win.himike.glideqiniu.Keys;

/**
 * Created by mike on 17-7-14.
 */

public class QiniuUrlModel {
    private String url;

    public QiniuUrlModel(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private static final String BASE_SUFFIX = "?imageMogr2";

    public static String buildQiniuSuffix(Options options, int width, int height) {
        StringBuilder sb = new StringBuilder(BASE_SUFFIX);
        if (options.get(Option.memory(Keys.AUTO_ORIENT, true))) {
            sb.append("/auto-orient");
        }

        if (options.get(Option.memory(Keys.STRIP, false))) {
            sb.append("/strip");
        }

        int w = options.get(Option.memory(Keys.IMAGE_W, -1));
        int h = options.get(Option.memory(Keys.IMAGE_H, -1));
        Format format = options.get(Option.memory(Keys.FORMAT, Format.origin));
        if (options.get(Option.memory(Keys.FIX_SCALE_W_H, false))) {
            sb.append(w).append("x").append(h).append("!");
        } else if (options.get(Option.memory(Keys.FIT_VIEW, false))) {
            sb.append(width).append("x").append(height).append(">");
        } else if (options.get(Option.memory(Keys.FIT_VIEW_WIDTH, false))) {

        }

        int rotate;
        if ((rotate = options.get(Option.memory(Keys.ROTATE, -1))) != -1) {
            sb.append("/rotate/").append(rotate);
        }

        if (options.get(Option.memory(Keys.BLUR, false))) {
            int radius = options.get(Option.memory(Keys.BLUR_RADIUS, 10));
            int sigma = options.get(Option.memory(Keys.BLUR_SIGMA, 10));
            sb.append("/blur/").append(radius).append("x").append(sigma);
        }

        if (options.get(Option.memory(Keys.SHARPEN, false))) {
            sb.append("/sharpen/1");
        }

        if (format != Format.origin) {
            sb.append("/format/").append(format.toString());
        }

        return sb.toString();
    }
}