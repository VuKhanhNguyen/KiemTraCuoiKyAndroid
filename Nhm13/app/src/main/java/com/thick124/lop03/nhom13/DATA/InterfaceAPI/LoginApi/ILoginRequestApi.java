package com.thick124.lop03.nhom13.DATA.InterfaceAPI.LoginApi;

import com.thick124.lop03.nhom13.DATA.Models.LoginRequest;
import com.thick124.lop03.nhom13.DATA.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ILoginRequestApi {
    @POST("Auth/Login")
    Call<User> postLogin(@Body LoginRequest loginRequest);
}
