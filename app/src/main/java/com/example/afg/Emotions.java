package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class Emotions extends AppCompatActivity {

    private CheckBox happyBox;
    private CheckBox sadBox;
    private CheckBox angryBox;
    private CheckBox stressBox;
    private CheckBox otherBox;
    private Button addButton;
    private Button emotionsContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotions);


        happyBox = (CheckBox) findViewById(R.id.happyBox);
        sadBox = (CheckBox) findViewById(R.id.sadBox);
        angryBox = (CheckBox) findViewById(R.id.angryBox);
        stressBox = (CheckBox) findViewById(R.id.stressBox);
        otherBox = (CheckBox) findViewById(R.id.otherBox);
        addButton = (Button) findViewById(R.id.addButton);
        emotionsContinueButton = (Button) findViewById(R.id.next);



    }



    public void openTimes(View v) {
        openTimesHome();
    }

    public void openTimesHome() {
        SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Preferences.edit();
        Editor.clear();
        Editor.commit();
        if (happyBox.isChecked()) {
            Editor.putBoolean(getString(R.string.happyBox), true);
        }
        if (sadBox.isChecked()) {
            Editor.putBoolean(getString(R.string.sadBox), true);
        }
        if (angryBox.isChecked()) {
            Editor.putBoolean(getString(R.string.angryBox), true);
        }
        if (stressBox.isChecked()) {
            Editor.putBoolean(getString(R.string.stressBox), true);
        }
        if (otherBox.isChecked()) {
            Editor.putBoolean(getString(R.string.otherBox), true);
        }
        Editor.apply();

        Intent intent = new Intent(this, Times.class);
        startActivity(intent);
    }
    }


