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
    private EditText customEmotion;
    private Button addButton;
    private Button emotionsContinueButton;
    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotions);
        happyBox = (CheckBox) findViewById(R.id.happyBox);
        sadBox = (CheckBox) findViewById(R.id.sadBox);
        angryBox = (CheckBox) findViewById(R.id.angryBox);
        stressBox = (CheckBox) findViewById(R.id.stressBox);
        customEmotion = (EditText) findViewById(R.id.customEmotion);
        addButton = (Button) findViewById(R.id.addButton);
        emotionsContinueButton = (Button) findViewById(R.id.emotionsContinueButton);




        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String custEmotion = customEmotion.getText().toString();
                Editor.putString(getString(R.string.customEmotion), custEmotion);
                Editor.commit();
            }
        });

        emotionsContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                Editor.commit();
                goToActivities(view);
            }
        });
    }
            public void goToActivities (View view){
                Intent intent = new Intent(this, Activities.class);
                startActivity(intent);
            }
    }


