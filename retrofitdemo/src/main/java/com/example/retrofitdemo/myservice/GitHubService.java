package com.example.retrofitdemo.myservice;

import com.example.retrofitdemo.bean.User;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zhangyi on 2016/6/6.
 */
public interface GitHubService {

    @GET("users/{user}")
    Call<User> getUserInfo(@Path("user")String user);

    @GET("users/{user}")
    Observable<User> getUserInfoRX(@Path("user")String user);

}
