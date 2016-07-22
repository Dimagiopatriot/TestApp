package com.smishniy.android.testapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 21.07.2016.
 */
public class Photo {
    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

}
