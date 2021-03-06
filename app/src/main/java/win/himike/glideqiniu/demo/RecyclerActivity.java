package win.himike.glideqiniu.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RecyclerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ImageAdapter());
    }

    class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            GlideApp.with(holder.mImageView.getContext())
                    .load("http://7xjww9.com1.z0.glb.clouddn.com/20130221114001385.jpg")
                    .fitView()
                    .into(holder.mImageView);
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.item_image);
            }
        }
    }
}