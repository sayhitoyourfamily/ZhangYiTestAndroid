package com.example.retrofitdemo.tools;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson工具类
 */
public class GsonTool {

	/**
	 * 利用的java语言特性，内部类只有在使用的时候才会去初始化，
	 * 而且这种方式是线程安全的，java虚拟机自动保证的
	 */
	private static class GsonSingleInstance{
		private static final Gson gson= new GsonBuilder()
				.setDateFormat("yyyy-MM-dd 'T' HH:mm:ss 'Z'")
				.create();
	}

	public static Gson getGsonInstance(){
		return GsonSingleInstance.gson;
	}

	/**
	 * Object转换为json
	 */
	public static String toJSON(Object entity) {
		try {
			if (entity == null) {
				return null;
			}
			return getGsonInstance().toJson(entity);
		} catch (Exception ex) {
			Log.e("json", " exception , " + ex.getMessage());
			return null;
		}
	}

}
