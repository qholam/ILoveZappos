package com.example.tommy.ilovezappos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tommy's PC on 2/10/2017.
 */
public class ShoppingCartDbHelper extends SQLiteOpenHelper{
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ShoppingCartContract.ShoppingCartEntry.TABLE_NAME + " (" +
                    ShoppingCartContract.ShoppingCartEntry._ID + " INTEGER PRIMARY KEY," +
                    ShoppingCartContract.ShoppingCartEntry.COLUMN_DATE+ " DATE," +
                    ShoppingCartContract.ShoppingCartEntry.COLUMN_JSON + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ShoppingCartContract.ShoppingCartEntry.TABLE_NAME;

    public ShoppingCartDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
