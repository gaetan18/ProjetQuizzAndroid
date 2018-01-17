package com.example.hamza.quizzdb;

/**
 * Created by hamza on 15/01/2018.
 */

public class Joueur {

    public static final String TABLE_NAME = "JOUEUR";
    public static final String COL_ID = "ID";
    public static final String COL_NOM = "NOM";
    public static final String COL_PRENOM = "PRENOM";
    public static final String COL_SCORE = "SCORE";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_NOM+ " VARCHAR, "+COL_PRENOM+" VARCHAR, "+ COL_SCORE+" VARCHAR )";

    private long id;
    private String nom;
    private String prenom;
    private int score;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", score=" + score +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getScore() {
        return score;
    }
}
