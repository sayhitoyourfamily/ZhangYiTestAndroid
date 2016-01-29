package com.example.animatordemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		SharedPreferences sp=getSharedPreferences("info", Context.MODE_PRIVATE);
        //sp.edit().putString("zhangyi", "111111").commit();
        LogKT.zy("MyApplication-------------"+sp.getString("zhangyi", "MyApplication000000"));
	}

}
