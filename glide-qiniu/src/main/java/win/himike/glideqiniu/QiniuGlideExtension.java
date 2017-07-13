package win.himike.glideqiniu;

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
    public static void format(RequestOptions options, Format format) {
        options.getOptions().set(Option.memory(Keys.FORMAT, Format.origin), format);
    }
}
