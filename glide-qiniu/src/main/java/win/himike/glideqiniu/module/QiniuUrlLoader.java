package win.himike.glideqiniu.module;

import android.util.Log;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

import win.himike.glideqiniu.Keys;

public class QiniuUrlLoader extends BaseGlideUrlLoader<QiniuUrlModel> {

    protected QiniuUrlLoader(ModelLoader<GlideUrl, InputStream> concreteLoader) {
        super(concreteLoader);
    }

    @Override
    protected String getUrl(QiniuUrlModel s, int width, int height, Options options) {
        String url = s.getUrl() + QiniuUrlModel.buildQiniuSuffix(options, width, height);
        Log.d("QiniuUrlLoader", url + " " + options.toString());
        return url;
    }


    @Override
    public boolean handles(QiniuUrlModel s) {
        return true;
    }

    public static class Factory implements ModelLoaderFactory<QiniuUrlModel, InputStream> {

        @Override
        public ModelLoader<QiniuUrlModel, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new QiniuUrlLoader(multiFactory.build(GlideUrl.class, InputStream.class));
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }
}