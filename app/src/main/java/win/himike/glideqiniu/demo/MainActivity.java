package win.himike.glideqiniu.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import win.himike.glideqiniu.Format;
import win.himike.glideqiniu.GlideApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GlideApp.with(this)
                .load("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg")
                .format(Format.webp)
                .into((ImageView) findViewById(R.id.image));
    }
}
