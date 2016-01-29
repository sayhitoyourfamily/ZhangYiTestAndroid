package com.example.animatordemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.JetPlayer.OnJetEventListener;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.animatordemowo.R;
import com.zy.view.SlidingBackLinearLayout;
import com.zy.view.SlidingBackLinearLayout.FinishCallBack;

/**
 * @author zhangyi
 *
 * TODO  属性动画demo之ObjectAnimator
 */
public class AnimatorActivity extends Activity
{
	private int scale=1;
	private View mBlueBall;
	private SlidingBackLinearLayout mBackLinearLayout = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	    setScrernOrtation();
		setContentView(R.layout.xml_for_anim);
		mBlueBall=findViewById(R.id.id_ball);
		
		mBackLinearLayout = (SlidingBackLinearLayout) findViewById(R.id.back_linearlayout);
	    mBackLinearLayout.setFinishCallBack(new FinishCallBack() {
	      
	      @Override
	      public void finish() {
	        // TODO Auto-generated method stub
	    	  AnimatorActivity.this.finish();
	      }
	    });
	    SharedPreferences sp=getSharedPreferences("info", Context.MODE_PRIVATE);
	       // sp.edit().putString("zhangyi", "111111");
	        LogKT.zy("AnimatorActivity-------------"+sp.getString("zhangyi", "AnimatorActivity000000"));
	        LogKT.zy("AnimatorActivity-----app--------"+getApplication().getSharedPreferences("info", Context.MODE_PRIVATE).getString("zhangyi", "AnimatorActivity000000"));
	    
	}
	
	private void setScrernOrtation() {
		if(this.getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT){
			   setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			}else{
				 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			}
	}
	public void next(View view)
	{
		startActivity(new Intent(this, SlideBackActivity.class));
	}

	/**
	 * 最简单的属性动画
	 * 
	 * ofFloat(Object target, String propertyName, float... values)

 		float... values======, 0.0F, 360.0F  是自己定义的变化范围
	 * @param view
	 */
	public void translationAnimRun(View view)
	{
		 ObjectAnimator//
		 .ofFloat(mBlueBall, "translationX", 0.0F, 360.0F)//
		 .setDuration(500)//
		 .start();
		ObjectAnimator.ofFloat(mBlueBall, "translationY", 0.0f,360).setDuration(666).start();
	}
	
	/**
	 * 加了动画变化监听器
	 * @param view
	 */
	public void scaleAnimRun(final View view)
	{
		ObjectAnimator anim = ObjectAnimator//
				.ofFloat(mBlueBall, "zhy", 6.0F,  0.0F)//
				.setDuration(500);//
		anim.start();
		scale=1;
		anim.addUpdateListener(new AnimatorUpdateListener()
		{
			@Override
			public void onAnimationUpdate(ValueAnimator animation)
			{
				float cVal = (Float) animation.getAnimatedValue();
				LogKT.zy("-cVal---------------"+cVal);
				scale++;
				mBlueBall.setAlpha(cVal);
				mBlueBall.setScaleX(scale);
				mBlueBall.setScaleY(scale);
				if(cVal<0.1){
					mBlueBall.setAlpha(1);
					mBlueBall.setScaleX(1);
					mBlueBall.setScaleY(1);
				}
			}
			
		});
	}

	public void propertyValuesHolder(View view)
	{
		PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
				0f, 1f);
		PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
				0, 1f);
		PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
				0, 1f);
		ObjectAnimator.ofPropertyValuesHolder(mBlueBall, pvhX, pvhY,pvhZ).setDuration(1000).start();
	}
	
	
	/**
	 * ValueAnimator
	 * 
	 * 抛物线
	 * @param view
	 */
	public void paowuxian(View view)
	{

		ValueAnimator valueAnimator = new ValueAnimator();
		valueAnimator.setDuration(3000);
		valueAnimator.setObjectValues(new PointF(0, 0));
		valueAnimator.setInterpolator(new LinearInterpolator());
		valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
		{
			// fraction = t / duration
			@Override
			public PointF evaluate(float fraction, PointF startValue,
					PointF endValue)
			{
				LogKT.info("-----fraction * 3------"+fraction * 3 + "");
				// x方向200px/s ，则y方向0.5 * 10 * t
				PointF point = new PointF();
				point.x = 200 * fraction * 3;
				point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
				return point;
			}
		});

		valueAnimator.start();
		valueAnimator.addUpdateListener(new AnimatorUpdateListener()
		{
			@Override
			public void onAnimationUpdate(ValueAnimator animation)
			{
				PointF point = (PointF) animation.getAnimatedValue();
				mBlueBall.setX(point.x);
				mBlueBall.setY(point.y);
			}
		});
	}
	private class PointF{
		public float x;
		public float y;
		public PointF() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PointF(float x, float y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	 public void togetherRun(View view)  
	    {  
	        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",  
	                1.0f, 2f);  
	        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",  
	                1.0f, 2f);  
	        AnimatorSet animSet = new AnimatorSet();  
	        animSet.setDuration(2000);  
	        animSet.setInterpolator(new LinearInterpolator());  
	        //两个动画同时执行  
	        animSet.playTogether(anim1, anim2);  
	        animSet.start();  
	        ObjectAnimator scaleXAnimator=ObjectAnimator.ofFloat(mBlueBall, "scaleX", 0.0f,1.0f);
	        ObjectAnimator scaleYAnimator=ObjectAnimator.ofFloat(mBlueBall, "scaleY", 0.0f,1.0f);
	        ObjectAnimator translationXAnimator=ObjectAnimator.ofFloat(mBlueBall, "translationX", 1.0f,360f);
	        ObjectAnimator translationYAnimator=ObjectAnimator.ofFloat(mBlueBall, "translationY", 1.0f,360f);
	        AnimatorSet animatorSet=new AnimatorSet();
	        animatorSet.setDuration(3000);
	        animatorSet.playTogether(scaleXAnimator,scaleYAnimator,translationXAnimator,translationYAnimator);
	        animatorSet.setInterpolator(new LinearInterpolator());
	        animatorSet.start();
	        
	    }  
	  
	    /**AnimatorSet
	     * @param view
	     */
	    public void playWithAfter(View view)  
	    {  
	  
	        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",  
	                1.0f, 2f);  
	        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBlueBall, "scaleY",  
	                1.0f, 1f);  
	        ObjectAnimator anim3 = ObjectAnimator.ofFloat(mBlueBall,  
	                "X",  0f,  600 );  
	        ObjectAnimator anim4 = ObjectAnimator.ofFloat(mBlueBall,  
	                "X", 600,0f);  
	        ObjectAnimator anim5 = ObjectAnimator.ofFloat(mBlueBall, "scaleX",  
	                2.0f, 1f);  
	        /** 
	         * anim1，anim2,anim3同时执行 
	         * anim4接着执行 
	         */  
	        AnimatorSet animSet = new AnimatorSet();  
	        animSet.play(anim1).with(anim2);  
	        animSet.play(anim2).with(anim3);  
	        animSet.play(anim4).after(anim3);  
	        animSet.play(anim4).with(anim5);
	        animSet.setDuration(1000);  
	        animSet.start();  
	    }  
}
