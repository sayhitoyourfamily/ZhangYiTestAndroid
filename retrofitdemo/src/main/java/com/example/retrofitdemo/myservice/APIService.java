package com.example.retrofitdemo.myservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangyi on 2016/6/6.
 */
public class APIService {
    private static final String BASEURL="https://api.github.com/";

    public static GitHubService getGitHubService(){
        Gson gson= new GsonBuilder()
                .setDateFormat("yyyy-MM-dd 'T' HH:mm:ss 'Z'")
                .create();
        Retrofit retrofit=new Retrofit.Builder()
                            .baseUrl(BASEURL)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
        GitHubService gitHubService=retrofit.create(GitHubService.class);
        return gitHubService;
    }


}
