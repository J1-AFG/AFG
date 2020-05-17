
package com.example.afg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;



public class Graphs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs);

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
     * Opens the Settings activity
     * @param v - view
     */
    public void openActivitySettingz(View v) {
        openActivitySettings();
    }
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
    public void openActivityHome() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}

    /*
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