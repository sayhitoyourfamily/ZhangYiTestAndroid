package com.example.testthreadpool;

import java.util.Iterator;
import java.util.List;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;

public class MyApplication extends Application{
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		 int pid = android.os.Process.myPid();
	     String processAppName = getAppName(pid);
	     if (processAppName == null
	             || !processAppName.equalsIgnoreCase("cn.com.kuting.activity")) {
	         // 则此application::onCreate 是被service 调用的，直接返回
	         return;
	     }
	}
	
	private String getAppName(int pID) {
        String processName = null;
        ActivityManager am = (ActivityManager) this
                .getSystemService(ACTIVITY_SERVICE);
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i
                    .next());
            LogKT.zy("info.processName--------------"+info.processName);
            try {
                if (info.pid == pID) {
                    CharSequence c = pm.getApplicationLabel(pm
                            .getApplicationInfo(info.processName,
                                    PackageManager.GET_META_DATA));
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception e) {
            }
        }
        return processName;
    }
	
	
}
