package com.thick124.lop03.nhom13.DATA.ViewModels.SharedVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.Ranking;

import java.util.List;

public class PointUpdateSharedViewModel extends ViewModel {
    MutableLiveData<List<Ranking>> leaderboardLiveData = new MutableLiveData<>();

    public LiveData<List<Ranking>> getLeaderboardLiveData() {
        return leaderboardLiveData;
    }
}
