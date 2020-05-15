package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Entries extends AppCompatActivity {
    private CheckBox happyBox;
    private CheckBox sadBox;
    private CheckBox angryBox;
    private CheckBox stressBox;
    private CheckBox otherBox;
    private EditText ratingEditText;
    private Button addButton;
    private Button entriesContinueButton;
    private ArrayList<String> entriesArray = new ArrayList<String>();
    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);
        /**
        happyBox = (CheckBox)findViewById(R.id.happyBox);
        sadBox = (CheckBox)findViewById(R.id.sadBox);
        angryBox = (CheckBox)findViewById(R.id.angryBox);
        stressBox = (CheckBox)findViewById(R.id.stressBox);
        otherBox = (CheckBox)findViewById(R.id.otherBox);
        rating = (EditText) findViewById(R.id.ratingEditText);
         **/
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
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        String dateToStr = format.format(today);

        String fileName = "entriesData";

        try {
            String content = "This is test content";
            File file = new File(fileName +".csv");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}