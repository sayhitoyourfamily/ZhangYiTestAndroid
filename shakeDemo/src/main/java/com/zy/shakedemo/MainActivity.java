package com.zy.shakedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;


/**
 * @author zhangyi
 *
 * TODO  摇一摇demo
 */
public class MainActivity extends Activity {

	private Context context=this;
	private Shake shake;
	private String result="{\"access_token\":\"OezXcEiiBSKSxW0eoylIeMXl5YpcKnSHVfSY29bbAA99gqFRkviZo5vnjxAkk99XYzXde5c67avnI2LA7SmQTbwykB5QJKvQeIE9JZ0raTuKlz0GYuDfp4eeZOsjycZkogtO1d0gglcpQ59_sQDzzA\"}";
	private WebView webView1;
	private String info="<span style=\"background-color:#000000ff\">you <span style=\"background-color:#ff0000\">have 当前</span>拥有<span style=\"color:#FF0000\">0</span>个酷币</span>";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shake=new Shake(context);
        /*webView1=(WebView) findViewById(R.id.webView1);
       // webView1.setAlpha(0.3f);
        webView1.getSettings().setDefaultTextEncodingName("utf-8") ;
        //webView1.loadData(info, "text/html", "UTF-8");
        //此方法可以解决中文乱码
        webView1.loadData(info, "text/html; charset=UTF-8", null);*/
        shake.setShakeListener(new ShakeListener() {
			
			@Override
			public void onShake() {
				Toast.makeText(context, "Hello World ! ! !", Toast.LENGTH_SHORT).show();
			}
		});
        
        
    }
    
    
    @Override
    protected void onDestroy() {
    	shake.unregisterListener();
    	super.onDestroy();
    }
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    	android.os.Process.killProcess(android.os.Process.myPid());
    }
}
