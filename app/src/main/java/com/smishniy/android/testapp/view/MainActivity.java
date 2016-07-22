package com.smishniy.android.testapp.view;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smishniy.android.testapp.R;
import com.smishniy.android.testapp.model.adapter.ImageAdapter;
import com.smishniy.android.testapp.model.pojo.Photo;
import com.smishniy.android.testapp.view.model.ViewModelImageRetrieving;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewModelImageRetrieving.View {

    ImageAdapter imageAdapter;

    TextView textView;
    GridView gridView;
    Integer currentPage;

    ViewModelImageRetrieving modelImageRetrieving = new ViewModelImageRetrieving();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.page_changer);
        if (isOnline()){
            linearLayout.setVisibility(View.VISIBLE);
            initViews();
        } else {
            linearLayout.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Turn on Internet and restart the app", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        modelImageRetrieving.detachView();
    }
    @Override
    public Integer getPageNumber() {
        return currentPage;
    }

    @Override
    public void setListPhoto(List<Photo> photoList) {
        imageAdapter.setPhotos(photoList);
        gridView.setAdapter(imageAdapter);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    public void onClickNextPage(View v){
        currentPage = currentPage+1;
        textView.setText(currentPage.toString());
        modelImageRetrieving.imagesRetrieve();
    }
    public void onClickPreviousPage(View v){
        if (currentPage>1){
            currentPage = currentPage-1;
            textView.setText(currentPage.toString());
            modelImageRetrieving.imagesRetrieve();
        }
    }

    private void initViews(){
        gridView = (GridView)findViewById(R.id.gridView1);
        textView = (TextView) findViewById(R.id.page_number);
        currentPage = Integer.valueOf(textView.getText().toString());


        modelImageRetrieving.attachView(this);
        imageAdapter = new ImageAdapter(getApplicationContext());
        modelImageRetrieving.imagesRetrieve();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(getApplicationContext(), FullImageActivity.class);

                intent.putExtra("imageUrl", imageAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }

    private boolean isOnline(){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
}