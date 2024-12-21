package com.thick124.lop03.nhom13.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.thick124.lop03.nhom13.DATA.InterfaceAPI.LoginApi.LoginApiManager;
import com.thick124.lop03.nhom13.DATA.Models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepo {
    private static volatile LoginRepo instance;
    private final LoginApiManager loginApiManager;

    private final MutableLiveData<User> loggedInUser = new MutableLiveData<>();


    public LoginRepo() {
        loginApiManager = LoginApiManager.getInstance();
    }

    public MutableLiveData<User> postLogin(String username, String password) {
        loginApiManager.postLogin(username, password, new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful() && response.body() != null){
                    loggedInUser.setValue(response.body());
                }else {
                    loggedInUser.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                loggedInUser.setValue(null);
                Log.e("LoginRepo", "API CALL failed: "+throwable.getMessage());
            }
        });

    return loggedInUser;
    }
}

