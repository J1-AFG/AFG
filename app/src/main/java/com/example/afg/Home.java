package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


    }
    public void openActivity(View v) {
        //openActivityCharts();
    }
/*
    public void openActivityCharts() {
        Intent intent = new Intent(this, Charts.class);
        startActivity(intent);
    }
*/


}
