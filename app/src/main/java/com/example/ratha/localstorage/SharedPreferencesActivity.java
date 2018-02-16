package com.example.ratha.localstorage;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ratha.localstorage.data.localstorage.UserPreference;
import com.example.ratha.localstorage.entity.User;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText username;
    private EditText useremail;
    private EditText password;
    private ProgressBar progressBar;
    private TextView userDisplay;

    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        username=findViewById(R.id.username);
        useremail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        userDisplay=findViewById(R.id.userDetail);
        aSwitch=findViewById(R.id.aSwitch);


    }

    public void onSaveUser(View view) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserPreference.add(SharedPreferencesActivity.this,
                        new User(username.getText().toString(),
                                useremail.getText().toString(),
                                password.getText().toString()));
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        },1000);

    }

    public void onGetUser(View view) {
        User user =UserPreference.getUser(this);
        if(user!=null)
            userDisplay.setText(user.toString());
    }


}
