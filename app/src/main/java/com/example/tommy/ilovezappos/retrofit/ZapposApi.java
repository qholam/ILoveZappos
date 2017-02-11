package com.example.tommy.ilovezappos.retrofit;

import com.example.tommy.ilovezappos.entity.SearchResultModel;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

/**
 * Created by Tommy's PC on 2/8/2017.
 */

public interface ZapposApi {
    @GET("/Search?key=b743e26728e16b81da139182bb2094357c31d331")
    Call<SearchResultModel> getTerm(@Query("term") String search_term);
}
