package com.example.retrofitdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.retrofitdemo.bean.User;
import com.example.retrofitdemo.myservice.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="zhangyi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getUserInfo();
        
    }

    private void getUserInfo() {
        Call<User> userCall=API.getGitHubService().getUserInfo("zhangyi");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG,"------onResponse-----message----"+response.message());
                Log.i(TAG,"------onResponse-----toString----"+response.toString());
                Log.i(TAG,"------onResponse------body---"+response.body());
                Log.i(TAG,"------onResponse------isSuccessful---"+response.isSuccessful());
                Log.i(TAG,"------onResponse------raw---"+response.raw());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.i(TAG,"------onFailure------raw---"+t.toString());
            }
        });
    }


}
