package com.example.tommy.ilovezappos.entity;

/**
 * Created by Tommy's PC on 2/9/2017.
 public class ItemModel {
 }
 */
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.ViewDebug;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class ItemModel extends BaseObservable implements Serializable {

    @SerializedName("brandName")
    @Expose
    @Bindable
    private String brandName;
    @SerializedName("thumbnailImageUrl")
    @Expose
    private String thumbnailImageUrl;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("originalPrice")
    @Expose
    private String originalPrice;
    @SerializedName("styleId")
    @Expose
    private String styleId;
    @SerializedName("colorId")
    @Expose
    private String colorId;
    @SerializedName("price")
    @Expose
    @Bindable
    private String price;
    @SerializedName("percentOff")
    @Expose
    private String percentOff;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("productName")
    @Expose
    @Bindable
    private String productName;
    @Expose
    private String itemName;

    public String getItemName(){return brandName + " " + productName;}
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(String percentOff) {
        this.percentOff = percentOff;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * convert java object to json
     * @return
     */
    public String toJSON(){
        Gson gson= new Gson();
        String json = gson.toJson(this, ItemModel.class);

        return json;
    }
}

