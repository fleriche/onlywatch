package com.onlywatch.fleriche.onlywatch.entity;

/**
 * Created by florian on 29/11/16
 */

public class Map {
    private int id;
    private String nom;
    private String canonical_name;
    private String location;
    private String gamemode;
    private String description;
    private String background;
    private String strategy;
    private String easter_eggs;
    private Integer is_favorite;
    private Integer id_locale;

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

    public String getCanonical_name() {
        return canonical_name;
    }

    public void setCanonical_name(String canonical_name) {
        this.canonical_name = canonical_name;
    }

    public String getGamemode() {
        return gamemode;
    }

    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getEaster_eggs() {
        return easter_eggs;
    }

    public void setEaster_eggs(String easter_eggs) {
        this.easter_eggs = easter_eggs;
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
