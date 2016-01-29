package com.zy.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * @author 网上的鸿洋
 *原理是利用抽屉的ViewDragHelper类
 * TODO  构造一个在这个group里面的view都可以拖动的viewgroup
 * 
 */
public class DragViewGroup extends LinearLayout{
	private Context context;
	private ViewDragHelper viewDragHelper;
	private DragViewGroup dragViewGroup;
	private View view1,view3,view2;
	private View releaseView;


	@SuppressLint("NewApi") 
	public DragViewGroup(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context=context;
		initView();
	}

	public DragViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context=context;
		initView();
	}

	public DragViewGroup(Context context) {
		super(context);
		this.context=context;
		initView();
	}
	private void initView() {
		dragViewGroup=this;
		viewDragHelper=ViewDragHelper.create(this, 1.0f, new Callback() {
			
			@Override
			public boolean tryCaptureView(View child, int pointerId) {
				Log.i("zy", "----------tryCaptureView-------pointerId--"+pointerId);
				return true;
			}

			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx) {
				 final int leftBound = getPaddingLeft();
	                final int rightBound = getWidth()  - leftBound;

	                final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
	                Log.i("zy", "----------clampViewPositionHorizontal---------left------"+left);
	                Log.i("zy", "----------clampViewPositionHorizontal----------dx-----"+dx);

	                return left;
			}

			@Override
			public int clampViewPositionVertical(View child, int top, int dy) {
				Log.i("zy", "----------clampViewPositionVertical----------top-----"+top);
				Log.i("zy", "----------clampViewPositionVertical----------dy-----"+dy);
				return top;
			}
			
			
			//在手指释放时回调
			@Override
			public void onViewReleased(View releasedChild, float xvel,
					float yvel) {
				releaseView=releasedChild;
				Log.i("zy", "----------onViewReleased----------xvel-----"+xvel);
				Log.i("zy", "----------onViewReleased----------yvel-----"+yvel);
			}
			
			
			//在边界拖动时回调
			@Override
			public void onEdgeDragStarted(int edgeFlags, int pointerId) {
				Log.i("zy", "----------onEdgeDragStarted----------edgeFlags-----"+edgeFlags);
				Log.i("zy", "----------onEdgeDragStarted----------pointerId-----"+pointerId);
				if(releaseView!=null){
					Log.i("zy", "----------onEdgeDragStarted----------releaseView-----"+releaseView.toString());
					
					viewDragHelper.captureChildView(releaseView, pointerId);
				}
			}
		});
		
		viewDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
		
	}
	
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return viewDragHelper.shouldInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		viewDragHelper.processTouchEvent(event);
		return true;
	}
	
	@Override
	public void computeScroll() {
		//super.computeScroll();
		if(viewDragHelper.continueSettling(true)){
			invalidate();
		}
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		view1=getChildAt(0);
		view2=getChildAt(1);
		view3=getChildAt(2);
	}
	

}
