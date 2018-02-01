package com.example.gaetan.applicationquizz.models;


import android.support.annotation.NonNull;

import java.util.Date;

public class Score implements Comparable<Score> {
    private int id;
    private int score;
    private Long date;

    public Score(int id, int score, Long date) {
        this.id = id;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getDate(){return date;}
    public void setDate(Long date){this.date = date;}

    @Override
    public String toString() {
        Date date = new Date(this.date);

        return  Integer.toString(score) + " points | date " + " : " + date;

    }

    @Override
    public int compareTo(@NonNull Score score) {
        if(score.getScore() > this.getScore())
        {
            return 1;
        }else if(score.getScore() < this.getScore()) {
            return -1;
        }
        return 0;

    }
}
