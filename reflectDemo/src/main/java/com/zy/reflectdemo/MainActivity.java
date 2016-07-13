package com.zy.reflectdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class MainActivity extends Activity {
	private Class<?> demo1=null;
	private Class<?> demo2=null;
	private Class<?> demo3=null;
	private Class<?> demo4;
	private Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        try {
			demo1=Class.forName("com.zy.reflectdemo.MainActivity");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			demo1=SharedPreferences.class;
		}
        demo2=new MainActivity().getClass();
        demo3=MainActivity.class;
        try {
        	demo4=Class.forName("com.zy.reflectdemo.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        try {
			person=(Person) demo4.newInstance();
			person.setName("sss");
			LogKT.zy("demo4------111111----"+person.toString());
			Field phone=demo4.getDeclaredField("phone");
			//phone.set(person, "222222");
			LogKT.zy("demo4------222222----"+person.toString());
			phone.setAccessible(true);
			phone.set(person, "333333333");
			LogKT.zy("demo4------3333333----"+person.toString());
			Constructor<?>[] cs=demo4.getConstructors();
			for(Constructor name:cs){
				LogKT.zy("demo4------Constructor----"+name);
			}
			Field[]  fields=demo4.getDeclaredFields();
			for(Field fs:fields){
				LogKT.zy("demo4------getDeclaredFields----"+fs);
				int m=fs.getModifiers();
				String ms=Modifier.toString(m);
				LogKT.zy("demo4------getDeclaredFields----ms---"+ms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
        
        
        LogKT.zy("demo1----------"+demo1.getName());
        LogKT.zy("demo2----------"+demo2.getName());
        LogKT.zy("demo3----------"+demo3.getName());
        try {
			Method method=demo4.getDeclaredMethod("sayHi", null);
			method.setAccessible(true);
			method.invoke(person, null);
			Method method2=demo4.getDeclaredMethod("sayHi", String.class);
			method2.setAccessible(true);
			method2.invoke(person, "haha");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
