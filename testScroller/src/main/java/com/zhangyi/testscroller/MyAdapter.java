package com.zhangyi.testscroller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dfsj0049 on 2016/1/28.
 */
public class MyAdapter extends RecyclerView.Adapter{

    private List<String> list;
    private Context context;


    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
