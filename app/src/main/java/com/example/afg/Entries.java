package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Entries extends AppCompatActivity {
    private CheckBox happyBox;
    private CheckBox sadBox;
    private CheckBox angryBox;
    private CheckBox stressBox;
    private CheckBox otherBox;
    private Button addButton;
    private Button entriesContinueButton;
    private ArrayList<String> entriesArray = new ArrayList<String>();
    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        if (Preferences.getBoolean(getString(R.string.happyBox),false)){
            entriesArray.add("Happy");
        }
        if (Preferences.getBoolean(getString(R.string.sadBox),false)){
            entriesArray.add("Sad");
        }
        if (Preferences.getBoolean(getString(R.string.angryBox),false)){
            entriesArray.add("Angry");
        }
        if (Preferences.getBoolean(getString(R.string.stressBox),false)){
            entriesArray.add("Stress");
        }
        if (Preferences.getBoolean(getString(R.string.otherBox),false)){
            entriesArray.add("Other");
        }
        Spinner entriesSpinner = (Spinner) findViewById(R.id.entriesDropdown);
        ArrayAdapter<CharSequence> entriesAdapter = ArrayAdapter.createFromResource(this, R.array.entriesArray, android.R.layout.simple_spinner_item);
        entriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        entriesSpinner.setAdapter(entriesAdapter);

        String emotion = entriesSpinner.getSelectedItem().toString();

        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);
    }


}