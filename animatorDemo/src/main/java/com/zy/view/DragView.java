package com.zy.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author zhangyi
 *
 * TODO  DEMO,可拖拽的view,跟随手指移动
 */
public class DragView extends TextView{
	private Context context;
	/**
	 * 圆的中心坐标
	 */
	private float cx,cy;
	/**
	 *圆的半径
	 */
	private float radius=60;
	/**
	 * 画笔
	 */
	private Paint paint;
	
	
	public DragView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context=context;
		initView();
	}

	public DragView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
		initView();
	}

	public DragView(Context context) {
		super(context);
		this.context=context;
		initView();
	}

	@SuppressLint("NewApi") private void initView() {
		cx=500;
		cy=500;
		radius=100;
		//初始化画笔，用来绘制view
		paint=new Paint();
		//设置抗锯齿
		paint.setAntiAlias(true);
		//设置颜色
		paint.setColor(Color.BLACK);
		setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "I can be dragged ", 500).show();
			}
		});
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawCircle(cx, cy, radius, paint);
	}
	
	public void updatePosition(float x,float y){
		//更新圆心的坐标
		cx=x;
		cy=y;
		//强制重绘view，会调用onDraw方法重新绘制
		invalidate();
	}
	
}
