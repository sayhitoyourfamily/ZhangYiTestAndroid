package com.zy.switchdayandnight;

import com.zy.switchdayandnight.base.BaseActivity;
import com.zy.switchdayandnight.tools.UIMode;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


/**
 * @author zhangyi
 *
 * TODO  如何优雅的切换夜间模式
 * 					参考： https://mp.weixin.qq.com/s?__biz=MzA4MjU5NTY0NA==&mid=401740657&idx=1&sn=8e6727fbe094ea42d5fd80b185a49395&scene=1&srcid=01042xVJNz7KY68UKWpt6hv3&key=41ecb04b05111003cc9f6c04989d4f60e7b6241f3865700c7cb5510015a444599ca898fb06d5fbfc6363ab952e9316c8&ascene=0&uin=MTYzMjY2MTE1&devicetype=iMac+MacBookPro10%2C1+OSX+OSX+10.11.2+build(15C50)&version=11020201&pass_ticket=o%2FTSzpu0SSmOb7T9xPBrU0Rpqhpr4qF1AdRauuFWC4M%3D
 */
public class MainActivity extends BaseActivity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   
    public void changUIMode(View view){
    	UIMode.ISNIGHT=!UIMode.ISNIGHT;
    	rootview.setBackgroundColor(UIMode.getResId(Color.WHITE));
    }
    @Override
    protected void onResume() {
    	super.onResume();
    	rootview.setBackgroundColor(Color.BLUE);
    }
}
