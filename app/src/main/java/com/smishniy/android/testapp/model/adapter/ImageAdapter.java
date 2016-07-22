package com.smishniy.android.testapp.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.smishniy.android.testapp.model.pojo.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 21.07.2016.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> imageUrls;
    private List<Photo> photos;

    public ImageAdapter(Context context){
        this.context=context;
    }

    private ArrayList<String> getUrlImagesString(){
        List<Photo> images = photos;
        ArrayList<String> imageUrls = new ArrayList<>();
        for (int i=0; i<images.size();i++) {
            imageUrls.add(images.get(i).getImageUrl());
        }
        return imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.size();
    }

    @Override
    public String getItem(int position) {
        return imageUrls.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        String url = getItem(position);
        Picasso.with(context).load(url).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        return imageView;
    }

    public void setPhotos(List<Photo>photoList){
        photos=photoList;
        imageUrls=getUrlImagesString();
    }
}
