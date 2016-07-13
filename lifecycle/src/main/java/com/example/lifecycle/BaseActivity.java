package com.example.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.Window;

/**
 * 
 * activity的基类，被嵌套在ActivityGroup的所有activity都必须继承KtingBaseActivity
 * 
 * 除第三方activity外
 * 
 * @author Administrator
 * 
 */
public class BaseActivity extends AppCompatActivity {
	protected Context context=this;


	/**
	 * 生命周期方法onCreate
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		LogKT.activity_name(getClass().getName());
		LogKT.life(getClass().getName() + "---------onCreate");
		LogKT.life( "getTaskId----------"+getTaskId());
	}

	/**
	 * 生命周期方法onStart
	 */
	@Override
	protected void onStart() {
		LogKT.life(getClass().getName() + "---------onStart");
		super.onStart();
	}

	/**
	 * 生命周期方法onRestart
	 */
	@Override
	protected void onRestart() {
		LogKT.life(getClass().getName() + "---------onRestart");

		super.onRestart();
	}


	/**
	 * 生命周期方法onResume
	 */
	@Override
	protected void onResume() {
		LogKT.life(getClass().getName() + "---------onResume");

		super.onResume();


	}



	/**
	 * 生命周期方法onPause
	 */
	@Override
	protected void onPause() {
		LogKT.life(getClass().getName() + "---------onPause");

		super.onPause();

	}

	/**
	 * 生命周期方法onStop
	 */
	@Override
	protected void onStop() {
		LogKT.life(getClass().getName() + "---------onStop");


		super.onStop();
	}

	/**
	 * 生命周期方法onDestroy
	 */
	@Override
	protected void onDestroy() {
		LogKT.life(getClass().getName() + "---------onDestroy");

		super.onDestroy();
	}


	@Override
	public void finish() {
		LogKT.life(getClass().getName() + "---------finish");
		super.finish();
	}

	@Override
	protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
		LogKT.life(getClass().getName() + "---------onApplyThemeResource");
		super.onApplyThemeResource(theme, resid, first);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		LogKT.life(getClass().getName() + "---------onPostCreate");
		super.onPostCreate(savedInstanceState);
	}


	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		LogKT.life(getClass().getName() + "---------onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}


	@Override
	protected void onUserLeaveHint() {
		LogKT.life(getClass().getName() + "---------onUserLeaveHint");
		super.onUserLeaveHint();
	}

	@Override
	public void onAttachedToWindow() {
		LogKT.life(getClass().getName() + "---------onAttachedToWindow");
		super.onAttachedToWindow();
	}

	@Override
	public void onContentChanged() {
		LogKT.life(getClass().getName() + "---------onContentChanged");
		super.onContentChanged();
	}

	@Override
	public void onDetachedFromWindow() {
		LogKT.life(getClass().getName() + "---------onDetachedFromWindow");
		super.onDetachedFromWindow();
	}

	@Override
	public void onAttachFragment(Fragment fragment) {
		LogKT.life(getClass().getName() + "---------onAttachFragment");
		super.onAttachFragment(fragment);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
		LogKT.life(getClass().getName() + "---------onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState, persistentState);
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		LogKT.life(getClass().getName() + "---------onSaveInstanceState");
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		LogKT.life(getClass().getName() + "---------onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		LogKT.life(getClass().getName() + "---------onLowMemory");
		super.onLowMemory();
	}

	@Override
	protected void onPostResume() {
		LogKT.life(getClass().getName() + "---------onPostResume");
		super.onPostResume();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		LogKT.life(getClass().getName() + "---------onWindowFocusChanged");
		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		LogKT.life(getClass().getName() + "---------onNewIntent");
		super.onNewIntent(intent);
	}

}
