package com.example.myproud.internetmodel;

import com.example.myproud.internetmodel.beans.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IUserService {
    /**
     * GET请求
     */
    @GET("api/dailyEnglish")
    Call<User> getUser(@Query("type") String email);

    /**
     * POST请求
     */
    @FormUrlEncoded
    @POST("UserServlet")
    Call<User> postUser(@Field("name") String name, @Field("email") String email);
}
