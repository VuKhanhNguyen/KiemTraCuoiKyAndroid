package com.thick124.lop03.nhom13.DATA.ViewModels.ProgressQuestionsVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.ProgressQuestion;
import com.example.quizapp.DATA.Repository.ProgressQuestionsRepo;

import java.util.List;

public class ProgressQuestionsViewModel extends ViewModel {
    private final ProgressQuestionsRepo progressQuestionsRepo;

    public ProgressQuestionsViewModel() {
        progressQuestionsRepo = new ProgressQuestionsRepo();
    }

    public MutableLiveData<List<ProgressQuestion>> getProgressQuestions() {
        return progressQuestionsRepo.getProgressQuestions();
    }

    public MutableLiveData<List<ProgressQuestion>> getProgressQuestionsByUsername(String username) {
        return progressQuestionsRepo.getProgressByUsername(username);
    }

    public MutableLiveData<ProgressQuestion> getProgressQuestionByUsernameAndIdSet(String username, int idSet) {
        return progressQuestionsRepo.getProgressByUsernameAndIdSet(username, idSet);
    }

    public MutableLiveData<Boolean> postProgress(ProgressQuestion progressQuestion) {
        return progressQuestionsRepo.postProgress(progressQuestion);
    }

    public MutableLiveData<Boolean> putProgress(String username, int idSet, ProgressQuestion progressQuestion) {
        return progressQuestionsRepo.putProgress(username, idSet, progressQuestion);
    }

    public MutableLiveData<Boolean> deleteProgress(String username, int idSet) {
        return progressQuestionsRepo.deleteProgress(username, idSet);
    }

}