package com.example.gaetan.applicationquizz.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gaetan.applicationquizz.models.Question;
import com.example.gaetan.applicationquizz.models.Score;

import java.util.ArrayList;
import java.util.List;


public class DataBaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "question";
    private static final String TABLE_S = "score";

    public DataBaseManager( Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "Create table "+ TABLE +" ( id integer primary key autoincrement, title text, responseOne text, responseTwo text, responseThree text, responseFour text, theme text, goodResponse String)";
        db.execSQL(query);
        String queryS = "Create table "+ TABLE_S +" ( id integer primary key autoincrement, score integer)";
        db.execSQL(queryS);
        Log.i("DATABASE","Base de donnée crée");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table " + TABLE;
        String queryS = "drop table " + TABLE_S;
        db.execSQL(query);
        db.execSQL(queryS);
        this.onCreate(db);
        Log.i("DATABASE", "table mis a jour");

    }
    public void purgeTableQuestion()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "delete from " + TABLE;
        db.execSQL(query);
        Log.i("DATABASE", "table purgée");
    }

    public void insertData(String title, String responseOne,String responseTwo, String responseThree, String responseFour, String theme, String goodResponse){
        String query = "insert into "+TABLE+"(title,responseOne,responseTwo,responseThree,responseFour,theme,goodResponse) VALUES ('"+title+"','"+responseOne+"','"+responseTwo+"','"+responseThree+"','"+responseFour+"','"+theme+"','"+goodResponse+"')";
        this.getWritableDatabase().execSQL(query);
        Log.i("DATABASE", "insert data");
    }
    public void insertScore(int score){
        String queryS = "insert into "+TABLE_S+"(score) VALUES ("+score+")";
        this.getWritableDatabase().execSQL(queryS);
    }

    public List<Question> selectAll(){
        List<Question> questions = new ArrayList<>();
        String query = "Select * from " + TABLE;
        Cursor cursor = this.getReadableDatabase().rawQuery(query, null);
        cursor.moveToFirst();
        Log.i("DATABASE", "Select all");
        while(!cursor.isAfterLast()){
            Question question = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getString(3),cursor.getString(4), cursor.getString(5),cursor.getString(6),cursor.getString(7));
            questions.add(question);
            cursor.moveToNext();

        }
        return questions;
    }
    public List<Score> selectAllScore()
    {
        List<Score> scores = new ArrayList<>();
        String queryS = "Select * from " + TABLE_S;
        Cursor cursor = this.getReadableDatabase().rawQuery(queryS, null);
        cursor.moveToFirst();
        Log.i("DATABASE", "Select all");
        while(!cursor.isAfterLast()){
            Score score = new Score(cursor.getInt(0),cursor.getInt(1));
            scores.add(score);
            cursor.moveToNext();

        }
        return scores;
    }
    public void insertDatasets(){
        //this.onReset(db);
        this.insertData("Quel acronyme de dragon ball n’existe pas ","db","dbz","dba","dbz","test","dba");
        this.insertData("Quel est la capital de la france","isle-Adam","Paris","persan","cergy","test2","Paris");
        this.insertData("Quel est la Cryptomonnaie la plus populaire","bitcoin","etherum","Zcash","Litecoin","test3","bitcoin");
        this.insertData("Quel est le meilleur jeux de tous les temps","CS:GO","CS:1.6","CS:CZ","CS","test4","CS:GO");
    }



}
