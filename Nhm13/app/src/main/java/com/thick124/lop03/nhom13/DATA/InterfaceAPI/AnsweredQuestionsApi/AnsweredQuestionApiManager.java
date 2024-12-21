package com.thick124.lop03.nhom13.DATA.InterfaceAPI.AnsweredQuestionsApi;

import com.example.quizapp.DATA.InterfaceAPI.RetrofitService;
import com.example.quizapp.DATA.Models.AnsweredQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AnsweredQuestionApiManager {
    private static IAnsweredQuestionsApi iAnsweredQuestionsApi;
    private static AnsweredQuestionApiManager answeredQuestionApiManager;

    private AnsweredQuestionApiManager(){
        iAnsweredQuestionsApi = RetrofitService.createInstanceAQ();
    }

    public static AnsweredQuestionApiManager getInstance(){
        if (answeredQuestionApiManager == null){
            answeredQuestionApiManager = new AnsweredQuestionApiManager();
        }
        return answeredQuestionApiManager;
    }

    public void postAnsweredQuestion(AnsweredQuestion answeredQuestion, Callback<AnsweredQuestion> callback){
        Call<AnsweredQuestion> call = iAnsweredQuestionsApi.postAnsweredQuestion(answeredQuestion);
        call.enqueue(callback);
    }

    public void postListAQ(List<AnsweredQuestion> AQlist, Callback<List<AnsweredQuestion>> callback){
        Call<List<AnsweredQuestion>> call = iAnsweredQuestionsApi.postListAnsweredQuestion(AQlist);
        call.enqueue(callback);
    }
}
