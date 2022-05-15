package com.example.articlesproject.services;

import com.example.articlesproject.Model.CategoryModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICategoryModel {

    @GET("categories")
    Call<CategoryModel> getAllCategories() ;
}
