package win.himike.glideqiniu.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

import win.himike.glideqiniu.Format;
import win.himike.glideqiniu.module.GlideApp;
import win.himike.glideqiniu.module.QiniuUrlModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlideApp.with(this)
                .load(new QiniuUrlModel("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg"))
                .format(Format.webp)
                .blur(2, 2)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into((ImageView) findViewById(R.id.image));
    }
}
