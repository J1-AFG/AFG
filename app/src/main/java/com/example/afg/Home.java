package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Home extends AppCompatActivity {
    TextView summaryTextStr;
    @Override
    /**
     * Initializes the display text
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        summaryTextStr = (TextView) findViewById(R.id.SummaryTextStr);
/**
        TextView summaryText = findViewById(R.id.SummaryTextStr);
        String Summary1VariableStr = "-VARIABLE-";
        String Summary1MoodStr = "-MOOD-";
 "It seems like " + Summary1VariableStr + " is affecting your " + Summary1MoodStr
 **/
        summaryTextStr.setText("The following moods have significant differences in ratings depending on time of day:");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        }

    }
    @Override
    /**
     * Rereads the CSV to accept any new changes
     */
    protected void onResume() {
        super.onResume();
        try {
            readFromCSV();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    /**
     * Opens the Graphs activity
     * @param v - view
     */
    public void openActivityGraphz(View v) {
        openActivityGraphs();
    }
    public void openActivityGraphs() {
        Intent intent = new Intent(this, Graphs.class);
        startActivity(intent);
    }

    /**
     * Opens the Goals activity
     * @param v - view
     */
    public void openActivityGoalz(View v) {
        openActivityGoals();
    }
    public void openActivityGoals() {
        Intent intent = new Intent(this, Goals.class);
        startActivity(intent);
    }

    /**
     * Opens the Settings activity
     * @param v - view
     */
    public void openActivitySettingz(View v) {
        openActivitySettings();
    }
    public void openActivitySettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    /**
     * Opens the Entries activity
     * @param v - view
     */
    public void openActivityEntriez(View v) {
        openActivityEntries();
    }
    public void openActivityEntries() {
        Intent intent = new Intent(this, Entries.class);
        startActivity(intent);
    }

    /**
     * Reads the CSV data, stores that data in one Entry Arraylist,
     * splits that data based on emotion and stores it in separate ArrayLists,
     * updates the display text to show which emotions show significant differences.
     * @throws IOException
     * @throws CsvValidationException
     * @throws ParseException
     */
    public void readFromCSV() throws IOException, CsvValidationException, ParseException {
        Entry e = new Entry();
        ArrayList<Entry> elist = new ArrayList<Entry>();
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filename = "entriesData.csv";
        SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm:ss a");
        Date d;
        File entriesData = new File(dir, filename);
        ArrayList<Entry> happyList = new ArrayList<Entry>();
        ArrayList<Entry> sadList = new ArrayList<Entry>();
        ArrayList<Entry> angryList = new ArrayList<Entry>();
        ArrayList<Entry> stressList = new ArrayList<Entry>();
        ArrayList<Entry> otherList = new ArrayList<Entry>();
        CSVReader reader = new CSVReader(new FileReader(entriesData));
        String[] nextLine;

        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            String feeling = nextLine[0];
            int rating = Integer.parseInt(nextLine[1]);
            String date = nextLine[2];
            e.setFeeling(feeling);
            e.setRating(rating);
            e.setTimeOfDay(date);
            elist.add(e);
        }
        for (int i=0; i<elist.size(); i++){
            if (elist.get(i).getFeeling().equals("Happy")){
                happyList.add(elist.get(i));
            }
            if (elist.get(i).getFeeling().equals("Sad")){
                sadList.add(elist.get(i));
            }
            if (elist.get(i).getFeeling().equals("Angry")){
                angryList.add(elist.get(i));
            }
            if (elist.get(i).getFeeling().equals("Stress")){
                stressList.add(elist.get(i));
            }
            if (elist.get(i).getFeeling().equals("Other")){
                otherList.add(elist.get(i));
            }
        }
            Algorithm a = new Algorithm();
        summaryTextStr = (TextView) findViewById(R.id.SummaryTextStr);
            if(a.calculateANOVA(happyList)&&!(summaryTextStr.getText().toString().contains("Happy"))){
                summaryTextStr.setText(summaryTextStr.getText().toString()+" Happy");
            }
        if(a.calculateANOVA(sadList)&&!(summaryTextStr.getText().toString().contains("Sad"))){
            summaryTextStr.setText(summaryTextStr.getText().toString()+" Sad");
        }
        if(a.calculateANOVA(angryList)&&!(summaryTextStr.getText().toString().contains("Angry"))){
            summaryTextStr.setText(summaryTextStr.getText().toString()+" Angry");
        }
        if(a.calculateANOVA(stressList)&&!(summaryTextStr.getText().toString().contains("Stress"))){
            summaryTextStr.setText(summaryTextStr.getText().toString()+" Stress");
        }
        if(a.calculateANOVA(otherList)&&!(summaryTextStr.getText().toString().contains("Other"))){
            summaryTextStr.setText(summaryTextStr.getText().toString()+" Other");
        }
            Log.d("Algorithm Results", a.calculateANOVA(happyList)+", "+a.calculateANOVA(sadList)+", "+a.calculateANOVA(angryList)+", "+a.calculateANOVA(stressList)+", "+a.calculateANOVA(otherList));


    }
}
