package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.morningDropdown);
        ArrayAdapter<CharSequence> morningAdapter = ArrayAdapter.createFromResource(this, R.array.morningTimes, android.R.layout.simple_spinner_item);
        morningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(morningAdapter);

        Spinner spinner2 = (Spinner) findViewById(R.id.eveningDropdown);
        ArrayAdapter<CharSequence> eveningAdapter = ArrayAdapter.createFromResource(this, R.array.eveningTimes, android.R.layout.simple_spinner_item);
        eveningAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(eveningAdapter);
    }
}

    //public void goToTimes (View view){
      //  Intent intent = new Intent(this, times.class);
        //startActivity(intent);}






