package com.example.gaetan.applicationquizz.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.gaetan.applicationquizz.models.Question;
import com.example.gaetan.applicationquizz.models.Score;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DataBaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz.db";
    private static final int DATABASE_VERSION = 22;
    private static final String TABLE = "question";
    private static final String TABLE_S = "score";

    public DataBaseManager( Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "Create table "+ TABLE +" ( id integer primary key autoincrement, title text, responseOne text, responseTwo text, responseThree text, responseFour text, theme text, goodResponse String)";
        db.execSQL(query);
        String queryS = "Create table "+ TABLE_S +" ( id integer primary key autoincrement, score integer, date date)";
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
    public void insertScore(int score, Long date){
        String queryS = "insert into "+TABLE_S+"(score, date) VALUES ("+score+","+date+")";
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
            Score score = new Score(cursor.getInt(0),cursor.getInt(1), cursor.getLong(2));
            scores.add(score);
            cursor.moveToNext();

        }
        return scores;
    }

   public int getScoreMax(){
        String queryS = "Select Max(score) from " + TABLE_S;
        Cursor cursor = this.getReadableDatabase().rawQuery(queryS, null);
       cursor.moveToFirst();
        //Score score = new Score(cursor.getInt(0),cursor.getInt(1), cursor.getLong(2));
        Log.i("DATABASE", "Select max : "+cursor.getInt(0));
        return cursor.getInt(0);
    }

    public void insertDatasets(){
        //this.onReset(db);
        this.insertData("Quel film  n’a pas recu d’oscar ?","Dragon Ball Evolution","La La Land","le silence des agneaux","Rocky","cinema","Dragon Ball Evolution");
        this.insertData("Quel est le 1er disney a etre sortie au cinema ?","mulan","la reine des neige","Bambi","blanche-neige et les 7 nains","cinema","blanche-neige et les 7 nains");
        this.insertData("Quel est le premier star wars a etre sortie au cinema ?","le reveil de la force","un nouvel espoir","la menace fantome"," l’empire contre-attaque","cinema","un nouvel espoir");
        this.insertData("Quel est le 1er film pixar ?","Toy Story","Cars","Monstre & cie","nemo","cinema","Toy Story");
        this.insertData("Quel est le plus gros succes de tout les temps ?","Avatar","Matrix","Avengers","Star trek","cinema","Avatar");
        this.insertData("De quel Jeux est adapter le jeu Warcraft ?","Warcraft 1","Warcraft 2","Warcraft 3","Warcraft 4","cinema","Warcraft 1");
        this.insertData("Dans quel film de Darren Aronofsky, Nathalie Portman a t-elle jouer ?","Star Wars","Leon","Black Swan","V pour Vendetta","cinema","Black Swan");
        this.insertData("Quel Franchise d’action a fait connaitre Vin Diesel","Fast and Furious","Pitch Black","XXX","50 Nuances de Grey","cinema","Fast and Furious");
        this.insertData("Quel héros Marvel Sam Remi a t-il mis en scène ?","Kingsman","Wolwerine","Spider-man","Iron-man","cinema","Spider-man");
        this.insertData("Parmi ces film, lequelle est un Miyasaki ?","Your name","Freres des ours","Hercule","Princesse Mononoke","cinema","Princesse Mononoke");
        this.insertData("Quelle Star interprete le heros du film mission impossible ?","Leonardo Dicaprio","Tom Cruise","Hugh Jackman","Charlize Theron","cinema","Tom Cruise");
        this.insertData("Quelle Acteur a recu un oscar avec seulement 20 minutes de presence dans le film ?","Antonio banderas(Zorro)","Zac Effron(High School Musical))","Dwayne Johnson(San andreas)","Anthony Hopkins(Le Silence des agneaux","cinema","Anthony Hopkins(Le Silence des agneaux");
        this.insertData("Pour quel film celine dion a t-elle fait la bande originale ?","Mad Max","Speed Racer","Hercule","Titanic","cinema","Titanic");
        this.insertData("Quelle Film a rendu celebre Mel Gibson ?","Star trek","The reader","Mad Max","Grand Budapest Hotel","cinema","Mad Max");
        this.insertData("Quelle trilogie a t-elle recu au moins un oscar pour chaque film ? ?","Le seigneur des anneaux","The Dark Knight","Mad Max","Star Wars","cinema","Le seigneur des anneaux");
    }



}
