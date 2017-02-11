package com.example.tommy.ilovezappos.listeners;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.widget.SearchView;

import com.example.tommy.ilovezappos.activity.ItemActivity;
import com.example.tommy.ilovezappos.entity.ItemModel;
import com.example.tommy.ilovezappos.entity.SearchResultModel;
import com.example.tommy.ilovezappos.retrofit.ZapposApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tommy's PC on 2/9/2017.
 */

public class QueryListener implements SearchView.OnQueryTextListener{
    final String API = "https://api.zappos.com";
    SearchView v;

    public QueryListener(SearchView v){
        this.v = v;
    }

    @Override
    public boolean onQueryTextChange(String newText){
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query){
        //Retrofit section start from here...
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();  //create an adapter for retrofit with base url

        ZapposApi service = retrofit.create(ZapposApi.class); //creating a service for adapter with our GET class

        //Now ,we need to call for response
        //Retrofit using gson for JSON-POJO conversion
        Call<SearchResultModel> call = service.getTerm(query);

        call.enqueue(new Callback<SearchResultModel>() {
            @Override
            public void onResponse(Call<SearchResultModel> c, Response<SearchResultModel> r) {
                ItemModel item = r.body().getResults().get(0);

                Intent intent = new Intent(v.getContext(), ItemActivity.class);
                intent.putExtra("item", item);
                v.getContext().startActivity(intent);
            }

            @Override
            public void onFailure(Call<SearchResultModel> c, Throwable t) {
                //TODO handle failure somehow
            }
        });

        return true;
    }
}
