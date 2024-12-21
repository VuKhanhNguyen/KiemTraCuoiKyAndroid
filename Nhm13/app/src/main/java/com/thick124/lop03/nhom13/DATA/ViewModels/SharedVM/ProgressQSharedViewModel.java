package com.thick124.lop03.nhom13.DATA.ViewModels.SharedVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.AnsweredQuestion;
import com.example.quizapp.DATA.Models.ProgressQuestion;

import java.util.ArrayList;

public class ProgressQSharedViewModel extends ViewModel {
    private final MutableLiveData<ProgressQuestion> progressLiveData = new MutableLiveData<>();

    public ProgressQSharedViewModel() {
        ProgressQuestion progressQuestion = new ProgressQuestion();
        progressQuestion.setAnswered(new ArrayList<>());
        progressLiveData.setValue(progressQuestion);
    }

    public MutableLiveData<ProgressQuestion> getProgressLiveData() {
        return progressLiveData;
    }

    public void setUsernameP(String username) {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress != null) {
            progress.setUsername(username);
            progressLiveData.setValue(progress);
        }
    }


    public void setIdSetP(int idSet) {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress != null) {
            progress.setIdSet(idSet);
            progressLiveData.setValue(progress);
        }
    }

    public void setQuestionCount(int questionCount) {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress != null) {
            progress.setQuestionCount(questionCount);
            progressLiveData.setValue(progress);
        }
    }

    public void setQuestionLastId(int questionLastId) {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress != null) {
            progress.setQuestionLastId(questionLastId);
            progressLiveData.setValue(progress);
        }
    }


    public void addAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress == null) {
            progress = new ProgressQuestion();
            progress.setAnswered(new ArrayList<>());
        }
        progress.getAnswered().add(answeredQuestion);
        progressLiveData.setValue(progress);
    }

    public void resetData() {
        ProgressQuestion progress = progressLiveData.getValue();
        if (progress != null) {
            progress.setUsername(null);
            progress.setSavedTime(null);
            progress.setAuthorName(null);
            progress.setIdSet(0);
            progress.setSetName(null);
            progress.setQuestionCount(0);
            progress.setQuestionLastId(0);
            progress.setQuestions(new ArrayList<>());
            progress.setAnswered(new ArrayList<>());
            progressLiveData.setValue(progress);
        }
    }

}
