package com.onlywatch.fleriche.onlywatch.entity;

/**
 * This entity represent a skill and will be persisted into the corresponding 'skill' table in database.
 * It is simple POJO containing get/set methods to store data retrieved using DAO class.
 */
public class Skill {
    private int id;
    private String nom;
    private String canonical_name;
    private String description;
    private String features;
    private int id_heroes;
    private Integer is_favorite;
    private Integer id_locale;

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

    public Integer getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(Integer is_favorite) {
        this.is_favorite = is_favorite;
    }

    public boolean isFavorite() {
        return getIs_favorite() == 1;
    }

    public Integer getId_locale() {
        return id_locale;
    }

    public void setId_locale(Integer id_locale) {
        this.id_locale = id_locale;
    }
}
