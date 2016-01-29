package com.zy.switchdayandnight.tools;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Color;

/**
 * @author zhangyi
 *
 * TODO  UI主题设置
 */
public class UIMode {
	/**
	 * 是否是夜间模式
	 */
	public static boolean ISNIGHT=false;
	
	private static Map<Integer, Integer> resMap;
	
	/**
	 * @param defaultId
	 * @return	使用该方法获资源ID，包含夜间模式的判断
	 */
	public static int getResId(int defaultId){
		if(!ISNIGHT){
			return defaultId;
		}
		if(resMap==null){
			buildResourceMap();
		}
		try {
			return resMap.get(defaultId);
		} catch (Exception e) {
			e.printStackTrace();
			return defaultId;
		}
	}

	/**
	 * 建立夜间资源ID对应的MAP
	 * 通过HashMap将白天模式的resId和夜间模式的resId来一一对应起来
	 */
	private static void buildResourceMap() {
		resMap=new HashMap<Integer, Integer>();
		resMap.put(Color.WHITE, Color.BLACK);
	}
	
	
	
	
	

}
