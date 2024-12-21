package com.thick124.lop03.nhom13.DATA.InterfaceAPI.AnsweredQuestionsApi;

import com.example.quizapp.DATA.Models.AnsweredQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IAnsweredQuestionsApi {
    @GET("AnsweredQuestitons")
    Call<List<AnsweredQuestion>> getAnsweredQuestions();

    @POST("AnsweredQuestitons")
    Call<AnsweredQuestion> postAnsweredQuestion(@Body AnsweredQuestion answeredQuestion);

    @POST("AnsweredQuestitons/ListAQ")
    Call<List<AnsweredQuestion>> postListAnsweredQuestion(@Body List<AnsweredQuestion> answeredQuestionList);

}
