package com.zhangyi.testscroller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends FragmentActivity {
    @Bind(R.id.mian_recyclerview)
    private RecyclerView mainRecyclerView;
    private MyAdapter myAdapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList<>();
        for (int i=0;i<9;i++){
            list.add("I am "+i);
        }
        myAdapter=new MyAdapter(this,list);
        mainRecyclerView.setAdapter(myAdapter);

    }


}
