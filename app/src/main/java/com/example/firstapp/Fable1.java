package com.example.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import nl.changer.audiowife.AudioWife;

public class Fable1 extends AppCompatActivity implements View.OnClickListener {

    // Media files
//    MediaPlayer englishAudio = MediaPlayer.create(this, R.raw.chinese_new_year_final);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fable1);

        // Enables scrolling for the text chunk
        TextView tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setMovementMethod(new ScrollingMovementMethod());

        // Adds the return button on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Buttons
        Button english = (Button)findViewById(R.id.fable1_button1);
        Button mandarin = (Button)findViewById(R.id.fable1_button2);
        english.setOnClickListener(this);
        mandarin.setOnClickListener(this);

        // Load the media files
//        englishAudio.prepare();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fable1_button1:

                File tempFile;
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.chinese_new_year_final);
                    tempFile = File.createTempFile("pre", "suf");
                    copyFile(inputStream, new FileOutputStream(tempFile));

                    // Now some_file is tempFile .. do what you like
                } catch (IOException e) {
                    throw new RuntimeException("Can't create temp file ", e);
                }

                ViewGroup v = (ViewGroup)getWindow().getDecorView().findViewById(android.R.id.content);


                Uri uri = Uri.fromFile(tempFile);

                AudioWife.getInstance().init(this, uri).useDefaultUi(v, getLayoutInflater());

                break;
//          case R.id.button3:
//                Intent intent2 = new Intent(getApplicationContext(), MainActivity3.class);
//                startActivity(intent2);
//                break;
        }
    }

    /**
     * Controls the return button on the action bar
     * @param item idfk
     * @return idfk
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}