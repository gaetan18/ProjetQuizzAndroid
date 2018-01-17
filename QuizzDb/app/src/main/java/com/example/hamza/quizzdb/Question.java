package com.example.hamza.quizzdb;

/**
 * Created by hamza on 15/01/2018.
 */

public class Question {

    public static final String TABLE_NAME = "QUESTION";
    public static final String COL_ID = "ID";
    public static final String COL_QUESTION = "QUESTION";
    public static final String COL_REPONSE = "REPONSE";
    public static final String COL_INDICATION = "INDICATION";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_QUESTION+ " VARCHAR, "+COL_REPONSE+" VARCHAR, "+ COL_INDICATION+" VARCHAR )";

    private long id;
    private String question;
    private String reponse;
    private int indication;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getIndication() {
        return indication;
    }

    public void setIndication(int indication) {
        this.indication = indication;
    }
}
