package com.zy.sdtest;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;

/**
 * @author zhangyi
 *
 * TODO  log工具类，打包时会自动把toggle置成false，方便打开或关闭log，
 * 	无须手动更改
 */
public class LogKT {
	/**
	 * 是否开启log
	 */
	private static boolean toggle=true;
	
	public static void zy(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("zy", info);
		}
		
	}
	public static void xs(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("xs", info);
		}
	}
	public static void xl(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("xl", info);
		}
	}
	/**
	 * 打印当前activity的名称
	 * @param info
	 */
	public static void activity_name(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("activity_name", info);
		}
	}
	/**
	 * 测试activity的生命周期
	 * @param info
	 */
	public static void life(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("life", info);
		}
	}
	/**
	 * 一般的info
	 * @param info
	 */
	public static void info(String info){
		if(!TextUtils.isEmpty(info)&&toggle){
			Log.i("info", info);
		}
	}
	
	/**
	 * 打印url
	 * @param url
	 */
	public static void url(String url){
		if(!TextUtils.isEmpty(url)&&toggle){
			Log.i("url", url);
		}
	}
	
	 /**
	  * 判断当前程序是否处于debug状态,true为debug状态
	 * @param context
	 * @return
	 */
	public static boolean isApkDebugable(Context context) {
	        try {
	            ApplicationInfo info= context.getApplicationInfo();
	                return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
	        } catch (Exception e) {
	            
	        }
	        return false;
	    }
	public static void setLogModel(Context context){
		  try {
	            ApplicationInfo info= context.getApplicationInfo();
	             if( (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0){
	            	 toggle=true;
	            	 info("toggle=true");
	             }else{
	            	 toggle=false;
	            	 info("toggle=false");
	             }
	        } catch (Exception e) {
	            toggle=true;
	        }
	}

}
