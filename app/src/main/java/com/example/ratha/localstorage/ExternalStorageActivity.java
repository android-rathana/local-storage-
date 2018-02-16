package com.example.ratha.localstorage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ratha.localstorage.util.ExternalStorage;

public class ExternalStorageActivity extends AppCompatActivity {
    private ExternalStorage externalStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        externalStorage =new ExternalStorage(this);
    }

    public void onCreatePublicPhotoAlbum(View view) {
        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image);
        if(externalStorage.isExternalStorageIsWritable()){
            externalStorage.getAlbumPictureDir("denhtlai");
        }else
            Toast.makeText(this, "not found storage.please mount removable to your device.", Toast.LENGTH_SHORT).show();
    }



}
