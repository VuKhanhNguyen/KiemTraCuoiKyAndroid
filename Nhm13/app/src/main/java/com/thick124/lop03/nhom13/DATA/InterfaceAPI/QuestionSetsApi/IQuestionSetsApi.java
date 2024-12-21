package com.thick124.lop03.nhom13.DATA.InterfaceAPI.QuestionSetsApi;

import com.example.quizapp.DATA.Models.QuestionSet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IQuestionSetsApi {
    @GET("QuestionSets")
    Call<List<QuestionSet>> getSets();

    @GET("QuestionSets/{id}")
    Call<QuestionSet> getSetById(@Path("id") int id);

    @GET("QuestionSets/ByLevelAndCate")
    Call<QuestionSet> getSetByIdLevelAndIdCate(@Query("idLevel") int idLevel, @Query("idCategory") int idCategory);

    @POST("QuestionSets")
    Call<QuestionSet> postSet(@Body QuestionSet questionSet);

    @PUT("QuestionSets/{id}")
    Call<QuestionSet> putSet(@Path("id") int id, @Body QuestionSet questionSet);

    @DELETE("QuestionSets/{id}")
    Call<Void> deleteSet(@Path("id") int id);
}
