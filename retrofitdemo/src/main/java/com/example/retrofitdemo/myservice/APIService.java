package com.example.retrofitdemo.myservice;

import com.example.retrofitdemo.tools.GsonTool;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhangyi on 2016/6/6.
 */
public class APIService {
    private static final String GITHUB_BASEURL="https://api.github.com/";
    private static final String KUTING_BASEURL="http://mi.kting.cn/api/";
    private static class GitHubSingleInstance{
        public static final Retrofit RETROFIT=new Retrofit.Builder()
                .baseUrl(GITHUB_BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonTool.getGsonInstance()))
                .build();

    }
    private static class KuTingSingleInstance{
        public static final Retrofit RETROFIT=new Retrofit.Builder()
                .baseUrl(KUTING_BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonTool.getGsonInstance()))
                .build();

    }

    public static GitHubService getGitHubService(){
        GitHubService gitHubService=GitHubSingleInstance.RETROFIT.create(GitHubService.class);
        return gitHubService;
    }
    public static KuTingService getKuTingService(){
        KuTingService kuTingService=KuTingSingleInstance.RETROFIT.create(KuTingService.class);
        return kuTingService;
    }


}
