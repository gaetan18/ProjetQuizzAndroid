package com.example.hamza.quizzdb;

/**
 * Created by hamza on 16/01/2018.
 */

public class Questionnaire {

    public static final String TABLE_NAME = "QUESTIONNAIRE";
    public static final String COL_ID = "ID";
    public static final String COL_QUESTION = "IDQUESTION";
    public static final String COL_THEME = "IDTHEME";



    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_QUESTION+" VARCHAR )";

    private long id;
    private long question;
    private long idTheme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getQuestion() {
        return question;
    }

    public void setQuestion(long question) {
        this.question = question;
    }

    public long getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(long idTheme) {
        this.idTheme = idTheme;
    }
}
