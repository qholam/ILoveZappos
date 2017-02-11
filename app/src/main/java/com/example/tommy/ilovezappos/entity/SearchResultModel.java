package com.example.tommy.ilovezappos.entity;

/**
 * Created by Tommy's PC on 2/9/2017.
 */

import java.util.List;

import com.example.tommy.ilovezappos.entity.ItemModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResultModel {

    @SerializedName("originalTerm")
    @Expose
    private Object originalTerm;
    @SerializedName("currentResultCount")
    @Expose
    private String currentResultCount;
    @SerializedName("totalResultCount")
    @Expose
    private String totalResultCount;
    @SerializedName("term")
    @Expose
    private String term;
    @SerializedName("results")
    @Expose
    private List<ItemModel> results = null;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public Object getOriginalTerm() {
        return originalTerm;
    }

    public void setOriginalTerm(Object originalTerm) {
        this.originalTerm = originalTerm;
    }

    public String getCurrentResultCount() {
        return currentResultCount;
    }

    public void setCurrentResultCount(String currentResultCount) {
        this.currentResultCount = currentResultCount;
    }

    public String getTotalResultCount() {
        return totalResultCount;
    }

    public void setTotalResultCount(String totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<ItemModel> getResults() {
        return results;
    }

    public void setResults(List<ItemModel> results) {
        this.results = results;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}