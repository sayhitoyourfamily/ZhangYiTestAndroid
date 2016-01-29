package com.example.testthreadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.example.testthreadpool.MyThreadPools.Setup;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


/**
 * @author zhangyi
 *
 * TODO  使用线程池的demo
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* MyThreadPools myThreadPools=new MyThreadPools();
        Setup setup=myThreadPools.new Setup();
        setup.main();*/
        ExecutorServiceDemo executorServiceDemo=new ExecutorServiceDemo();
        executorServiceDemo.go2();
    }
    
    
    
    
}
