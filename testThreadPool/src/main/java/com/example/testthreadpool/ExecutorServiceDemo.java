package com.example.testthreadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class ExecutorServiceDemo {
	private ExecutorService fixedExecutorService = Executors
			.newFixedThreadPool(3);

	public void go() {
		for (int k = 0; k < 10; k++) {
			LogKT.zy("for-------------------" + k);
			fixedExecutorService.submit(new Runnable() {

				@Override
				public void run() {
					int i = 0;
						LogKT.zy("submit---Runnable-----run---"
								+ Thread.currentThread().getName() + "---------" + i);
						i++;
						/*try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							LogKT.zy("submit---Runnable-----run---"
									+ Thread.currentThread().getName() + "------InterruptedException---" + i);
							e.printStackTrace();
						}*/
						
						HttpUtils httpUtils=new HttpUtils();
						httpUtils.send(HttpMethod.GET, "http://www.google.com", new RequestCallBack<String>() {

							@Override
							public void onFailure(HttpException arg0,
									String arg1) {
								LogKT.zy("------onFailure-----");
							}

							@Override
							public void onSuccess(ResponseInfo<String> arg0) {
								LogKT.zy("------onSuccess-----");
							}
						});
					}
			});
		}
		fixedExecutorService.shutdown();
		boolean flag=false;
		try {
			flag=fixedExecutorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LogKT.zy("------awaitTermination------InterruptedException-----");
		}
		if(flag){
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         success");
		}else{
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         falied");
		}
	}
	
	public void go2() {
		for (int k = 0; k < 10; k++) {
			LogKT.zy("for-------------------" + k);
			if(k>4){
				fixedExecutorService.shutdown();
			}

			try {
				fixedExecutorService.submit(new Runnable() {

					@Override
					public void run() {
						int i = 0;
						while (true) {
							LogKT.zy("submit---Runnable-----run---"
									+ Thread.currentThread().getName() + "---------" + i);
							i++;
							try {
								Thread.sleep(5000);
							} catch (InterruptedException e) {
								LogKT.zy("submit---Runnable-----run---"
										+ Thread.currentThread().getName() + "------InterruptedException---" + i);
								e.printStackTrace();
							}
							if(i>2){
								break;
							}
							
						}
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fixedExecutorService.shutdown();
		boolean flag=false;
		try {
			flag=fixedExecutorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LogKT.zy("------awaitTermination------InterruptedException-----");
		}
		if(flag){
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         success");
		}else{
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         falied");
		}
		
	}
	public void go3() {
		for (int k = 0; k < 3; k++) {
			LogKT.zy("for-------------------" + k);

			fixedExecutorService.submit(new Runnable() {

				@Override
				public void run() {
					int i = 0;
					while (true) {
						LogKT.zy("submit---Runnable-----run---"
								+ Thread.currentThread().getName() + "---------" + i);
						i++;
					}
					}
			});
		}
		fixedExecutorService.shutdownNow();
		boolean flag=false;
		try {
			flag=fixedExecutorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			LogKT.zy("------awaitTermination------InterruptedException-----");
		}
		if(flag){
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         success");
		}else{
			LogKT.zy("------awaitTermination(3000, TimeUnit.MILLISECONDS-----         falied");
		}
		
	}

}
