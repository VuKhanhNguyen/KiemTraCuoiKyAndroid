package com.thick124.lop03.nhom13.DATA.ViewModels.AnsweredQuestionsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.AnsweredQuestion;
import com.example.quizapp.DATA.Repository.AnsweredQuestionsRepo;

import java.util.List;

public class AnsweredQuestionViewModel extends ViewModel {
    private final AnsweredQuestionsRepo answeredQuestionsRepo;

    public AnsweredQuestionViewModel() {
        answeredQuestionsRepo = new AnsweredQuestionsRepo();
    }

    public MutableLiveData<Boolean> postAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        return answeredQuestionsRepo.postAnsweredQuestion(answeredQuestion);
    }
    public MutableLiveData<Boolean> postListAQ(List<AnsweredQuestion> AQlist){
        return answeredQuestionsRepo.postListAQ(AQlist);
    }
}
