package com.example.ratha.localstorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSharePreferences(View view) {
        startActivity(new Intent(this,SharedPreferencesActivity.class));
    }

    public void onInternalStorageClick(View view) {
        startActivity(new Intent(this,InternalStorageActivity.class));
    }

    public void onExternalStorageClick(View view) {
        startActivity(new Intent(this, ExternalStorageActivity.class));
    }

    public void onCacheStorageClick(View view) {
        startActivity(new Intent(this,CacheFileActivity.class));
    }
}
