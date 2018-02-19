package com.example.ratha.localstorage.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.ratha.localstorage.entity.LanguageState;

/**
 * Created by ratha on 2/19/2018.
 */

public class Preferences {

    public static final String[] LANGUAGE={"NAME","CODE","COUNTRY"};
    private static final String TAG = "Preferences";

    public static void add(String filename, Context context, LanguageState languageState){
        SharedPreferences preferences=context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString(LANGUAGE[0],languageState.getName());
        editor.putString(LANGUAGE[1],languageState.getCode());
        editor.putString(LANGUAGE[2],languageState.getCountry());
        Log.e(TAG, "add: " + languageState.toString());
        editor.commit();

        Toast.makeText(context, "saved", Toast.LENGTH_SHORT).show();
    }

    public static  LanguageState get(String filename,Context context){
        LanguageState language=new LanguageState();
        SharedPreferences preferences= context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        language.setName(preferences.getString(LANGUAGE[0],null));
        language.setCode(preferences.getString(LANGUAGE[1],null));
        language.setCountry(preferences.getString(LANGUAGE[2],null));

        return language;
    }

    public static  void remove(String filename,Context context){
        SharedPreferences preferences=context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString(LANGUAGE[0],null);
        editor.putString(LANGUAGE[1],null);
        editor.putString(LANGUAGE[2],null);
        editor.commit();
    }

}
