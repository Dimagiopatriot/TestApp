package com.smishniy.android.testapp.model.api;

import com.smishniy.android.testapp.model.pojo.ResponsePopular;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 21.07.2016.
 */
public interface PhotosAPI {

    @GET("v1/photos")
    Call<ResponsePopular> getPhoto(@Query("feature")String feature,
                                   @Query("consumer_key")String consumerKey,
                                   @Query("page")Integer page);

}
