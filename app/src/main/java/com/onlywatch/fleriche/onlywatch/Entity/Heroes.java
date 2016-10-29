package com.onlywatch.fleriche.onlywatch.Entity;

/**
 * Created by florian on 28/09/16
 */

public class Heroes {
    private int id;
    private String nom;
    private int difficulty;

    public Heroes() {}

    public Heroes(int id, String nom, int difficulty) {
        this.id = id;
        this.nom = nom;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
