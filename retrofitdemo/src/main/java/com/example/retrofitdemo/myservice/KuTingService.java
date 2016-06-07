package com.example.retrofitdemo.myservice;

import com.example.retrofitdemo.bean.CBaseBookVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangyi on 2016/6/7.
 */
public interface KuTingService {
    @GET("book/getBookInfoAd_4_9.action/{param}")
    Observable<CBaseBookVO> getBookInfoByRx(@Path("param")String param);
    @GET("book/getBookInfoAd_4_9.action")
    Call<CBaseBookVO> getBookInfo(@Query("param") String param);

}
