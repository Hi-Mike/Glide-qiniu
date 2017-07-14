package win.himike.glideqiniu.module;

import android.content.Context;

import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.InputStream;

import win.himike.glideqiniu.module.QiniuUrlLoader;
import win.himike.glideqiniu.module.QiniuUrlModel;

/**
 * Created by HiMike on 2017/7/14.
 */

@GlideModule
public class QiniuAppGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Registry registry) {
        super.registerComponents(context, registry);
        registry.append(QiniuUrlModel.class, InputStream.class, new QiniuUrlLoader.Factory());
    }
}
