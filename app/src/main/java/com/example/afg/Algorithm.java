package com.example.afg;

import java.util.ArrayList;

public class Algorithm {
    //data
    private ArrayList<Entry> entries;

    //constructors
    public Algorithm() {
        entries = new ArrayList<Entry>();
    }
    public Algorithm(ArrayList<Entry> e) {
        entries = e;
    }
    //methods
    public static void main(String[] args) {
        Algorithm a = new Algorithm();
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 2, "Happy");
        a.addEntry("Morning", 7, "Happy");
        a.addEntry("Morning", 0, "Happy");
        a.addEntry("Morning", 10, "Happy");
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 3, "Happy");
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 0, "Happy");
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 8, "Happy");
        a.addEntry("Morning", 10, "Happy");
        a.addEntry("Morning", 10, "Happy");
        a.addEntry("Morning", 10, "Happy");

        System.out.println(a.calculateANOVA(a.getEntries()));
    }

    public void addEntry (String time, int rate, String feel) {
        Entry entry = new Entry (time, rate, feel);
        entries.add(entry);
    }

    public ArrayList<Entry> getEntries () {
        return entries;
    }

    public ArrayList<Entry> makeHappyArray(ArrayList<Entry> e) {
        ArrayList <Entry> happy = new ArrayList<Entry>();
        for (int i = 0; i<e.size(); i++) {
            if (e.get(i).getFeeling() == "Happy") {
                happy.add(e.get(i));
            }
        }
        return happy;
    }
    public ArrayList<Entry> makeSadArray(ArrayList<Entry> e) {
        ArrayList <Entry> sad = new ArrayList<Entry>();
        for (int i = 0; i<e.size(); i++) {
            if (e.get(i).getFeeling() == "Sad") {
                sad.add(e.get(i));
            }
        }
        return sad;
    }
    public ArrayList<Entry> makeAngryArray(ArrayList<Entry> e) {
        ArrayList <Entry> angry = new ArrayList<Entry>();
        for (int i = 0; i<e.size(); i++) {
            if (e.get(i).getFeeling() == "Angry") {
                angry.add(e.get(i));
            }
        }
        return angry;
    }
    /**
     public ArrayList<Entry> makeMorningArray(ArrayList<Entry> e) {
     ArrayList <Entry> morning = new ArrayList<Entry>();
     for (int i = 0; i<e.size(); i++) {
     if (e.get(i).getTimeOfDay() == "Morning") {
     morning.add(e.get(i));
     }
     }
     return morning;
     }

     public ArrayList<Entry> makeAfternoonArray(ArrayList<Entry> e) {
     ArrayList <Entry> afternoon = new ArrayList<Entry>();
     for (int i = 0; i<e.size(); i++) {
     if (e.get(i).getTimeOfDay() == "Afternoon") {
     afternoon.add(e.get(i));
     }
     }
     return afternoon;
     }

     public ArrayList<Entry> makeEveningArray(ArrayList<Entry> e) {
     ArrayList <Entry> evening = new ArrayList<Entry>();
     for (int i = 0; i<e.size(); i++) {
     if (e.get(i).getTimeOfDay() == "Evening") {
     evening.add(e.get(i));
     }
     }
     return evening;
     }

     public double getMean(ArrayList<Entry> e) {
     double mean = 0;
     for (int i = 0; i<e.size(); i++) {
     mean += e.get(i).getRating();
     }
     mean = mean / e.size();
     return mean;
     }
     **/

    public String calculateANOVA(ArrayList<Entry> e) {
        ArrayList<String> time = new ArrayList<String>();
        ArrayList<Integer> rate = new ArrayList<Integer>();
        ArrayList<String> feel = new ArrayList<String>();
        for (int i =0; i<e.size(); i++) {
            time.add(e.get(i).getTimeOfDay());
            rate.add(e.get(i).getRating());
            feel.add(e.get(i).getFeeling());
        }

        ArrayList<Integer> Morning = new ArrayList<Integer>();
        ArrayList<Integer> Afternoon = new ArrayList<Integer>();
        ArrayList<Integer> Night = new ArrayList<Integer>();

        for(int i = 0; i < time.size(); i++) {
            if(time.get(i).equals("morning")) {
                Morning.add(rate.get(i));
            }
            if(time.get(i).equals("afternoon")) {
                Afternoon.add(rate.get(i));
            }
            if(time.get(i).equals("night")) {
                Night.add(rate.get(i));
            }
        }

        double SumOfSquares = returnWeirdThing(Morning) + returnWeirdThing(Afternoon) + returnWeirdThing(Night);
        double MeanSumOfSquaresWithin = SumOfSquares/(rate.size() - 3);

        double n1 = Morning.size() * Math.pow(returnAverage(Morning) - returnAverage(rate), 2);
        double n2 = Afternoon.size() * Math.pow(returnAverage(Afternoon) - returnAverage(rate), 2);
        double n3 = Night.size() * Math.pow(returnAverage(Night) - returnAverage(rate), 2);
        double SumOfNs = n1 + n2 + n3;

        double MeanSumOfSquaresBetween = SumOfNs/(3-1);

        double F = MeanSumOfSquaresBetween/MeanSumOfSquaresWithin;

        double DegreesOfFreedomBetween = 3-1;
        double DegreesOfFreendomWithin = rate.size() - 3;


        double comparison = 34.049 * Math.pow(DegreesOfFreendomWithin, -0.788);

        if(F > comparison) {
            return "True: ANOTHER TEST NEEDED";
        }
        else
            return "There is no significant difference between the ratings of the " + feel.get(0)+" emotion.";
    }

    public static double returnAverage(ArrayList<Integer> time) {
        double average = 0;
        for(int i = 0; i < time.size(); i++) {
            average = average + time.get(i);
        }
        return average/time.size();
    }

    public static double returnWeirdThing(ArrayList<Integer> time) {
        ArrayList<Double> time2 = new ArrayList<Double>();
        for(int i = 0; i < time.size(); i++) {
            time2.add(Math.pow(time.get(i) - returnAverage(time), 2));
        }

        double sum = 0;
        for(int i = 0; i < time.size(); i++) {
            sum = sum + time2.get(i);
        }
        return sum;
    }
    /**
     double happyMorningMean = getMean(makeMorningArray(makeHappyArray(e)));
     double happyAfternoonMean = getMean(makeAfternoonArray(makeHappyArray(e)));
     double happyEveningMean = getMean(makeEveningArray(makeHappyArray(e)));

     double sadMorningMean = getMean(makeMorningArray(makeSadArray(e)));
     double sadAfternoonMean = getMean(makeAfternoonArray(makeSadArray(e)));
     double sadEveningMean = getMean(makeEveningArray(makeSadArray(e)));

     double angryMorningMean = getMean(makeMorningArray(makeAngryArray(e)));
     double angryAfternoonMean = getMean(makeAfternoonArray(makeAngryArray(e)));
     double angryEveningMean = getMean(makeEveningArray(makeAngryArray(e)));
     **/




}


