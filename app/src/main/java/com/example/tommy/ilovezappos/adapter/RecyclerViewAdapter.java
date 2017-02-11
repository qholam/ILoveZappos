package com.example.tommy.ilovezappos.adapter;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tommy.ilovezappos.databinding.ActivityItemBinding;
import com.example.tommy.ilovezappos.databinding.RecyclerViewItemBinding;
import com.example.tommy.ilovezappos.entity.ItemModel;
import com.example.tommy.ilovezappos.entity.ViewHolder;

import java.util.ArrayList;

/**
 * Created by Tommy's PC on 2/10/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{
    private Context mContext;
    private ArrayList<ItemModel> mList;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context context, ArrayList<ItemModel> list){
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }

        RecyclerViewItemBinding dataBinding = RecyclerViewItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        ItemModel model = mList.get(0);
        holder.bind(model);
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }
}
