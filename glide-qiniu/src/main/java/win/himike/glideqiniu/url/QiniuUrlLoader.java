package win.himike.glideqiniu.url;

import android.util.Log;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

import win.himike.glideqiniu.extension.Keys;

public class QiniuUrlLoader extends BaseGlideUrlLoader<String> {

    protected QiniuUrlLoader(ModelLoader<GlideUrl, InputStream> concreteLoader) {
        super(concreteLoader);
    }

    @Override
    protected String getUrl(String s, int width, int height, Options options) {
        String url = String.format("%s%s", s, QiniuUrlModel.buildQiniuSuffix(options, width, height));
        if (options.get(Option.memory(Keys.DEBUG, false))) {
            Log.d("QiniuUrlLoader",
                    "ImageSize(" + width + "," + height + ")-- " + url + " --");
        }
        return url;
    }


    @Override
    public boolean handles(String s) {
        return true;
    }

    public static class Factory implements ModelLoaderFactory<String, InputStream> {

        @Override
        public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new QiniuUrlLoader(multiFactory.build(GlideUrl.class, InputStream.class));
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }
}