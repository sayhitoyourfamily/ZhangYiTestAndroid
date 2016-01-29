package com.example.proguarddemo;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class WebToHpagerInterface {
	private Context context;

	WebToHpagerInterface(Context context) {
		this.context = context;
	}

	@JavascriptInterface
	public void startHomePagerActivity(int uid) {
		Intent intent = new Intent(context, MainActivity.class);
		intent.putExtra("uid", uid);
		context.startActivity(intent);
	}
}
