package com.example.gaetan.applicationquizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gaetan.applicationquizz.SQLite.DataBaseManager;
import com.example.gaetan.applicationquizz.models.Question;
import com.example.gaetan.applicationquizz.models.Score;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DataBaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menu1 = findViewById(R.id.fastquizz);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, FastActivity.class);
                startActivity(intent);
            }
        });

        Button menu2 = findViewById(R.id.score);
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });

        dbm = new DataBaseManager(this);
        dbm.purgeTableQuestion();
        dbm.insertDatasets();
        /*List<Score> scores = dbm.selectAllScore();
        for( Score score  : scores ){
            Log.i("score", " "+ score.getScore());
        }
        Log.i("score",Integer.toString(dbm.selectAllScore().get(0).getScore()));*/
    }
}
