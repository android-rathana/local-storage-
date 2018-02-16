package com.example.ratha.localstorage.data.localstorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ratha.localstorage.entity.User;

/**
 * Created by ratha on 2/15/2018.
 */

public class UserPreference {

    public static final String USER_NAME="USER_NAME";
    public static final String USER_EMAIL="USER_EMAIL";
    public static final String USER_PASSWORD="USER_PASSWORD";

    public static final String PREFERENCES_NAME="user_preference";

    private static SharedPreferences preferences;

    public static void add(Context context , User user){
        preferences=context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(USER_NAME,user.getUsername());
        editor.putString(USER_EMAIL,user.getEmail());
        editor.putString(USER_PASSWORD,user.getPassword());

        editor.commit();

    }

    public static User getUser(Context context){
        preferences=context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE);
        String name= preferences.getString(USER_NAME,"example");
        String email=preferences.getString(USER_EMAIL,"exmample@gmail.com");
        String password= preferences.getString(USER_PASSWORD,"example");

        User user=new User(name,email,password);
        return user;
    }

}
