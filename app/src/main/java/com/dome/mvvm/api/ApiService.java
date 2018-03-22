package com.dome.mvvm.api;

import com.dome.mvvm.vo.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * REST API access points
 */
public interface ApiService {
    /**
     * 简单点的写法
     */
    ApiService INSTANCE = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("users/{login}")
    Call<User> getUser(@Path("login") String login);
}
