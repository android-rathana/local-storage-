package com.example.ratha.localstorage;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class CacheFileActivity extends AppCompatActivity {

    private static final String TAG = "CacheFileActivity";
    private EditText desc;
    private TextView display;
    private OutputStream ous;
    private InputStream ins;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catch_file);
        desc=findViewById(R.id.desc);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        display=findViewById(R.id.display);
    }

    public void onListCatchFile(View   view) {
        String[] list = fileList();
        for(String s: list ){
            Log.e(TAG, "onListCatchFile: " +s);
        }
    }

    public void onDeleteCatch(View view) {

        //deleteFile("desc.cache");
        File f=getCacheDir();
        File file=new File(f.getAbsolutePath(),"desc.cache");
        if(file.exists())
            file.delete();
        Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();

    }

    public void onSaveCatch(View view) {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                File f= getCacheDir();
                Log.e(TAG, "run: "+ f.getAbsolutePath());
                File file =new File(f.getAbsolutePath(),"desc.cache");
                try {
                    ous = new FileOutputStream(file);
                    ous.write(desc.getText().toString().getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        },2000);
    }

    public void onReadCatch(View view) {
        File f=getCacheDir();
        File file =new File(f.getAbsolutePath(),"desc.cache");
        try {
            ins= new FileInputStream(file);
            int i=-1;
            String data="";
            while ((i=ins.read()) != -1)
                data=data + (char) i;
            display.setText(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
