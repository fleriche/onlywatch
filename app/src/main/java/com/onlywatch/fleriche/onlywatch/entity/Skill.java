package com.onlywatch.fleriche.onlywatch.entity;

/**
 * Created by florian on 08/11/16
 */

public class Skill {
    private int id;
    private String nom;
    private String canonical_name;
    private String description;
    private String features;
    private int id_heroes;

    public Skill(){}

    public Skill(int id, String nom, String description, String features, int id_heroes){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.features = features;
        this.id_heroes = id_heroes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_heroes() {
        return id_heroes;
    }

    public void setId_heroes(int id_heroes) {
        this.id_heroes = id_heroes;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCanonical_name() {
        return canonical_name;
    }

    public void setCanonical_name(String canonical_name) {
        this.canonical_name = canonical_name;
    }
}
