package com.example.animatordemo;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

public class ZyAnimator {
	
	public static void  bigAndFadeOut(final View view){
		/*ObjectAnimator.ofFloat(view, "scaleX", 1.0f,2.0f).setDuration(1000).start();
		ObjectAnimator.ofFloat(view, "scaleY", 1.0f,2.0f).setDuration(1000).start();
		ObjectAnimator.ofFloat(view, "alpha", 1.0f,0.0f).setDuration(1000).start();*/
		PropertyValuesHolder alphaHolder=PropertyValuesHolder.ofFloat("alpha", 1f,0.5f);
		PropertyValuesHolder scaleXHolder=PropertyValuesHolder.ofFloat("scaleX", 1.0f,1.5f);
		PropertyValuesHolder scaleYHolder=PropertyValuesHolder.ofFloat("scaleY", 1.0f,1.5f);
		ObjectAnimator bigAndFade = ObjectAnimator.ofPropertyValuesHolder(view, alphaHolder,scaleXHolder,scaleYHolder);
		
		bigAndFade.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				view.setScaleX(1);
				view.setScaleY(1);
				view.setAlpha(1);
			}
		});
		bigAndFade.setDuration(1500).start();
	}
	public static void  smallAndFadeIn(final View view){
		/*ObjectAnimator.ofFloat(view, "scaleX", 1.0f,2.0f).setDuration(1000).start();
		ObjectAnimator.ofFloat(view, "scaleY", 1.0f,2.0f).setDuration(1000).start();
		ObjectAnimator.ofFloat(view, "alpha", 1.0f,0.0f).setDuration(1000).start();*/
		PropertyValuesHolder alphaHolder=PropertyValuesHolder.ofFloat("alpha", 0.5f,1f);
		PropertyValuesHolder scaleXHolder=PropertyValuesHolder.ofFloat("scaleX", 0.7f,1.0f);
		PropertyValuesHolder scaleYHolder=PropertyValuesHolder.ofFloat("scaleY", 0.7f,1.0f);
		ObjectAnimator bigAndFade = ObjectAnimator.ofPropertyValuesHolder(view, alphaHolder,scaleXHolder,scaleYHolder);
		
		bigAndFade.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				view.setScaleX(1);
				view.setScaleY(1);
				view.setAlpha(1);
			}
		});
		bigAndFade.setDuration(1500).start();
	}

}
