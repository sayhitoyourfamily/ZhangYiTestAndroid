package com.example.animatordemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * @author zhangyi
 *
 * TODO  让自定义的imageview跟随手指移动
 */
public class MoveView extends ImageView{

	public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public MoveView(Context context, AttributeSet attrs) {
		super(context, attrs); 
		init();
	}

	public MoveView(Context context) {
		super(context);
		init();
	}
	
	private void init() {
		
	}

	
	public void updateLocation(int x,int y){
		x=x-getWidth()/2;
		y=y-getHeight()/2;
		setX(x);
		setY(y);
	}
	
}
