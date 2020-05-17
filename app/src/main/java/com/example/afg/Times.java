package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class Times extends AppCompatActivity {

    @Override
    /**
     * Creates and populates spinners with ranges of times for the user to receive notifications
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.times);

        Spinner spinner1 = (Spinner) findViewById(R.id.morningDropdown);
        ArrayAdapter<CharSequence> morningAdapter = ArrayAdapter.createFromResource(this, R.array.morningTimes, android.R.layout.simple_spinner_item);
        morningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(morningAdapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.eveningDropdown);
        ArrayAdapter<CharSequence> eveningAdapter = ArrayAdapter.createFromResource(this, R.array.eveningTimes, android.R.layout.simple_spinner_item);
        eveningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(eveningAdapter);
    }
    /**
     * Opens the Home activity
     * @param v - view
     */
    public void openActivity(View v) {
        openActivityHome();
    }

    public void openActivityHome() {
        Intent intent = new Intent(this, Activities.class);
        startActivity(intent);
    }
    }

