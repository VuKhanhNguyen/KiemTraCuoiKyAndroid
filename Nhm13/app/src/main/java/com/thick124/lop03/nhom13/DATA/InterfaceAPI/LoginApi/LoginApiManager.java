package com.thick124.lop03.nhom13.DATA.InterfaceAPI.LoginApi;

import com.example.quizapp.DATA.InterfaceAPI.RetrofitService;
import com.example.quizapp.DATA.Models.LoginRequest;
import com.example.quizapp.DATA.Models.User;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginApiManager {
    private static ILoginRequestApi iLoginRequestApi;
    private static LoginApiManager loginApiManager;

    private LoginApiManager(){
        iLoginRequestApi = RetrofitService.createInstanceLogin();
    }

    public static LoginApiManager getInstance(){
        if (loginApiManager == null){
            loginApiManager = new LoginApiManager();
        }
        return loginApiManager;
    }

    public void postLogin (String username, String password, Callback<User> callback){
        LoginRequest loginRequest = new LoginRequest(username, password);
        Call<User> loginCall = iLoginRequestApi.postLogin(loginRequest);
        loginCall.enqueue(callback);
    }  
}
