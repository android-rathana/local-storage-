package com.example.ratha.localstorage;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate;
import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate;

/**
 * Created by ratha on 2/19/2018.
 */

public class App extends Application {

    LocalizationApplicationDelegate mLocalizationDelegate=new LocalizationApplicationDelegate(this);
    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(mLocalizationDelegate.attachBaseContext(base));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mLocalizationDelegate.onConfigurationChanged(this);
    }

    @Override
    public Context getApplicationContext() {
        return mLocalizationDelegate.getApplicationContext(this);
    }
}
