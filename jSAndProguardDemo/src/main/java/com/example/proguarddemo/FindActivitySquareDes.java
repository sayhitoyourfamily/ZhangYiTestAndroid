package com.example.proguarddemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.js.proguarddemo.R;

@SuppressLint("SetJavaScriptEnabled")
public class FindActivitySquareDes extends Activity {

	private Context context;

	private FrameLayout square_fl_back;
	private TextView square_tv_title;
	private WebView square_wv_des;
	private LinearLayout rootLayout;
	private String shareSquareDes;
	private String shareSquareTitle;
	private String shareSquareImage;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_findsquare_des);
		context = this;
		initView();
		showWebView();
		square_fl_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				rootLayout.removeView(square_wv_des);
				square_wv_des.destroy();
				finish();
			}
		});
		
	}

	/**
	 * 初始化页面
	 */
	private void initView() {
		rootLayout = (LinearLayout) findViewById(R.id.id_findSquare_ll);
		square_fl_back = (FrameLayout) findViewById(R.id.id_findSquare_back);
		square_tv_title = (TextView) findViewById(R.id.id_findSquare_tv);
		square_wv_des = (WebView) findViewById(R.id.id_findSquare_webview);
	}

	

	// 显示WebView页面
	private void showWebView() {
		square_wv_des.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				square_wv_des.loadUrl( url);
				return true;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
			}
		});
		square_wv_des.getSettings().setJavaScriptEnabled(true);
		square_wv_des.addJavascriptInterface(new WebToHpagerInterface(this),
				"Android");
		// square_wv_des.loadUrl("http://192.168.23.2/object/webview/webview.html?user_id=3367983&category=1&square_id=1");
		square_wv_des.loadUrl("http://www.kting.cn/webview/5038087/25/61/android.html");
	};

}
