package com.zy.switchdayandnight.base;

import com.zy.switchdayandnight.R;
import com.zy.switchdayandnight.tools.UIMode;

import android.app.UiModeManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class BaseActivity extends FragmentActivity {
	/**
	 * 当前页面的根布局
	 */
	public  View rootview;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	@Override
	protected void onStart() {
		super.onStart();
		if(rootview==null){
			rootview=findViewById(R.id.rootview);
		}
	}

}
