package com.example.ratha.localstorage;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InternalStorageActivity extends AppCompatActivity {

    private static final String TAG = "InternalStorageActivity";
    private EditText mEditText;
    OutputStream ous;
    InputStream ins;
    private TextView textRead;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        mEditText=findViewById(R.id.myText);
        textRead =findViewById(R.id.textRead);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    public void onSave(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                saveData();
            }
        },2000);

    }

    public void saveData(){

        progressBar.setVisibility(ProgressBar.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    ous= openFileOutput("history.temp", Context.MODE_PRIVATE);
                    ous.write(mEditText.getText().toString().getBytes());

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        ous.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        },2000);
    }

    public void onRead(View view) {
        try{
            ins=openFileInput("history.temp");
            int ch=0;
            String text="";
            while ((ch=ins.read()) !=-1)
                text=text + (char) ch;

            textRead.setText(text);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onReadRawFile(View view) {
        ins= this.getResources().openRawResource(R.raw.slide_intro);
        int ch=0;
        String text="";
        try {
            while ((ch=ins.read()) !=-1)
                text=text + (char) ch;

        } catch (IOException e) {
            e.printStackTrace();
        }
        textRead.setText(text);
    }
}
