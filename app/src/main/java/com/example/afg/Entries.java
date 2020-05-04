package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class Entries extends AppCompatActivity {
    private CheckBox locationBox;
    private CheckBox activityBox;
    private CheckBox companyBox;
    private CheckBox sleepBox;
    private EditText customFeature;
    private Button addButton;
    private Button welcomeContinueButton;
    private ArrayList<String> entriesArray;
    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entries);

        if (Preferences.getBoolean(getString(R.string.happyBox),false) == true){
            entriesArray.add("Happy");
        }
        if (Preferences.getBoolean(getString(R.string.sadBox),false) == true){
            entriesArray.add("Sad");
        }
        if (Preferences.getBoolean(getString(R.string.angryBox),false) == true){
            entriesArray.add("Angry");
        }
        if (Preferences.getBoolean(getString(R.string.stressBox),false) == true){
            entriesArray.add("Stress");
        }
        if(Preferences.getString(getString(R.string.customEmotion),"")!=""){
            entriesArray.add(Preferences.getString(getString(R.string.customEmotion),""));
        }
    }
}
