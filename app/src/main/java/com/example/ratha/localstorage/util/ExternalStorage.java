package com.example.ratha.localstorage.util;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by ratha on 2/16/2018.
 */

public class ExternalStorage {
    private Context mContext;
    public ExternalStorage(Context mContext){
        this.mContext=mContext;
    }
    public boolean isExternalStorageIsWritable(){
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
            return true;

        return false;
    }

    public boolean isExternalStorageIsReadable(){
        String state =Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
            return true;

        return false;
    }

    public File getAlbumPictureDir(String album){
        File file= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),album);
        if(!file.mkdirs())
            file.mkdir();
            //Toast.makeText(this.mContext, "Directory is not created yet", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this.mContext, "Directory is created", Toast.LENGTH_SHORT).show();
        return file;
    }
}
