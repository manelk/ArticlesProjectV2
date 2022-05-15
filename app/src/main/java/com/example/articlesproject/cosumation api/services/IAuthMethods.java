package com.example.articlesproject.services;

import com.example.articlesproject.Model.AuthModel;
import com.example.articlesproject.Model.DataAuthModel;


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
