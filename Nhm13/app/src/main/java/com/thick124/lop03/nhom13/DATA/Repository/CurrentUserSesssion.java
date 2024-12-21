package com.thick124.lop03.nhom13.DATA.Repository;

import com.example.quizapp.DATA.Models.User;

public class CurrentUserSesssion {
     private static CurrentUserSesssion instance;
     private User user;

     private  CurrentUserSesssion(){

     }

     public static synchronized CurrentUserSesssion getInstance(){
         if (instance == null){
             instance = new CurrentUserSesssion();
         }
         return instance;
     }

     public void setUserCurrent(User user){
         this.user = user;
     }

     public User getUserCurrent(){
         return user;
     }

     public void clearSession(){
         user = null;
     }


}
