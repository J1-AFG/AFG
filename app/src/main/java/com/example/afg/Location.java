package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    /**
     * Opens the Times activity
     * @param v - view
     */
    public void openActivity(View v) {
        openActivityTimes();
    }

    public void openActivityTimes() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
