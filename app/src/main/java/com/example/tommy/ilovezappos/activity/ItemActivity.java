package com.example.tommy.ilovezappos.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.tommy.ilovezappos.R;
import com.example.tommy.ilovezappos.database.ShoppingCartContract;
import com.example.tommy.ilovezappos.database.ShoppingCartDbHelper;
import com.example.tommy.ilovezappos.databinding.ActivityItemBinding;
import com.example.tommy.ilovezappos.entity.ItemModel;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ItemActivity extends BaseMenuActivity{
    ItemModel item = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item);

        //Get intent that contains user search query
        Intent intent = getIntent();
        item = (ItemModel) intent.getSerializableExtra("item");

        ActivityItemBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_item);
        binding.setItem(item);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CheckoutActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    public void onClickCheckOut(View view) {
        if(item == null)
            return;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ViewCompat.animate(fab)
                .rotation(360.0F)
                .start();

        /*save item to shopping cart database*/
        ShoppingCartDbHelper mDbHelper = new ShoppingCartDbHelper(view.getContext());
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        ContentValues values = new ContentValues();
        values.put(ShoppingCartContract.ShoppingCartEntry.COLUMN_DATE, date);
        values.put(ShoppingCartContract.ShoppingCartEntry.COLUMN_JSON, item.toJSON());

        // Insert the new row, returning the primary key value of the new row
        db.insert(ShoppingCartContract.ShoppingCartEntry.TABLE_NAME, null, values);
    }
}
