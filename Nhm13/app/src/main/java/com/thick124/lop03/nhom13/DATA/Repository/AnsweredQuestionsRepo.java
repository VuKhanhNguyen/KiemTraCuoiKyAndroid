package com.thick124.lop03.nhom13.DATA.Repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.quizapp.DATA.InterfaceAPI.AnsweredQuestionsApi.AnsweredQuestionApiManager;
import com.example.quizapp.DATA.Models.AnsweredQuestion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnsweredQuestionsRepo {
    private static volatile AnsweredQuestionsRepo getInstance;
    private final AnsweredQuestionApiManager answeredQuestionsApiManager;
    private MutableLiveData<List<AnsweredQuestion>> AQs = new MutableLiveData<>();
    private MutableLiveData<AnsweredQuestion> AQ = new MutableLiveData<>();
    private MutableLiveData<Boolean> operationSuccess = new MutableLiveData<>();

    public AnsweredQuestionsRepo() {
        answeredQuestionsApiManager = AnsweredQuestionApiManager.getInstance();
    }

    public MutableLiveData<Boolean> postAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        answeredQuestionsApiManager.postAnsweredQuestion(answeredQuestion, new Callback<AnsweredQuestion>() {
            @Override
            public void onResponse(Call<AnsweredQuestion> call, Response<AnsweredQuestion> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<AnsweredQuestion> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("AnsweredQuestionsRepo", "failed to postAnsweredQuestion: " + throwable.getMessage());
            }
        });
        return operationSuccess;
    }

    public MutableLiveData<Boolean> postListAQ(List<AnsweredQuestion> AQlist){
        answeredQuestionsApiManager.postListAQ(AQlist, new Callback<List<AnsweredQuestion>>() {
            @Override
            public void onResponse(Call<List<AnsweredQuestion>> call, Response<List<AnsweredQuestion>> response) {
                operationSuccess.setValue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<List<AnsweredQuestion>> call, Throwable throwable) {
                operationSuccess.setValue(false);
                Log.e("AnsweredQuestionsRepo", "failed to postListAQ: " + throwable.getMessage());
            }
        });
        return operationSuccess;
    }

}
