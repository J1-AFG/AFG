package com.example.afg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

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
     * Opens the Home activity
     * @param v - view
     */
    public void openActivityHomie(View v) {
        openActivityHome();
    }
    public void openActivityHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}
