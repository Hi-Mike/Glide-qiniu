package win.himike.glideqiniu.demo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import win.himike.glideqiniu.extension.Format;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlideApp.with(this)
                .load("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg")
                .format(Format.webp)
                .blur(20, 20)
                .fitView().transition(DrawableTransitionOptions.withCrossFade())
                .skipMemoryCache(true)
                .into((ImageView) findViewById(R.id.image));
        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });
        GlideApp.with(this).asDrawable()
                .load("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg")
                .format(Format.webp)
                .size(200, 200)
                .fitWHMax()
                .into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        ((ImageView) findViewById(R.id.image1)).setImageDrawable(resource);
                    }
                });
    }
}
