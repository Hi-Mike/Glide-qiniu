package win.himike.glideqiniu.url;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;

import win.himike.glideqiniu.extension.Format;
import win.himike.glideqiniu.extension.Keys;

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

        boolean autoSize = options.get(Option.memory(Keys.AUTO_SIZE, false));

        int w = options.get(Option.memory(Keys.IMAGE_W, -1));
        int h = options.get(Option.memory(Keys.IMAGE_H, -1));
        if (autoSize) {
            if (width < 200) {
                width = 200;
            } else if (width < 640) {
                width = 640;
            } else if (width < 1280) {
                width = 1280;
            }
        }
        Format format = options.get(Option.memory(Keys.FORMAT, Format.origin));
        if (options.get(Option.memory(Keys.FIX_SCALE_W_H, false))) {
            if (w > 0 && h > 0) {
                sb.append("/thumbnail/").append(w).append("x").append(h).append("!");
            }
        } else if (options.get(Option.memory(Keys.FIT_VIEW, false))) {
            if (width > 0 && height > 0) {
                sb.append("/thumbnail/").append(width).append("x").append(height).append("%3E");// %3E = URLEncoder.encoder(">", "utf-8")
            } else if (width > 0) {
                sb.append("/thumbnail/").append(width).append("x");
            } else if (height > 0) {
                sb.append("/thumbnail/").append("x").append(height);
            }
        } else if (options.get(Option.memory(Keys.FIT_VIEW_WIDTH, false))) {
            if (width > 0) {
                sb.append("/thumbnail/").append(width).append("x");
            }
        } else if (options.get(Option.memory(Keys.FIT_VIEW_HEIGHT, false))) {
            if (height > 0) {
                sb.append("/thumbnail/").append("x").append(height);
            }
        } else if (options.get(Option.memory(Keys.FIT_W_H_MIN, false))) {
            if (w > 0 && h > 0) {
                sb.append("/thumbnail/").append(w).append("x").append(h);
            } else {
                throw new IllegalArgumentException("Fit width and height min need set w and h");
            }
        } else if (options.get(Option.memory(Keys.FIT_W_H_MAX, false))) {
            if (w > 0 && h > 0) {
                sb.append("/thumbnail/").append("!").append(w).append("x").append(h).append("r");
            } else {
                throw new IllegalArgumentException("Fit width and height min need set w and h");
            }
        } else if (options.get(Option.memory(Keys.ZOOM_OUT, false))) {
            if (w > 0 && h > 0) {
                sb.append("/thumbnail/").append(w).append("x").append(h).append("%3E");
            } else {
                throw new IllegalArgumentException("Fit width and height min need set w and h");
            }
        } else if (options.get(Option.memory(Keys.ZOOM_IN, false))) {
            if (w > 0 && h > 0) {
                sb.append("/thumbnail/").append(w).append("x").append(h).append("<");
            } else {
                throw new IllegalArgumentException("Fit width and height min need set w and h");
            }
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

        if (format == Format.jpg) {
            int quality = options.get(Option.memory(Keys.JPG_QUALITY, -1));
            if (quality != -1) {
                sb.append("/quality/").append(quality);
            }
        }

        if (format != Format.origin) {
            sb.append("/format/").append(format.toString());
        }

        return sb.toString();
    }
}