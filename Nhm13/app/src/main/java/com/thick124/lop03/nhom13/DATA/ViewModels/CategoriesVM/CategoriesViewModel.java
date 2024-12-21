package com.thick124.lop03.nhom13.DATA.ViewModels.CategoriesVM;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizapp.DATA.Models.QuestionCategory;
import com.example.quizapp.DATA.Repository.CategoriesRepo;

import java.util.List;

public class CategoriesViewModel extends ViewModel{
    private final CategoriesRepo categoriesRepo;
    private MutableLiveData<List<QuestionCategory>> categoriesLiveData;

    public CategoriesViewModel() {
        categoriesRepo = new CategoriesRepo();
        categoriesLiveData = categoriesRepo.getCategories();
    }
    public MutableLiveData<List<QuestionCategory>> getCategories() {
        return categoriesLiveData;
    }
}
