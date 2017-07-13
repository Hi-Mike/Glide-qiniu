package win.himike.glideqiniu;

import android.util.Log;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;

import java.io.InputStream;

public class ImageSizeUrlLoader extends BaseGlideUrlLoader<String> {

    protected ImageSizeUrlLoader(ModelLoader<GlideUrl, InputStream> concreteLoader) {
        super(concreteLoader);
    }

    @Override
    protected String getUrl(String s, int width, int height, Options options) {
        String url = s + "?imageMogr2/auto-orient/blur/40x20/format/" + options.get(Option.memory(Keys.FORMAT));
        Log.d("ImageSizeUrlLoader", url + " " + options.toString());
        return "https://odum9helk.qnssl.com/resource/gogopher.jpg?imageMogr2/blur/3x5";
    }


    @Override
    public boolean handles(String s) {
        return true;
    }

    public static class Factory implements ModelLoaderFactory<String, InputStream> {

        @Override
        public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiFactory) {
            return new ImageSizeUrlLoader(multiFactory.build(GlideUrl.class, InputStream.class));
        }

        @Override
        public void teardown() {
            // Do nothing.
        }
    }
}