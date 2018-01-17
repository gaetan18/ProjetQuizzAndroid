package com.example.hamza.quizzdb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveDataBase (View view) {
        SQLiteDatabase db;

        try {
            DataBaseHelper dataBaseHelper = new DataBaseHelper(this, DataBaseHelper.DB_NAME, DataBaseHelper.DB_VERSION);
            db = dataBaseHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            //Log.e(tag:"DATABASE", msg:"")
            db = openOrCreateDatabase(DataBaseHelper.DB_NAME, MODE_APPEND, null);
        }

        Joueur joueur = new Joueur();
        joueur.setNom("SMATI");
        joueur.setPrenom("Hamza");

        ContentValues insertRow = new ContentValues();

        insertRow.put(Joueur.COL_NOM, joueur.getNom());
        insertRow.put(Joueur.COL_PRENOM, joueur.getPrenom());
        long idInserted = db.insert(Joueur.TABLE_NAME, null, insertRow);
        joueur.setId(idInserted);
        Log.i("INSERT", joueur.toString());

        Question q1 = Question("test bd");



        //UPDATE
        ContentValues updateRow = new ContentValues();
        updateRow.put(Joueur.COL_NOM, "ZOUZA");
        String [] updateWhereArgs = {"SMATI"};
        int nbUdate = db.update(joueur.TABLE_NAME, updateRow,
                Joueur.COL_NOM +" = ?", updateWhereArgs);
        Log.i("UPDATE", "nbUpdate = "+nbUdate);

        //SELECT
        Cursor cursor = db.query(Joueur.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            int firstNameIndex = cursor.getColumnIndex(Joueur.COL_NOM);
            String firstName = cursor.getString(firstNameIndex);
            Log.i("SELECT", firstName);
        }


        //DELETE
        String [] deleteWhereArgs = {String.valueOf(joueur.getId()), joueur.getNom()};

        int nbDelete = db.delete(Joueur.TABLE_NAME, Joueur.COL_ID +" = ? AND "+Joueur.COL_NOM+ " = ?", deleteWhereArgs);
        Log.i("DELETE", "nbDelete"+nbDelete);

    }
}
