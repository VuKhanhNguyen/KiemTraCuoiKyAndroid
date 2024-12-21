package com.thick124.lop03.nhom13.DATA.InterfaceAPI;

import android.app.Application;

import com.example.quizapp.DATA.InterfaceAPI.AnsweredQuestionsApi.AnsweredQuestionApiManager;
import com.example.quizapp.DATA.InterfaceAPI.CreatedQuestionApi.CreatedQuestionApiManager;
import com.example.quizapp.DATA.InterfaceAPI.LevelApi.LevelsApiManager;
import com.example.quizapp.DATA.InterfaceAPI.MarkedQuestionApi.MarkedQuestionApiManager;
import com.example.quizapp.DATA.InterfaceAPI.QuestionApi.QuestionsApiManager;
import com.example.quizapp.DATA.InterfaceAPI.QuestionSetsApi.QuestionSetsApiManager;
import com.example.quizapp.DATA.InterfaceAPI.RankingApi.RankingApiManager;
import com.example.quizapp.DATA.InterfaceAPI.UserApi.UsersApiManager;

public class MainApplication extends Application {

    public static UsersApiManager usersApiManager;
    public static QuestionsApiManager questionsApiManager;
    public static QuestionSetsApiManager questionSetsApiManager;

    public static RankingApiManager rankingApiManager;
    public static LevelsApiManager levelsApiManager;
    public static CreatedQuestionApiManager createdQuestionApiManager;
    public static MarkedQuestionApiManager markedQuestionApiManager;
    public static AnsweredQuestionApiManager answeredQuestionApiManager;

    @Override
    public void onCreate(){
        super.onCreate();
        usersApiManager = UsersApiManager.getInstance();
        questionsApiManager = QuestionsApiManager.getInstance();

        questionSetsApiManager = QuestionSetsApiManager.getInstance();
        levelsApiManager = LevelsApiManager.getInstance();
        rankingApiManager = RankingApiManager.getInstance();


        questionSetsApiManager = QuestionSetsApiManager.getInstance();
        createdQuestionApiManager = CreatedQuestionApiManager.getInstance();
        markedQuestionApiManager = MarkedQuestionApiManager.getInstance();

        answeredQuestionApiManager = AnsweredQuestionApiManager.getInstance();

        //'entityName'ApiManager = new 'EntityName'ApiManager.getInstance();
        //vd: questionApiManager = new QuestionApiManager.getInstance();
        //...
    }
}