package com.thick124.lop03.nhom13.DATA.InterfaceAPI;

import com.example.quizapp.DATA.InterfaceAPI.AnsweredQuestionsApi.IAnsweredQuestionsApi;
import com.example.quizapp.DATA.InterfaceAPI.AnswersApi.IAnswersApi;
import com.example.quizapp.DATA.InterfaceAPI.CategoriesApi.IQuestionCategoriesApi;
import com.example.quizapp.DATA.InterfaceAPI.CreatedQuestionApi.ICreatedQuestionApi;
import com.example.quizapp.DATA.InterfaceAPI.LevelApi.ILevelsApi;
import com.example.quizapp.DATA.InterfaceAPI.LoginApi.ILoginRequestApi;
import com.example.quizapp.DATA.InterfaceAPI.MarkedQuestionApi.IMarkedQuestionApi;
import com.example.quizapp.DATA.InterfaceAPI.ProgressQuestionApi.IProgressQuestionsApi;
import com.example.quizapp.DATA.InterfaceAPI.QuestionApi.IQuestionsApi;
import com.example.quizapp.DATA.InterfaceAPI.QuestionSetsApi.IQuestionSetsApi;
import com.example.quizapp.DATA.InterfaceAPI.RankingApi.IRankingApi;
import com.example.quizapp.DATA.InterfaceAPI.UserApi.IUsersApi;
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

    public static IQuestionSetsApi createInstanceSet(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionSetsApi.class);
    }

    public static ILevelsApi createInstanceLevel(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ILevelsApi.class);
    }

    public static IQuestionCategoriesApi createInstanceCate(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionCategoriesApi.class);
    }

    public static IQuestionsApi createInstanceQ(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IQuestionsApi.class);
    }

    public static IAnswersApi createInstanceAns(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IAnswersApi.class);
    }

    public static ICreatedQuestionApi createInstanceCQ() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTimeConverter())
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ICreatedQuestionApi.class);
    }

    public static IMarkedQuestionApi createInstanceMQ(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IMarkedQuestionApi.class);
    }

    public static IProgressQuestionsApi createInstancePQ() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IProgressQuestionsApi.class);
    }


    public static IRankingApi createInstanceRank(){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IRankingApi.class);
    }

    public static IAnsweredQuestionsApi createInstanceAQ(){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IAnsweredQuestionsApi.class);
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
