package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
    }

    /**
     * Opens the People activity
     * @param v - view
     */
    public void openActivity(View v) {
        openActivityPeople();
    }

    /**
     * Opens the People activity
     */
    public void openActivityPeople() {
        Intent intent = new Intent(this, People.class);
        startActivity(intent);
    }
}
