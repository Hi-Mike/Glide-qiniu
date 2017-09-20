package win.himike.glideqiniu.demo;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by HiMike on 2017/7/15.
 */

@GlideModule
public class TestGlideModule extends AppGlideModule {
    @Override public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
    }
}
