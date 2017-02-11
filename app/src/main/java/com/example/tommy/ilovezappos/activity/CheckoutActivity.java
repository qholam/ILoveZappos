package com.example.tommy.ilovezappos.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.tommy.ilovezappos.R;
import com.example.tommy.ilovezappos.adapter.RecyclerViewAdapter;
import com.example.tommy.ilovezappos.database.ShoppingCartContract;
import com.example.tommy.ilovezappos.database.ShoppingCartDbHelper;
import com.example.tommy.ilovezappos.entity.ItemModel;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CheckoutActivity extends BaseMenuActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //setting up recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new RecyclerViewAdapter(this, getItems()));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClearCartClick(View view){
        clearShoppingCart();
        this.recreate();
    }

    /**
     * clears the shopping cart(aka delete the SQL table, better way to save this?)
     */
    private void clearShoppingCart(){
        //clear shopping cart on each instance of app(better way to do this?)
        ShoppingCartDbHelper mDbHelper = new ShoppingCartDbHelper(this.getApplicationContext());
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(ShoppingCartContract.ShoppingCartEntry.TABLE_NAME, null, null);
    }

    /**
     * get the items saved in the shopping cart database
     */
    private ArrayList<ItemModel> getItems(){
        ArrayList<ItemModel> items = new ArrayList<ItemModel>();
        ArrayList<String> jsonItems = new ArrayList<String>();

        //go through shopping cart database and add items to array list
        ShoppingCartDbHelper mDbHelper = new ShoppingCartDbHelper(this.getApplicationContext());

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] proj = {
                ShoppingCartContract.ShoppingCartEntry.COLUMN_DATE,
                ShoppingCartContract.ShoppingCartEntry.COLUMN_JSON
        };

        Cursor cursor = db.query(
                ShoppingCartContract.ShoppingCartEntry.TABLE_NAME,                     // The table to query
                proj,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        while(cursor.moveToNext()) {
            String itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(ShoppingCartContract.ShoppingCartEntry.COLUMN_JSON));
            jsonItems.add(itemId);
        }
        cursor.close();

        Gson gson = new Gson();
        for(String i: jsonItems){
            ItemModel item = gson.fromJson(i, ItemModel.class);
            items.add(item);
        }

        return items;
    }
}
