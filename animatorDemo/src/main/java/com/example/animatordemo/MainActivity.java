package com.example.animatordemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.bumptech.glide.Glide;
import com.example.animatordemowo.R;


/**
 * @author zhangyi
 *
 * TODO  有属性动画demo，参考链接：http://blog.csdn.net/lmj623565791/article/details/38067475
 */
public class MainActivity extends Activity {
	private RelativeLayout relativeLayout;
	private View ivMove;
	private int x,y;
	private MoveView moveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        GetTime.main();
        ivMove=findViewById(R.id.iv11);
        loading();
        moveView=(MoveView) findViewById(R.id.iv11);
        Glide.with(this).load("").into(moveView);
        SharedPreferences sp=getSharedPreferences("info", Context.MODE_PRIVATE);
        sp.edit().putString("zhangyi", "111111").commit();
        LogKT.zy("MainActivity-------------"+sp.getString("zhangyi", "MainActivity000000"));
    }
    public void ObjectAnimator(View view)
	{
		 startActivity(new Intent(this, AnimatorActivity.class));
	}
    
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
          break;
        case MotionEvent.ACTION_MOVE:
        	//moveViewByLayout(findViewById(R.id.rl), event.getX(), event.getY());
        	//moveViewWithFinger(findViewById(R.id.rl), event.getX(), event.getY());
        	moveView.updateLocation((int)event.getX(), (int)event.getY());
          break;
        case MotionEvent.ACTION_UP:
          break;
        }
    	return super.onTouchEvent(event);
    }
  

    /**
     * 通过layout方法，移动view 
     * 优点：对view所在的布局，要求不苛刻，不要是RelativeLayout，而且可以修改view的大小
     * 
     * @param view
     * @param rawX
     * @param rawY
     */
    private void moveViewByLayout(View view, float rawX, float rawY) {
      int left = (int) (rawX - view.getWidth()/2);
      int top = (int) (rawY-view.getHeight()/2 );
      int width = left + view.getWidth();
      int height = top + view.getHeight();
      view.layout(left,top, 0, 0);
    }
    private void loading() {
    	AnimationDrawable anim = (AnimationDrawable) ivMove
				.getBackground();
		anim.start();
    }
    /**
     * 设置View的布局属性，使得view随着手指移动 注意：view所在的布局必须使用RelativeLayout 而且不得设置居中等样式
     * 
     * @param view
     * @param rawX
     * @param rawY
     */
    private void moveViewWithFinger(View view, float rawX, float rawY) {
      RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view
          .getLayoutParams();
      params.leftMargin = (int) rawX - ivMove.getWidth() / 2;
      params.topMargin = (int) rawY - 100 - ivMove.getHeight() / 2;
      view.setLayoutParams(params);
    }
    
    
 /*   * 
    * AnimationDrawable anim = (AnimationDrawable) ivloading
				.getBackground();
		anim.start();
    * 
    * 
    * */
   /* @SuppressWarnings("deprecation")
	public void showLoadDialog(Context context) {
		if(defaultdialog==null){
			defaultdialog = new Dialog(context, R.style.loadProgressDialog);
			defaultdialog.setContentView(R.layout.activity_loading);
			ivloading = (ImageView) defaultdialog
					.findViewById(R.id.iv_activity_loading_ing);
		}
		if(ivloading==null){
			
			ivloading = (ImageView) defaultdialog
					.findViewById(R.id.iv_activity_loading_ing);
		}
		AnimationDrawable anim = (AnimationDrawable) ivloading
				.getBackground();
		anim.start();
		Animation operatingAnim = AnimationUtils.loadAnimation(context,
				R.anim.loading_anim);
		LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		if (operatingAnim != null) {
			ivloading.startAnimation(operatingAnim);
		}

		TextView tv_loading = (TextView) defaultdialog
				.findViewById(R.id.tv_activity_loading_word);
		if (UtilConstants.REMIND_WORD != null) {
			tv_loading
					.setText(UtilConstants.REMIND_WORD[(int) (Math.random() * (UtilConstants.REMIND_WORD.length - 1))]);
		} else {
			tv_loading.setText("加载中，请稍候...");
		}
		defaultdialog.setCanceledOnTouchOutside(true);
		defaultdialog.show();
	}*/
}
