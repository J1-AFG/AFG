package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
    private Spinner entriesSpinner;

    private ArrayList<String> entriesArray = new ArrayList<String>();
    private String dir;
    private String filename;
    private File entriesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);
        SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Preferences.edit();

         happyBox = (CheckBox)findViewById(R.id.happyBox);
         sadBox = (CheckBox)findViewById(R.id.sadBox);
         angryBox = (CheckBox)findViewById(R.id.angryBox);
         stressBox = (CheckBox)findViewById(R.id.stressBox);
         otherBox = (CheckBox)findViewById(R.id.otherBox);
         ratingEditText = (EditText) findViewById(R.id.ratingEditText);
        dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        filename = "entriesData.csv";
        entriesData = new File (dir, filename);

         if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
             ActivityCompat.requestPermissions(this,
                     new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                     1);
         }

        if (Preferences.getBoolean(getString(R.string.happyBox), false)) {
            entriesArray.add("Happy");
        }
        if (Preferences.getBoolean(getString(R.string.sadBox), false)) {
            entriesArray.add("Sad");
        }
        if (Preferences.getBoolean(getString(R.string.angryBox), false)) {
            entriesArray.add("Angry");
        }
        if (Preferences.getBoolean(getString(R.string.stressBox), false)) {
            entriesArray.add("Stress");
        }
        if (Preferences.getBoolean(getString(R.string.otherBox), false)) {
            entriesArray.add("Other");
        }
        entriesSpinner = (Spinner) findViewById(R.id.entriesDropdown);
        ArrayAdapter<String> entriesAdapter = new ArrayAdapter<String>(Entries.this,android.R.layout.simple_spinner_item, entriesArray);
                //ArrayAdapter.createFromResource(this, R.array.entriesArray, android.R.layout.simple_spinner_item);
        entriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        entriesSpinner.setAdapter(entriesAdapter);

    }
    public void csv (View v) throws IOException {
        printToCSV();
    }
    //CSV writer code retrieved from https://www.topjavatutorial.com/
        public void printToCSV() throws IOException {
            String emotion = entriesSpinner.getSelectedItem().toString();

            String rating = ratingEditText.getText().toString();
            int rate = Integer.parseInt(rating);

            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
            String dateToStr = format.format(today);
            Log.d("EntryInfo", emotion + ", " + rate + ", " + dateToStr);
            FileWriter fw = new FileWriter(entriesData, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(emotion+","+rate+","+dateToStr+'\n');
            bw.close();

            }



    public void openActivityHomie(View v) {
        openActivityHome();
    }
    public void openActivityHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    }

