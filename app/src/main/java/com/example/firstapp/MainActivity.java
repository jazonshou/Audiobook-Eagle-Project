package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.firstapp.MESSAGE";

    public static int fable = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make it into an array list??
        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        Button six = (Button) findViewById(R.id.button6);
        Button seven = (Button) findViewById(R.id.button7);
        Button eight = (Button) findViewById(R.id.button8);
        Button nine = (Button) findViewById(R.id.button9);
        Button ten = (Button) findViewById(R.id.button10);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                fable = 1;
                break;
            case R.id.button2:
                fable = 2;
                break;
            case R.id.button3:
                fable = 3;
                break;
            case R.id.button4:
                fable = 4;
                break;
            case R.id.button5:
                fable = 5;
                break;
            case R.id.button6:
                fable = 6;
                break;
            case R.id.button7:
                fable = 7;
                break;
            case R.id.button8:
                fable = 8;
                break;
            case R.id.button9:
                fable = 9;
                break;
            case R.id.button10:
                fable = 10;
                break;
        }
        Intent intent = new Intent(getApplicationContext(), FableActivity.class);
        startActivity(intent);
    }
}