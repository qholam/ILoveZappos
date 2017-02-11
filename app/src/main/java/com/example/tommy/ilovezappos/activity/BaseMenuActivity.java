package com.example.tommy.ilovezappos.activity;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tommy.ilovezappos.R;
import com.example.tommy.ilovezappos.database.ShoppingCartContract;
import com.example.tommy.ilovezappos.database.ShoppingCartDbHelper;
import com.example.tommy.ilovezappos.listeners.QueryListener;


/**
 * This activity inflates the toolbar. The actionbar will be populated
 * for every activity that extends this one. This activity also sets up
 * the SearchView configuration and its listeners.
 * Created by Tommy's PC on 2/8/2017.
 */
public class BaseMenuActivity extends AppCompatActivity {
    SearchView searchView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //Set configuration for SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) this.findViewById(R.id.search_view);
        ComponentName cn = new ComponentName(this, ItemActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(cn));
        searchView.setSubmitButtonEnabled(true);
        //set listener
        searchView.setOnQueryTextListener(new QueryListener(searchView));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_home:
                intent = new Intent(this, MainMenu.class);
                startActivity(intent);
                return true;
            case R.id.action_shopping_cart:
                intent = new Intent(this, CheckoutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
