package com.thick124.lop03.nhom13.DATA.InterfaceAPI.QuestionApi;

import com.example.quizapp.DATA.InterfaceAPI.RetrofitService;
import com.example.quizapp.DATA.Models.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class QuestionsApiManager {
    private static IQuestionsApi iQuestionsApi;
    private static QuestionsApiManager questionsApiManager;

    private QuestionsApiManager(){
        iQuestionsApi = RetrofitService.createInstanceQ();
    }

    public static QuestionsApiManager getInstance(){
        if (questionsApiManager == null){
            questionsApiManager = new QuestionsApiManager();
        }
        return questionsApiManager;
    }

    public void getSets (Callback<List<Question>> callback){
        Call<List<Question>> qCall = iQuestionsApi.getQuestions();
        qCall.enqueue(callback);
    }
}

