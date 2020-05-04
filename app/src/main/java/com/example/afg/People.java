package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class People extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
    }

    public void openActivity(View v) {
        openActivityLocation();
    }

    public void openActivityLocation() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }
}
