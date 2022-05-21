package com.example.articlesproject.API.services;

import com.example.articlesproject.API.Model.CategoryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICategoryModel {

    @GET("categories")
    Call<CategoryModel> getAllCategories() ;
}
