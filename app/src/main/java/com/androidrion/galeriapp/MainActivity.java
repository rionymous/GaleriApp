package com.androidrion.galeriapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] GalleryImagesList = {
            R.drawable.fb, R.drawable.sc, R.drawable.line,
            R.drawable.tele, R.drawable.wa, R.drawable.tw,
            R.drawable.yt
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(R.drawable.fb);

        Gallery Imagegallery = findViewById(R.id.gallery);
        Imagegallery.setAdapter(new ImageAdapter(this));

        Imagegallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                imageView.setImageResource(GalleryImagesList[position]);
            }
        });
    }

    private class ImageAdapter extends BaseAdapter
    {
        Context context;
        ImageAdapter(Context context)
        {
            this.context = context;
        }
        @Override
        public int getCount()
        {
            return GalleryImagesList.length;
        }

        @Override
        public Object getItem(int position)
        {
            return GalleryImagesList[position];
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView = new ImageView(this.context);
            imageView.setImageResource(GalleryImagesList[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return imageView;
        }
    }
}
