/*
package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Graphs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);
        Algorithm algorithm = new Algorithm();
        createGraph(Algorithm.getEntries());


    }

    public void createGraph(ArrayList<Entry> e){
        LineChart lineChart;
        lineChart = (LineChart) findViewById(R.id.lineChart);

        ArrayList<String> x_axis = new ArrayList<>();
        ArrayList<Entry> y_axis = new ArrayList<>();

        double x = 0.0;
        int numDataPoints = e.size();

        for (int i = 0; i < numDataPoints; i++) {

            float xEntry = Float.parseFloat(String.valueOf(x));
            yAXISsin.add(new Entry(xEntry, sinFunction));
            yAXIScos.add(new Entry(xEntry, cosFunction));

            Log.d("TAG", "Populating Arrays with Data: yAXISsin = " + sinFunction);
            Log.d("TAG", "Populating Arrays with Data: yAXIScos = " + cosFunction);
            Log.d("TAG", "Populating Arrays with Data: xEntry = " + xEntry);

        }
        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet lineDataSet1 = new LineDataSet(yAXIScos,"cos");
        LineDataSet lineDataSet2 = new LineDataSet(yAXISsin,"sin");

        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColors(Color.RED);


        lineDataSets.add(lineDataSet1);


        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);

//can also try calling invalidate() to refresh the graph
        lineChart.invalidate();
    }
}
*/