package com.smishniy.android.testapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.smishniy.android.testapp.R;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 22.07.2016.
 */
public class FullImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        Intent intent = getIntent();

        String url = intent.getExtras().getString("imageUrl");

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        Picasso.with(getApplicationContext()).load(url).into(imageView);
    }
}
