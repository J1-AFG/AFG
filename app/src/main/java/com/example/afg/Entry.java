package com.example.afg;


public class Entry {
    //data
    private String timeOfDay;
    private int rating;
    private String feeling;
    //constructors
    /**
     * Creates a new entry
     * @param time
     * @param rate
     * @param feel
     */
    public Entry (String feel, int rate, String time) {
        timeOfDay = time;
        rating = rate;
        feeling = feel;
    }
    /**
     * @return the timeOfDay
     */
    public String getTimeOfDay() {
        return timeOfDay;
    }
    /**
     * @param timeOfDay the timeOfDay to set
     */
    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    /**
     * @return the feeling
     */
    public String getFeeling() {
        return feeling;
    }
    /**
     * @param feeling the feeling to set
     */
    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }
    /**
     * default constructor
     */
    public Entry () {
        timeOfDay = null;
        rating = 0;
        feeling = null;
    }
    //methods
}

