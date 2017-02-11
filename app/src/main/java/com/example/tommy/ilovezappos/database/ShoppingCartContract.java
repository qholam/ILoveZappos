package com.example.tommy.ilovezappos.database;

import android.provider.BaseColumns;

/**
 * Shopping cart database which contains all the items someone has added to their cart
 * Created by Tommy's PC on 2/10/2017.
 */

public class ShoppingCartContract {
    private ShoppingCartContract(){};

    public static class ShoppingCartEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_JSON = "json";
    }
}
