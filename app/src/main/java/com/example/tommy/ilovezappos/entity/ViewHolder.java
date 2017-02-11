package com.example.tommy.ilovezappos.entity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tommy.ilovezappos.databinding.ActivityItemBinding;
import com.example.tommy.ilovezappos.databinding.RecyclerViewItemBinding;

/**
 * Created by Tommy's PC on 2/10/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    private RecyclerViewItemBinding mDataBinding;

    public ViewHolder(RecyclerViewItemBinding dataBinding){
        super(dataBinding.getRoot());
        this.mDataBinding = dataBinding;
    }

    public void bind(ItemModel model){
        this.mDataBinding.setItem(model);
    }

    public RecyclerViewItemBinding getmDataBinding(){
        return mDataBinding;
    }
}
