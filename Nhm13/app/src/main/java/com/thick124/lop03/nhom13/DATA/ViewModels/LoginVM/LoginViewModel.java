package com.thick124.lop03.nhom13.DATA.ViewModels.LoginVM;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.User;
import com.example.quizapp.DATA.Repository.LoginRepo;

public class LoginViewModel extends ViewModel {
    private final LoginRepo loginRepo;
    private final MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public LoginViewModel(){
        loginRepo = new LoginRepo();
    }
    public LiveData<User> loginInVM(String username, String password){
        return loginRepo.postLogin(username,password);

    }

    public MutableLiveData<User> getLoggedInUser(){
        return userMutableLiveData;
    }
}
