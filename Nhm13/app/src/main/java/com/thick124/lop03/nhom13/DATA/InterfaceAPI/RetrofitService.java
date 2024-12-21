package com.thick124.lop03.nhom13.DATA.InterfaceAPI;


import com.thick124.lop03.nhom13.DATA.InterfaceAPI.LoginApi.ILoginRequestApi;
import com.thick124.lop03.nhom13.DATA.InterfaceAPI.UserApi.IUsersApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//http://10.0.2.2:5019/api/
//http://192.168.1.129:5019/api/ //wifi nhà
//http://192.168.32.155:5019/api/ //4g
public class RetrofitService {
    private static final String BASE_URL = "http://10.0.2.2:5019/api/";
    private static Retrofit retrofit;

    private static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(45, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .build();
    }

    public static IUsersApi CreateInstanceU() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IUsersApi.class);
    }

    public static ILoginRequestApi createInstanceLogin(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILoginRequestApi.class);
    }



//   Tạo thêm method tạo instance cho mỗi entity ở đây
//
//    public static IQuestionsApi Create() {
//        return retrofit.create(IUsersApi.class);
//    }
//
//    public static ICategoriesApi Create() {
//        return retrofit.create(IUsersApi.class);
//    }
// ....

}
