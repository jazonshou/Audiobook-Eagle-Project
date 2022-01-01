package com.example.firstapp.fables.fox_and_goat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstapp.R;
import com.example.firstapp.helper_classes.Helper_Functions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

import nl.changer.audiowife.AudioWife;

public class Fox_and_Goat extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fable1);

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
        Helper_Functions h = new Helper_Functions(this);

        ViewGroup v = (ViewGroup)findViewById(R.id.media_player_layout);
        TextView tv = (TextView) findViewById(R.id.textView3);

        Uri uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
        switch (view.getId()){
            case R.id.english_audio:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.chinese_new_year_final));
                break;

            case R.id.mandarin_audio:
                uri = Uri.fromFile(h.createTempFromRaw(R.raw.recording2));
                break;

            case R.id.english_text:
                tv.setText(Constants.E_FOX_AND_THE_GOAT);
                break;

            case R.id.mandarin_text:
                tv.setText(Constants.E_FOX_AND_THE_GOAT_MORAL);
                break;
        }
        // Refreshes AudioWife with correct audio file
        AudioWife.getInstance().init(this, uri).useDefaultUi(v, getLayoutInflater());
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
}