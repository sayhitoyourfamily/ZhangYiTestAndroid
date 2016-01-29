package com.zhangyi.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhangyi.zylibrary.ZyLog;

import java.util.List;

/**
 * Created by dfsj0049 on 2016/1/29.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private List<String> list;
    private boolean flag=false;

    public MyRecyclerViewAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    public void addItem(){
        if(list!=null){
            list.add("I am list"+list.size());
            //使用这个有动画效果
            //notifyItemInserted(list.size());
            //使用notifyDataSetChanged，没有动画效果
            notifyDataSetChanged();
        }
    }

    public void removeItem(){
        if(list!=null){
            list.remove(list.size()-1);
            //notifyItemRemoved(list.size());
            notifyDataSetChanged();
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(View.inflate(context,R.layout.item_recyclerview,null));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);
            ZyLog.zy("MyViewHolder");
            textView= (TextView) itemView.findViewById(R.id.item_tv);

        }
    }
}
