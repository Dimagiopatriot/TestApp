package com.smishniy.android.testapp.model.data;

import android.util.Log;

import com.smishniy.android.testapp.model.api.RestApiManager;
import com.smishniy.android.testapp.model.pojo.Photo;
import com.smishniy.android.testapp.model.pojo.ResponsePopular;
import com.smishniy.android.testapp.model.utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 21.07.2016.
 */
public class ImageData {

    public void getData(Integer mPage, final com.smishniy.android.testapp.model.api.Callback<List<Photo>> photos){
        String imageType = "popular";
        RestApiManager restApiManager = new RestApiManager();
        Call<ResponsePopular> call = restApiManager.getImageAPI().getPhoto(imageType, Constants.CONSUMER_KEY,
                mPage);
        call.enqueue(new Callback<ResponsePopular>() {
            @Override
            public void onResponse(Call<ResponsePopular> call, Response<ResponsePopular> response) {
                if (response.isSuccessful()) {
                    photos.t(response.body().getPhotoList());
                    Log.e("Response", "good");
                } else {
                    Log.e("Response", "fail");
                }
            }

            @Override
            public void onFailure(Call<ResponsePopular> call, Throwable t) {
                Log.e("Failure message","response is fail");
            }
        });
    }

}
