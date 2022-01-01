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

import com.example.firstapp.fables.AntGrasshopper;
import com.example.firstapp.fables.DogWolf;
import com.example.firstapp.fables.FoxGoat;
import com.example.firstapp.fables.LionMouse;
import com.example.firstapp.fables.TortoiseHare;
import com.example.firstapp.helper_classes.HelperFunctions;

import java.util.Objects;

import nl.changer.audiowife.AudioWife;

public class FableActivity extends AppCompatActivity implements View.OnClickListener {

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

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onClick(View view) {
        HelperFunctions h = new HelperFunctions(this);

        ViewGroup v = (ViewGroup)findViewById(R.id.media_player_layout);
        TextView tv = (TextView) findViewById(R.id.textView3);

        Uri uri = Uri.fromFile(h.createTempFromRaw(R.raw.foxgoat));
        switch (MainActivity.fable) {
            case 1:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.antgrasshopper));
                switch (view.getId()) {
                    case R.id.english_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.antgrasshopper));
                        break;

                    case R.id.mandarin_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                        break;

                    case R.id.english_text:
                        tv.setText(AntGrasshopper.E_BODY);
                        break;

                    case R.id.mandarin_text:
                        tv.setText(FoxGoat.M_BODY);
                        break;
                }
                break;
            case 2:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.dogwolf2));
                switch (view.getId()) {
                    case R.id.english_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.dogwolf2));
                        break;

                    case R.id.mandarin_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                        break;

                    case R.id.english_text:
                        tv.setText(DogWolf.E_BODY);
                        break;

                    case R.id.mandarin_text:
                        tv.setText(DogWolf.M_BODY);
                        break;
                }
                break;
            case 3:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.foxgoat));
                switch (view.getId()) {
                    case R.id.english_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.foxgoat));
                        break;

                    case R.id.mandarin_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                        break;

                    case R.id.english_text:
                        tv.setText(FoxGoat.E_BODY);
                        break;

                    case R.id.mandarin_text:
                        tv.setText(FoxGoat.M_BODY);
                        break;
                }
                break;
            case 4:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.haretortoise));
                switch (view.getId()) {
                    case R.id.english_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.haretortoise));
                        break;

                    case R.id.mandarin_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                        break;

                    case R.id.english_text:
                        tv.setText(TortoiseHare.E_BODY);
                        break;

                    case R.id.mandarin_text:
                        tv.setText(TortoiseHare.M_BODY);
                        break;
                }
                break;
            case 5:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.lionmouse));
                switch (view.getId()) {
                    case R.id.english_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.lionmouse));
                        break;

                    case R.id.mandarin_audio:
                        uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                        break;

                    case R.id.english_text:
                        tv.setText(LionMouse.E_BODY);
                        break;

                    case R.id.mandarin_text:
                        tv.setText(LionMouse.M_BODY);
                        break;
                }
                break;
        }
        // Refreshes AudioWife with correct audio file
        AudioWife.getInstance().init(this, uri).useDefaultUi(v, getLayoutInflater());
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