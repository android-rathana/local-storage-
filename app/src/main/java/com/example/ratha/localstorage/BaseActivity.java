package com.example.ratha.localstorage;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.Toast;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.example.ratha.localstorage.entity.LanguageState;
import com.example.ratha.localstorage.util.Preferences;

import java.io.LineNumberReader;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by ratha on 2/19/2018.
 */

public abstract class BaseActivity extends LocalizationActivity  {
    public static final String LANGUAGE_SATE_PREFERENCE="language_state";
    public SweetAlertDialog progressBarDialog;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBarDialog= createProgressBarDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        LanguageState languageState=Preferences.get(LANGUAGE_SATE_PREFERENCE,this);
        if(languageState.getCode()!=null){
            if(languageState.getCode().equals("en"))
                menu.findItem(R.id.english).setChecked(true);
            else if(languageState.getCode().equals("kh"))
                menu.findItem(R.id.khmer).setChecked(true);

        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //set default checkbox


        LanguageState language=new LanguageState();
        switch (item.getItemId()){
            case R.id.khmer:
                    item.setChecked(true);
                    this.setLanguage("km");
                    language.setName("Khmer");
                    language.setCode("km");
                    language.setCountry("Cambodia");
                    Toast.makeText(this, "kh checked", Toast.LENGTH_SHORT).show();
                    Preferences.add(LANGUAGE_SATE_PREFERENCE,this,language);

                break;
            case R.id.english:
                    item.setChecked(true);
                    this.setLanguage("en");
                    language.setName("English");
                    language.setCode("en");
                    language.setCountry("England");
                    Preferences.add(LANGUAGE_SATE_PREFERENCE,this,language);
                break;
        }

        return false;
    }

    @Override
    public void onBeforeLocaleChanged() {
        super.onBeforeLocaleChanged();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(progressBarDialog!=null)
                    progressBarDialog.show();
            }
        },3000);
        //Toast.makeText(this, "before", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAfterLocaleChanged() {
        super.onAfterLocaleChanged();
        if(progressBarDialog!=null)
            progressBarDialog.dismiss();


        //Toast.makeText(this, "after", Toast.LENGTH_SHORT).show();
    }

    public SweetAlertDialog createProgressBarDialog(){
        SweetAlertDialog dialog =new  SweetAlertDialog(this,SweetAlertDialog.PROGRESS_TYPE);
        dialog .getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        dialog.setTitle("app's changing language...");
        dialog.setCancelable(false);

        return dialog;
    }
}
