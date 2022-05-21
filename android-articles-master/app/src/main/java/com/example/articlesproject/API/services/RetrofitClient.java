package com.example.articlesproject.API.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit ;
    private static String BASE_URL="http://169.254.16.33:3200/Api/";


    public static Retrofit getRetrofitInstance() {
        if(retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit ;
    }


}
