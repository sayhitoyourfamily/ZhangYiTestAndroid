package com.zy.view;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
/**
 * @version 1.0
 * @author Fay
 * @since 2014/8/28
 */
@SuppressLint("NewApi")
public class SlidingBackLinearLayout extends LinearLayout {
  private int xLastTouchLocation;
  private int xCurrentTouchLocation;
  private int detaX;
  private boolean isClose = false;
  private int windowWidth ;
  private Scroller mScroller = null;
  private Interpolator mInterpolator = null; 
  private FinishCallBack mFinishCallBack = null;
  
  public SlidingBackLinearLayout(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    // TODO Auto-generated constructor stub
    init(context);
  }

  public SlidingBackLinearLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    // TODO Auto-generated constructor stub
    init(context);
  }

  public SlidingBackLinearLayout(Context context) {
    super(context);
    // TODO Auto-generated constructor stub
    init(context);
  }
  
  private void init(Context mContext) {
    mInterpolator = new DecelerateInterpolator();
    mScroller = new Scroller(mContext, mInterpolator);
    DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    WindowManager mWindowManager = (WindowManager) mContext.getSystemService(mContext.WINDOW_SERVICE);
    mWindowManager.getDefaultDisplay().getMetrics(mDisplayMetrics);
    windowWidth = mDisplayMetrics.widthPixels;
  }
  
  public interface FinishCallBack{
    void finish();
  }
  
  public void setFinishCallBack(FinishCallBack mFinishCallBack) {
    this.mFinishCallBack = mFinishCallBack;
  }
  
  @Override
  protected void onDraw(Canvas canvas) {
    // TODO Auto-generated method stub
    super.onDraw(canvas);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    // TODO Auto-generated method stub
    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
      xLastTouchLocation = (int) event.getX();
      return true;
    case MotionEvent.ACTION_MOVE:
      xCurrentTouchLocation = (int) event.getX();
      detaX = xLastTouchLocation - xCurrentTouchLocation;
      if (detaX < 0) {
        if (null != mFinishCallBack) {
          scrollTo( detaX, 0);
        }
      }
      break;
    case MotionEvent.ACTION_UP:
      xCurrentTouchLocation = (int) event.getX();
      detaX = xLastTouchLocation - xCurrentTouchLocation;
      if (detaX < 0) {
        if (null != mFinishCallBack) {
          if (- detaX >= windowWidth / 2) {
            // close
            isClose = true;
            startMove( -(windowWidth + detaX));
          } else {
            startMove(- detaX);
          }
        }
      }
      break;
    }
    return super.onTouchEvent(event);
  }
  
  private void startMove(int deta) {
    mScroller.startScroll(getScrollX(), 0, deta, 0);
    invalidate();
  }

  @Override
  public void computeScroll() {
    // TODO Auto-generated method stub
    super.computeScroll();
    if (mScroller.computeScrollOffset()) {
      scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
      postInvalidate();
    } else {
      if (isClose) {
        if (null != mFinishCallBack) {
          mFinishCallBack.finish();
        }
      }
    }
  }

}