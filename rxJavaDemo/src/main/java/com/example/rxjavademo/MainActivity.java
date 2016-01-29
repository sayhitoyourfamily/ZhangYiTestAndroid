package com.example.rxjavademo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
	private List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.clear();
        //setContentView(R.layout.activity_main);
        LogKT.zy(Environment.getRootDirectory().getAbsolutePath());
        LogKT.zy(Environment.getExternalStorageDirectory().getAbsolutePath());
        LogKT.zy(Environment.getDataDirectory().getAbsolutePath());
        LogKT.zy(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        showRxJava(new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/kting"));
    }
    
    public void showRxJava(File file){
    	if(file!=null){
    		Observable.from(file.listFiles())
    							.flatMap(new Func1<File, Observable<File>>() {

									@Override
									public Observable<File> call(File file) {
										LogKT.zy("----flatMap---------Observable<File>------");
										if(file==null||file.listFiles()==null){
											return null;
										}
										return Observable.from(file.listFiles());
									}
								})
								.filter(new Func1<File, Boolean>() {

									@Override
									public Boolean call(File file) {
										LogKT.zy("----filter---------Func1------");
										if(file.getName()==null){
											return false;
										}
										return file.getName().endsWith(".png");
									}
								})
								.map(new Func1<File, String>() {

									@Override
									public String call(File file) {
										LogKT.zy("----map---------Func1------");
										return file.getName();
									}
								})
								.subscribe(new Action1<String>() {
									@Override
									public void call(String str) {
										LogKT.zy("----subscribe---------Action1------list.size()----"+list.size());
										list.add(str);
									}
								})
								;
    	}
    }
    
    public void observerDemo(){
    	Observer<String> observer=new Observer<String>() {
			
			@Override
			public void onNext(String s) {
				LogKT.zy("-------onNext-------------");
			}
			
			@Override
			public void onError(Throwable e) {
				LogKT.zy("-------onError-------------");
			}
			
			@Override
			public void onCompleted() {
				LogKT.zy("-------onCompleted-------------");
			}
		};
		
		Subscriber<String> subscriber=new Subscriber<String>() {
			
			@Override
			public void onNext(String s) {
				
			}
			
			@Override
			public void onError(Throwable e) {
				
			}
			
			@Override
			public void onCompleted() {
				
			}
		};
    }
    
}
