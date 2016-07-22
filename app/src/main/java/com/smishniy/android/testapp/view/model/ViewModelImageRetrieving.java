package com.smishniy.android.testapp.view.model;

import com.smishniy.android.testapp.model.api.Callback;
import com.smishniy.android.testapp.model.data.ImageData;
import com.smishniy.android.testapp.model.pojo.Photo;
import com.smishniy.android.testapp.view.BaseView;

import java.util.List;

/**
 * Created by User on 22.07.2016.
 */
public class ViewModelImageRetrieving extends BaseViewModel<ViewModelImageRetrieving.View> {

    ImageData imageData = new ImageData();

    public void imagesRetrieve(){
        imageData.getData(view.getPageNumber(), new Callback<List<Photo>>() {
            @Override
            public void t(List<Photo> photos) {
                if (view != null) {
                    view.setListPhoto(photos);
                }
            }
        });
    }

    public interface View extends BaseView{
        Integer getPageNumber();
        void setListPhoto(List<Photo> photoList);

    }
}
