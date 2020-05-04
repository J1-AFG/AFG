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

    SharedPreferences Preferences = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor Editor = Preferences.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}







