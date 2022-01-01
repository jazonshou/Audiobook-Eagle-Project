package com.example.firstapp.helper_classes;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.FileUtils;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class HelperFunctions {
    private Context context;

    public HelperFunctions(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public File createTempFromRaw(int id) {
        File tempFile;
        try {
            InputStream inputStream = context.getResources().openRawResource(id);
            tempFile = File.createTempFile("pre", "suf");
            FileUtils.copy(inputStream, new FileOutputStream(tempFile));

            // Now some_file is tempFile .. do what you like
        } catch (IOException e) {
            throw new RuntimeException("Can't create temp file ", e);
        }
        return tempFile;
    }
}
