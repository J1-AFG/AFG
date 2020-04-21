package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;




public class MainActivity extends AppCompatActivity {
    private CheckBox locationBox;
    private CheckBox activityBox;
    private CheckBox companyBox;
    private CheckBox sleepBox;
    private EditText customFeature;
    private Button addButton;
    private Button welcomeContinueButton;

    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationBox = (CheckBox) findViewById(R.id.locationBox);
        activityBox = (CheckBox) findViewById(R.id.activityBox);
        companyBox = (CheckBox) findViewById(R.id.companyBox);
        sleepBox = (CheckBox) findViewById(R.id.sleepBox);
        customFeature = (EditText) findViewById(R.id.customFeature);
        addButton = (Button) findViewById(R.id.addButton);
        welcomeContinueButton = (Button) findViewById(R.id.welcomeContinueButton);



        
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customEmotion = customFeature.getText().toString();
                Editor.putString(getString(R.string.customFeature), customEmotion);
                Editor.commit();
            }
        });

        welcomeContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locationBox.isChecked()){
                    Editor.putBoolean(getString(R.string.locationBox), true);
                }
                if (activityBox.isChecked()){
                    Editor.putBoolean(getString(R.string.activityBox), true);
                }
                if (companyBox.isChecked()){
                    Editor.putBoolean(getString(R.string.companyBox), true);
                }
                if (sleepBox.isChecked()){
                    Editor.putBoolean(getString(R.string.sleepBox), true);
                }
                Editor.commit();
                goToTimes(view);
            }
        });
    }

    public void goToTimes (View view){
        Intent intent = new Intent(this, Times.class);
        startActivity(intent);
    }


}







