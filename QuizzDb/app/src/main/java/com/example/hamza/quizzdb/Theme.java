package com.example.hamza.quizzdb;

/**
 * Created by hamza on 16/01/2018.
 */

public class Theme {

    public static final String TABLE_NAME = "THEME";
    public static final String COL_ID = "ID";
    public static final String COL_THEME = "THEME";




    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_THEME+" VARCHAR )";

    private long id;
    private long theme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTheme() {
        return theme;
    }

    public void setTheme(long theme) {
        this.theme = theme;
    }
}
