package com.example.afg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Goals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goals);

    }
    public void openActivityGraphz(View v) {
        openActivityGraphs();
    }
    public void openActivityGraphs() {
        Intent intent = new Intent(this, Graphs.class);
        startActivity(intent);
    }


    public void openActivityGoalz(View v) {
        openActivityGoals();
    }
    public void openActivityGoals() {
        Intent intent = new Intent(this, Goals.class);
        startActivity(intent);
    }


    public void openActivitySettingz(View v) {
        openActivitySettings();
    }
    public void openActivitySettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void openActivityHomie(View v) {
        openActivityHome();
    }
    public void openActivityHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
