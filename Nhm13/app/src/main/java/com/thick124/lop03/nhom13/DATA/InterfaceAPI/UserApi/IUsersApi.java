package com.thick124.lop03.nhom13.DATA.InterfaceAPI.UserApi;

import com.thick124.lop03.nhom13.DATA.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUsersApi {
    // http://localhost:5019/api/Users
    @GET("Users")
    Call<List<User>> getUsers();

    @GET("Users/{id}")
    Call<List<User>> getUserById(@Path("id") String id);

    @PUT("Users/{id}")
    Call<Void> updateUser(@Path("id") String id, @Body  User user);

    @POST("Users")
    Call<User> postUser(@Body User user);
}
