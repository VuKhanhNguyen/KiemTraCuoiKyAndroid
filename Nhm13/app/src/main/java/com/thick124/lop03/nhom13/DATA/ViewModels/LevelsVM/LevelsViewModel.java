package com.thick124.lop03.nhom13.DATA.ViewModels.LevelsVM;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.Level;
import com.example.quizapp.DATA.Repository.LevelsRepo;

import java.util.List;
public class LevelsViewModel extends ViewModel {
    private final LevelsRepo levelsRepo;
    private MutableLiveData<List<Level>> levelsLiveData;

    public LevelsViewModel(){
        levelsRepo = new LevelsRepo();
        levelsLiveData = levelsRepo.getLevels();
    }

    public MutableLiveData<List<Level>> getLevels(){
        return levelsLiveData;
    }
}
