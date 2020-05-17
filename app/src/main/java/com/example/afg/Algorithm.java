
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

    /**
     * Constructs a default Algorithm that takes no input
     * @throws IOException
     */
    public Algorithm() throws IOException {
        entries = new ArrayList<Entry>();
    }

    /**
     * Constructs an Algorithm that takes an ArrayList of Entry objects as input
     * @param e - an ArrayList of Entry objects
     * @throws IOException
     */
    public Algorithm(ArrayList<Entry> e) throws IOException {
        entries = e;
    }

    //methods

    /**
     * Adds an Entry to an ArrayList of Entry objects
     * @param time - the time at which the entry was created
     * @param rate - the rating of the feeling
     * @param feel - the feeling
     */
    public void addEntry(String feel, int rate, String time) {
        Entry entry = new Entry(feel, rate, time);
        entries.add(entry);
    }

    /**
     * gets the ArrayList of entries
     * @return the ArrayList of entries
     */
    public ArrayList<Entry> getEntries() {
        return entries;
    }

    /**
     * Determines if there is a significant difference between the ratings of emotions based on time of day
     * @param e - ArrayList of all Entry objects
     * @return true if there is a significant difference between the ratings of emotions based on time of day, false otherwise
     * @throws ParseException
     */
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

    /**
     * computes the average of ratings of the entries
     * @param rate - an ArrayList containing ratings from the entries
     * @return the average of ratings of the entries
     */
    public static double returnAverage(ArrayList<Integer> rate) {
        double average = 0;
        for (int i = 0; i < rate.size(); i++) {
            average = average + rate.get(i);
        }
        return average / rate.size();
    }

    /**
     * returns a (weird) double needed for the ANOVA test
     * @param rate - an ArrayList containing ratings from the entries
     * @return a double needed for the ANOVA test
     */
    public static double returnWeirdThing(ArrayList<Integer> rate) {
        ArrayList<Double> time2 = new ArrayList<Double>();
        for (int i = 0; i < rate.size(); i++) {
            time2.add(Math.pow(rate.get(i) - returnAverage(rate), 2));
        }

        double sum = 0;
        for (int i = 0; i < rate.size(); i++) {
            sum = sum + time2.get(i);
        }
        return sum;
    }
}


