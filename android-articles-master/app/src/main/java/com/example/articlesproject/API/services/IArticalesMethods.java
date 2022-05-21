package com.example.articlesproject.API.services;

import com.example.articlesproject.API.Model.ArticaleModel;
import com.example.articlesproject.API.Model.DataArticaleCategorie;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IArticalesMethods {

    @GET("articales")
    Call<ArticaleModel> getAllArticales() ;

    @POST("articales_by_categorie")
    Call<ArticaleModel> getArticalesByCategories(@Body DataArticaleCategorie categorie) ;
}
