package com.example.firstapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.graphics.HardwareRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arges.sepan.argmusicplayer.Models.ArgAudio;
import com.arges.sepan.argmusicplayer.PlayerViews.ArgPlayerSmallView;
import com.example.firstapp.fables.AntGrasshopper;
import com.example.firstapp.fables.DogWolf;
import com.example.firstapp.fables.FoxGoat;
import com.example.firstapp.fables.LionMouse;
import com.example.firstapp.fables.TortoiseHare;
import com.example.firstapp.helper_classes.HelperFunctions;

import java.util.Objects;

import nl.changer.audiowife.AudioWife;

public class FableActivity extends AppCompatActivity implements View.OnClickListener {
    private ArgPlayerSmallView argMusic;
    private ArgAudio engAud, mandAud;
    private String engTxt, mandTxt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fable_activity);

        // Enables scrolling for the text chunk
        TextView tv3 = (TextView)findViewById(R.id.textView3);
        tv3.setMovementMethod(new ScrollingMovementMethod());

        // Adds the return button on the action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        // Buttons
        Button englishAudio = (Button)findViewById(R.id.english_audio);
        Button mandarinAudio = (Button)findViewById(R.id.mandarin_audio);
        Button englishText = (Button)findViewById(R.id.english_text);
        Button mandarinText = (Button)findViewById(R.id.mandarin_text);

        englishAudio.setOnClickListener(this);
        mandarinAudio.setOnClickListener(this);
        englishText.setOnClickListener(this);
        mandarinText.setOnClickListener(this);

        // Init ArgMusicPlayer
        argMusic = (ArgPlayerSmallView) findViewById(R.id.argmusicplayer);
        argMusic.disableNextPrevButtons();
        argMusic.disableErrorView();

        // Set the desired text based on which fable was clicked
        switch(MainActivity.fable) {
            // Ant and Grasshopper
            case 1:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "The Ant and the Grasshopper (English)", R.raw.antgrasshopper);
                mandAud = ArgAudio.createFromRaw("asdf", "asdf", R.raw.chinese_new_year_final);
                engTxt = AntGrasshopper.E_BODY;
                mandTxt = AntGrasshopper.M_BODY;
                break;
            // Dog and Wolf
            case 2:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "The Dog and the Wolf (English)", R.raw.dogwolf2);
                mandAud = ArgAudio.createFromRaw("asdf", "asdf", R.raw.chinese_new_year_final);
                engTxt = DogWolf.E_BODY;
                mandTxt = DogWolf.M_BODY;
                break;
            // Fox and Goat
            case 3:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "The Fox and the Goat (English)", R.raw.foxgoat);
                mandAud = ArgAudio.createFromRaw("asdf", "asdf", R.raw.chinese_new_year_final);
                engTxt = FoxGoat.E_BODY;
                mandTxt = FoxGoat.M_BODY;
                break;
            // Hare and Tortoise
            case 4:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "The Hare and the Tortoise (English)", R.raw.haretortoise);
                mandAud = ArgAudio.createFromRaw("asdf", "asdf", R.raw.chinese_new_year_final);
                engTxt = TortoiseHare.E_BODY;
                mandTxt = TortoiseHare.M_BODY;
                break;
            // Lion and Mouse
            case 5:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "The Lion and the Mouse (English)", R.raw.lionmouse);
                mandAud = ArgAudio.createFromRaw("asdf", "asdf", R.raw.chinese_new_year_final);
                engTxt = LionMouse.E_BODY;
                mandTxt = LionMouse.M_BODY;
                break;
        }
        // Set default text
        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(engTxt);
    }

    @Override
    protected void onStop() {
        super.onStop();
        argMusic.stop();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.english_audio:
                argMusic.play(engAud);
                break;

            case R.id.mandarin_audio:
                argMusic.play(mandAud);
                break;

            case R.id.english_text:
                tv.setText(engTxt);
                break;

            case R.id.mandarin_text:
                tv.setText(mandTxt);
                break;
        }
    }

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
}