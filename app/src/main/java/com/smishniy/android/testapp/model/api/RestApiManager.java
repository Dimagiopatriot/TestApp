package com.smishniy.android.testapp.model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smishniy.android.testapp.model.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 21.07.2016.
 */
public class RestApiManager {
    private PhotosAPI imageAPI;

    public PhotosAPI getImageAPI(){
        if (imageAPI==null){
            Gson gson = new GsonBuilder().create();
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(Constants.BASE_URL)
                    .build();
            imageAPI = retrofit.create(PhotosAPI.class);
        }
        return imageAPI;
    }
}
