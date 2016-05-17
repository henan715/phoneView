package com.example.nan.myphonestate.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.nan.myphonestate.R;
import com.example.nan.myphonestate.model.SimpleKVmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>{
    private Activity mActivity;
    private int lastPosition=-1;//used to remember the last position of list
    private ArrayList<SimpleKVmodel> listItemList;

    public SimpleAdapter(Activity mActivity,ArrayList<SimpleKVmodel> batteyList) {
        this.mActivity=mActivity;
        this.listItemList=batteyList;
    }

    protected void setAnimation(View viewToAnimate, int position){
        if (position>lastPosition){
            Animation animation= AnimationUtils.loadAnimation(viewToAnimate.getContext(),
                    R.anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition=position;
        }
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    private void loadData(){
        // add data to item list
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        SimpleKVmodel simpleKVmodel=listItemList.get(position);

        holder.tv_title.setText(simpleKVmodel.getItem_key());
        holder.tv_value.setText(simpleKVmodel.getItem_value());
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_title;
        public TextView tv_value;

        public SimpleViewHolder(View itemView) {
            super(itemView);

            tv_title=(TextView)itemView.findViewById(R.id.tv_title);
            tv_value=(TextView)itemView.findViewById(R.id.tv_value);
        }
    }
}
