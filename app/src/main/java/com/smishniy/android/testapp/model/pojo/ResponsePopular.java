package com.smishniy.android.testapp.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 21.07.2016.
 */
public class ResponsePopular {
    @SerializedName("photos")
    @Expose
    private List<Photo> photoList;

    public List<Photo> getPhotoList(){
        return photoList;
    }


}
