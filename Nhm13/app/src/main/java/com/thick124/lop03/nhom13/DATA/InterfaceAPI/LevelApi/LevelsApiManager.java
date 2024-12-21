package com.thick124.lop03.nhom13.DATA.InterfaceAPI.LevelApi;

import com.example.quizapp.DATA.InterfaceAPI.RetrofitService;
import com.example.quizapp.DATA.Models.Level;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class LevelsApiManager {
    private static ILevelsApi iLevelsApi;
    private static LevelsApiManager levelsApiManager;

    private LevelsApiManager(){
        iLevelsApi = RetrofitService.createInstanceLevel();
    }

    public static LevelsApiManager getInstance(){
        if (levelsApiManager == null){
            levelsApiManager = new LevelsApiManager();
        }
        return levelsApiManager;
    }

    public void getSets (Callback<List<Level>> callback){
        Call<List<Level>> qCall = iLevelsApi.getLevels();
        qCall.enqueue(callback);
    }
    public void getLevels (Callback<List<Level>> callback){
        Call<List<Level>> levelsCall = iLevelsApi.getLevels();
        levelsCall.enqueue(callback);
    }
}
