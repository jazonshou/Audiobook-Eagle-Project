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
import com.example.firstapp.fables.BoysFrog;
import com.example.firstapp.fables.BoysWolf;
import com.example.firstapp.fables.DogWolf;
import com.example.firstapp.fables.FoxGoat;
import com.example.firstapp.fables.FrogsWell;
import com.example.firstapp.fables.LionMouse;
import com.example.firstapp.fables.MercuryWoodcutter;
import com.example.firstapp.fables.MilkmaidPail;
import com.example.firstapp.fables.TortoiseHare;

import java.util.Objects;

import nl.changer.audiowife.AudioWife;

public class FableActivity extends AppCompatActivity implements View.OnClickListener {
    private ArgPlayerSmallView argMusic;
    private ArgAudio engAud, mandAud;
    private String engTxt, mandTxt, engTitle, mandTitle, engMoral, mandMoral;
    private TextView tv, title_tv, moral_tv;

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
        Button english = (Button) findViewById(R.id.english_button);
        Button mandarin = (Button) findViewById(R.id.mandarin_button);

        english.setOnClickListener(this);
        mandarin.setOnClickListener(this);

        // Init ArgMusicPlayer
        argMusic = (ArgPlayerSmallView) findViewById(R.id.argmusicplayer);
        argMusic.disableNextPrevButtons();
        argMusic.disableErrorView();
        argMusic.disableProgress();

        // Set the desired text based on which fable was clicked
        switch(MainActivity.fable) {
            // Ant and Grasshopper
            case 1:
                engAud = ArgAudio.createFromRaw("", "The Ant and the Grasshopper (English)", R.raw.antgrasshopper);
                mandAud = ArgAudio.createFromRaw("", "The Ant and the Grasshopper (Mandarin)", R.raw.m_antgrasshopper);
                engTxt = AntGrasshopper.E_BODY; mandTxt = AntGrasshopper.M_BODY;
                engTitle = AntGrasshopper.E_TITLE; mandTitle = AntGrasshopper.M_TITLE;
                engMoral = AntGrasshopper.E_MORAL; mandMoral = AntGrasshopper.M_MORAL;
                break;
            // Dog and Wolf
            case 2:
                engAud = ArgAudio.createFromRaw("", "The Dog and the Wolf (English)", R.raw.dogwolf2);
                mandAud = ArgAudio.createFromRaw("", "The Dog and the Wolf (Mandarin)", R.raw.m_dogwolf);
                engTxt = DogWolf.E_BODY; mandTxt = DogWolf.M_BODY;
                engTitle = DogWolf.E_TITLE; mandTitle = DogWolf.M_TITLE;
                engMoral = DogWolf.E_MORAL; mandMoral = DogWolf.M_MORAL;
                break;
            // Fox and Goat
            case 3:
                engAud = ArgAudio.createFromRaw("", "The Fox and the Goat (English)", R.raw.foxgoat);
                mandAud = ArgAudio.createFromRaw("", "The Fox and the Goat (Mandarin)", R.raw.m_foxgoat);
                engTxt = FoxGoat.E_BODY; mandTxt = FoxGoat.M_BODY;
                engTitle = FoxGoat.E_TITLE; mandTitle = FoxGoat.M_TITLE;
                engMoral = FoxGoat.E_MORAL; mandMoral = FoxGoat.M_MORAL;
                break;
            // Hare and Tortoise
            case 4:
                engAud = ArgAudio.createFromRaw("", "The Hare and the Tortoise (English)", R.raw.haretortoise);
                mandAud = ArgAudio.createFromRaw("", "The Hare and the Tortoise", R.raw.m_tortoisehare);
                engTxt = TortoiseHare.E_BODY; mandTxt = TortoiseHare.M_BODY;
                engTitle = TortoiseHare.E_TITLE; mandTitle = TortoiseHare.M_TITLE;
                engMoral = TortoiseHare.E_MORAL; mandMoral = TortoiseHare.M_MORAL;
                break;
            // Lion and Mouse
            case 5:
                engAud = ArgAudio.createFromRaw("", "The Lion and the Mouse (English)", R.raw.lionmouse);
                mandAud = ArgAudio.createFromRaw("", "The Lion and the Mouse (Mandarin)", R.raw.m_lionmouse);
                engTxt = LionMouse.E_BODY; mandTxt = LionMouse.M_BODY;
                engTitle = LionMouse.E_TITLE; mandTitle = LionMouse.M_TITLE;
                engMoral = LionMouse.E_MORAL; mandMoral = LionMouse.M_MORAL;
                break;
            // The Boys and the Frogs
            case 6:
                engAud = ArgAudio.createFromRaw("", "The Boys and the Frogs (English)", R.raw.boysfrogs);
                mandAud = ArgAudio.createFromRaw("", "The Boys and the Frogs (Mandarin)", R.raw.m_boyfrogs);
                engTxt = BoysFrog.E_BODY; mandTxt = BoysFrog.M_BODY;
                engTitle = BoysFrog.E_TITLE; mandTitle = BoysFrog.M_TITLE;
                engMoral = BoysFrog.E_MORAL; mandMoral = BoysFrog.M_MORAL;
                break;
            // Boys and Wolf
            case 7:
                engAud = ArgAudio.createFromRaw("", "The Shepherd Boy and the Wolf (English)", R.raw.boywolf);
                mandAud = ArgAudio.createFromRaw("", "The Shepherd Boy and the Wolf (Mandarin)", R.raw.m_boywolf);
                engTxt = BoysWolf.E_BODY; mandTxt = BoysWolf.M_BODY;
                engTitle = BoysWolf.E_TITLE; mandTitle = BoysWolf.M_TITLE;
                engMoral = BoysWolf.E_MORAL; mandMoral = BoysWolf.M_MORAL;
                break;
            // Frogs and Well
            case 8:
                engAud = ArgAudio.createFromRaw("", "The Frogs and the Well (English)", R.raw.frogswell);
                mandAud = ArgAudio.createFromRaw("", "The Frogs and the Well (Mandarin)", R.raw.m_frogswell);
                engTxt = FrogsWell.E_BODY; mandTxt = FrogsWell.M_BODY;
                engTitle = FrogsWell.E_TITLE; mandTitle = FrogsWell.M_TITLE;
                engMoral = FrogsWell.E_MORAL; mandMoral = FrogsWell.M_MORAL;
                break;
            // Mercury and Woodcutter
            case 9:
                engAud = ArgAudio.createFromRaw("Anna Zhou", "Mercury and the Woodman (English)", R.raw.mercurywoodcutter);
                mandAud = ArgAudio.createFromRaw("asdf", "Mercury and the Woodman (Mandarin)", R.raw.m_mercurywoodcutter);
                engTxt = MercuryWoodcutter.E_BODY; mandTxt = MercuryWoodcutter.M_BODY;
                engTitle = MercuryWoodcutter.E_TITLE; mandTitle = MercuryWoodcutter.M_TITLE;
                engMoral = MercuryWoodcutter.E_MORAL; mandMoral = MercuryWoodcutter.M_MORAL;
                break;
            // Milkmaid and Pail
            case 10:
                engAud = ArgAudio.createFromRaw("", "The Milkmaid and Her Pail (English)", R.raw.milkmaidpail);
                mandAud = ArgAudio.createFromRaw("", "The Milkmaid and Her Pail", R.raw.m_milkmaidpail);
                engTxt = MilkmaidPail.E_BODY; mandTxt = MilkmaidPail.M_BODY;
                engTitle = MilkmaidPail.E_TITLE; mandTitle = MilkmaidPail.M_TITLE;
                engMoral = MilkmaidPail.E_MORAL; mandMoral = MilkmaidPail.M_MORAL;
                break;
        }
        // Set default text
        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(engTxt);

        title_tv = (TextView) findViewById(R.id.fable_title);
        title_tv.setText(engTitle);

        moral_tv = (TextView) findViewById(R.id.fable_moral);
        moral_tv.setText(engMoral);
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
            case R.id.english_button:
                argMusic.play(engAud);
                tv.setText(engTxt);
                title_tv.setText(engTitle);
                moral_tv.setText(engMoral);
                break;

            case R.id.mandarin_button:
                argMusic.play(mandAud);
                tv.setText(mandTxt);
                title_tv.setText(mandTitle);
                moral_tv.setText(mandMoral);
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