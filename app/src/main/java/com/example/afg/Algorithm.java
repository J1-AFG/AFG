
package com.example.afg;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Algorithm {
    //data

    private ArrayList<Entry> entries;
    private Date d;
    private Date morning;
    private Date afternoon;
    private Date night;

    //constructors
    public Algorithm() throws IOException {
        entries = new ArrayList<Entry>();
    }

    public Algorithm(ArrayList<Entry> e) throws IOException {
        entries = e;
    }

    //methods

    public void addEntry(String time, int rate, String feel) {
        Entry entry = new Entry(time, rate, feel);
        entries.add(entry);
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public boolean calculateANOVA(ArrayList<Entry> e) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm:ss a");
        morning = sdf.parse("4:00:00 AM");
        afternoon = sdf.parse("12:00:00 PM");
        night = sdf.parse("8:00:00 PM");
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<Integer> rate = new ArrayList<Integer>();
        ArrayList<String> feel = new ArrayList<String>();
        for (int i = 0; i < e.size(); i++) {
            feel.add(e.get(i).getFeeling());

            rate.add(e.get(i).getRating());

            d = sdf.parse(e.get(i).getTimeOfDay());

            if (d.compareTo(morning)>=0&&d.compareTo(afternoon)<0){
                time.add("morning");
            }
            if (d.compareTo(afternoon)>=0&&d.compareTo(night)<0){
                time.add("afternoon");
            }
            if (d.compareTo(night)>=0&&d.compareTo(morning)<0){
                time.add("night");
            }
        }

        ArrayList<Integer> Morning = new ArrayList<Integer>();
        ArrayList<Integer> Afternoon = new ArrayList<Integer>();
        ArrayList<Integer> Night = new ArrayList<Integer>();

        for (int i = 0; i < time.size(); i++) {
            if (time.get(i).equals("morning")) {
                Morning.add(rate.get(i));
            }
            if (time.get(i).equals("afternoon")) {
                Afternoon.add(rate.get(i));
            }
            if (time.get(i).equals("night")) {
                Night.add(rate.get(i));
            }
        }

        double SumOfSquares = returnWeirdThing(Morning) + returnWeirdThing(Afternoon) + returnWeirdThing(Night);
        double MeanSumOfSquaresWithin = SumOfSquares / (rate.size() - 3);

        double n1 = Morning.size() * Math.pow(returnAverage(Morning) - returnAverage(rate), 2);
        double n2 = Afternoon.size() * Math.pow(returnAverage(Afternoon) - returnAverage(rate), 2);
        double n3 = Night.size() * Math.pow(returnAverage(Night) - returnAverage(rate), 2);
        double SumOfNs = n1 + n2 + n3;

        double MeanSumOfSquaresBetween = SumOfNs / (3 - 1);

        double F = MeanSumOfSquaresBetween / MeanSumOfSquaresWithin;

        double DegreesOfFreedomBetween = 3 - 1;
        double DegreesOfFreendomWithin = rate.size() - 3;


        double comparison = 34.049 * Math.pow(DegreesOfFreendomWithin, -0.788);

        if (F > comparison) {
            return true;
        } else
            return false/*"There is no significant difference between the ratings of the " + feel.get(0) + " emotion."*/;
    }

    public static double returnAverage(ArrayList<Integer> time) {
        double average = 0;
        for (int i = 0; i < time.size(); i++) {
            average = average + time.get(i);
        }
        return average / time.size();
    }

    public static double returnWeirdThing(ArrayList<Integer> time) {
        ArrayList<Double> time2 = new ArrayList<Double>();
        for (int i = 0; i < time.size(); i++) {
            time2.add(Math.pow(time.get(i) - returnAverage(time), 2));
        }

        double sum = 0;
        for (int i = 0; i < time.size(); i++) {
            sum = sum + time2.get(i);
        }
        return sum;
    }
}


