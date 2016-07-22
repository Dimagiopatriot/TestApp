package com.smishniy.android.testapp.view.model;

import com.smishniy.android.testapp.view.BaseView;

/**
 * Created by User on 21.07.2016.
 */
public class BaseViewModel<T extends BaseView> {

    public T view;

    public void attachView(T t) {
        view = t;
    }

    public void detachView() {
        view = null;
    }
}
