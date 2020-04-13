package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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


        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Editor = Preferences.edit();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String custFeat = customFeature.getText().toString();
                Editor.putString(getString(R.string.customFeature), custFeat);
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
            }
        });
    }

    public void goToTimes (View view){
        Intent intent = new Intent(this, times.class);
        startActivity(intent);
    }

    Spinner spinner1= (Spinner) findViewById(R.id.morningDropdown);
    ArrayAdapter <CharSequence> morningAdapter= ArrayAdapter.createFromResource(this, R.array.morningTimes, android.R.layout.simple_spinner_item);
    morningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner1.setAdapter(morningAdapter);

    Spinner spinner2= (Spinner) findViewById(R.id.eveningDropdown);
    ArrayAdapter <CharSequence> eveningAdapter= ArrayAdapter.createFromResource(this, R.array.eveningTimes, android.R.layout.simple_spinner_item);
    eveningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner2.setAdapter(eveningAdapter);

}
