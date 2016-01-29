package com.zhangyi.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRecyclerViewAdapter.addItem();
            }
        });
        FloatingActionButton fab_l = (FloatingActionButton) findViewById(R.id.fab_l);
        fab_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRecyclerViewAdapter.removeItem();
            }
        });

    }

    private void initRecyclerView() {
        list=new ArrayList<>();
        for(int i=0;i<3;i++){
            list.add("I am "+i);
        }
        myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,list);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myRecyclerViewAdapter);


    }

}
