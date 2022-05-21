package com.example.articlesproject.API.services;

import com.example.articlesproject.API.Model.AuthModel;
import com.example.articlesproject.API.Model.DataAuthModel;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IAuthMethods {
    /*
    @GET("users")
    Call<AuthModel> getAllUsers();
    */

    @POST("users_login")
    Call<AuthModel> login(@Body DataAuthModel data );
}
