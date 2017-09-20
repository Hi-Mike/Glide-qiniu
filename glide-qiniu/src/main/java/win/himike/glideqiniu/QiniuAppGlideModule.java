package win.himike.glideqiniu;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.LibraryGlideModule;

import java.io.InputStream;

import win.himike.glideqiniu.url.QiniuUrlLoader;

/**
 * Created by HiMike on 2017/7/14.
 */

@GlideModule
public class QiniuAppGlideModule extends LibraryGlideModule {

    @Override public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
        registry.prepend(String.class, InputStream.class, new QiniuUrlLoader.Factory());
    }
}
