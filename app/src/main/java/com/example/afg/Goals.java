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

    /**
     * Opens the Graphs activity
     * @param v - view
     */
    public void openActivityGraphz(View v) {
        openActivityGraphs();
    }

    /**
     * Opens the Graphs activity
     */
    public void openActivityGraphs() {
        Intent intent = new Intent(this, Graphs.class);
        startActivity(intent);
    }

    /**
     * Opens the Goals activity
     * @param v - view
     */
    public void openActivityEntriez(View v) {
        openActivityEntries();
    }

    /**
     * Opens the Goals activity
     */
    public void openActivityEntries() {
        Intent intent = new Intent(this, Entries.class);
        startActivity(intent);
    }

    /**
     * Opens the Settings activity
     * @param v - view
     */
    public void openActivitySettingz(View v) {
        openActivitySettings();
    }

    /**
     * Opens the Settings activity
     */
    public void openActivitySettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Opens the Home activity
     * @param v - view
     */
    public void openActivityHomie(View v) {
        openActivityHome();
    }

    /**
     * Opens the Home activity
     */
    public void openActivityHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
