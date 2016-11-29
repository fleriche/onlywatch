package com.onlywatch.fleriche.onlywatch.entity;

/**
 * Created by florian on 29/11/16
 */

public class Map {
    private int id;
    private String nom;
    private String canonical_name;
    private String location;
    private String summary;

    public Map(){}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCanonical_name() {
        return canonical_name;
    }

    public void setCanonical_name(String canonical_name) {
        this.canonical_name = canonical_name;
    }
}
