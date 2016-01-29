package com.zy.ndkdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * @author zhangyi
 *
 * TODO  JNI的demo
 */
public class MainActivity extends Activity implements OnClickListener {

	private double a=3;
	private double b=6;
	private int[] array;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        array=new int[]{1,2,3,4,5,6,7,8,9,10};
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt:
			//array=JNI.getIntArray(5);
			
			Toast.makeText(getApplicationContext(), "hh---"+JNI.ad(3, 10, 100), Toast.LENGTH_SHORT).show();
			//Toast.makeText(getApplicationContext(), "hh---"+array[0], 2000).show();
			break;

		default:
			break;
		}
	}

}
