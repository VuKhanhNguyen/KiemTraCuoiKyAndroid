package com.thick124.lop03.nhom13.DATA.ViewModels.SharedVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel<T> extends ViewModel {
    private final MutableLiveData<T> objectMLD = new MutableLiveData<>();
    public LiveData<T> getObjectMLD(){
        return  objectMLD;
    }
    public void setObjectMLD(T object){
        objectMLD.setValue(object);
    }
    public void clearObjectMLD(){
        objectMLD.setValue(null);
    }
}
