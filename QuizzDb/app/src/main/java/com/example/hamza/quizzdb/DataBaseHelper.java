package com.example.hamza.quizzdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hamza on 15/01/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "QuizzDb";
    public static final int  DB_VERSION = 1;


    public DataBaseHelper(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Joueur.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion < 2) {

        }
    }
}
