package com.example.gaetan.applicationquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaetan.applicationquizz.SQLite.DataBaseManager;
import com.example.gaetan.applicationquizz.models.Question;

import java.util.List;

public class FastActivity extends AppCompatActivity {

    private String GoodResponse = null;
    private DataBaseManager dbm = new DataBaseManager(this);
    private int page = 0;
    private FastActivity self = this;//Réference mémoire à l'objet courant.
    private TextView question;
    private Button reponse1;
    private Button reponse2;
    private Button reponse3;
    private Button reponse4;
    private TextView AffichScore;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast);

        //GoodResponse = requeteSql;
        question = (TextView)findViewById(R.id.titre);
        reponse1 = (Button)findViewById(R.id.response1);
        reponse2 = (Button)findViewById(R.id.response2);
        reponse3 = (Button)findViewById(R.id.response3);
        reponse4 = (Button)findViewById(R.id.response4);
        AffichScore = (TextView)findViewById(R.id.testscore);
        this.Datasets();


        reponse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReponseChoisie = reponse1.getText().toString();
                if(ReponseChoisie.equals(GoodResponse)){
                    score++;
                    self.Datasets();
                    Toast.makeText(self,"Bonne Reponse",Toast.LENGTH_SHORT).show();


                }
                else{
                    finish();
                    //Toast.makeText("Perdu :Mauvaise Reponse");
                    Toast.makeText(self,"Mauvaise Reponse",Toast.LENGTH_SHORT).show();
                    dbm.insertScore(self.score);

                    //Arreter Activitter
                }

            }
        });

        reponse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReponseChoisie = reponse2.getText().toString();
                if(ReponseChoisie.equals(GoodResponse)){
                    score++;
                    self.Datasets();
                    Toast.makeText(self,"Bonne Reponse",Toast.LENGTH_SHORT).show();

                    //Toast.makeText("Bonne Reponse");

                }
                else{
                    finish();
                    Toast.makeText(self,"Mauvaise Reponse",Toast.LENGTH_SHORT).show();
                    dbm.insertScore(self.score);
                    //Toast.makeText("Perdu :Mauvaise Reponse");

                    //Arreter Activitter
                }
            }
        });

        reponse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReponseChoisie = reponse3.getText().toString();
                if(ReponseChoisie.equals(GoodResponse)){
                    score++;
                    self.Datasets();
                    Toast.makeText(self,"Bonne Reponse",Toast.LENGTH_SHORT).show();

                    //Toast.makeText("Bonne Reponse");

                }
                else{
                    finish();
                    Toast.makeText(self,"Mauvaise Reponse",Toast.LENGTH_SHORT).show();
                    dbm.insertScore(self.score);
                    //Toast.makeText("Perdu :Mauvaise Reponse");

                    //Arreter Activitter
                }
            }
        });

        reponse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ReponseChoisie = reponse4.getText().toString();
                if(ReponseChoisie.equals(GoodResponse)){
                    score++;
                    self.Datasets();
                    //Toast.makeText("Bonne Reponse");
                    Log.i("response", "bonne reponse");

                }
                else{
                    finish();
                    Toast.makeText(self,"Mauvaise Reponse",Toast.LENGTH_SHORT).show();
                    dbm.insertScore(self.score);
                    //Log.i("response", "Mauvaise Reponse");

                    //Arreter Activitter
                }
            }
        });



    }
    public void Datasets(){
        List<Question> questions = dbm.selectAll();
        if(this.page < questions.size()){
            this.question.setText(questions.get(this.page).getTitle());
            this.reponse1.setText(questions.get(this.page).getResponseOne());
            this.reponse2.setText(questions.get(this.page).getResponseTwo());
            this.reponse3.setText(questions.get(this.page).getResponseThree());
            this.reponse4.setText(questions.get(this.page).getResponseFour());
            this.GoodResponse = questions.get(this.page).getGoodResponse();
            this.AffichScore.setText(Integer.toString(this.score));

            questions.get(this.page).getGoodResponse();
            this.page++;
        }else{
            Toast.makeText(self,"Bravo tu as fini le jeux, C'etait dur ? :kappa: ",Toast.LENGTH_SHORT).show();
            score++;
            dbm.insertScore(self.score);

            finish();
        }
        dbm.close();
    }
}
