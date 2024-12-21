package com.thick124.lop03.nhom13.DATA.InterfaceAPI;

import android.app.Application;


import com.thick124.lop03.nhom13.DATA.InterfaceAPI.UserApi.UsersApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;


    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();

        //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
        //vd: questionApiManager = new QuestionApiManager.getInstance();
        //...
    }
}