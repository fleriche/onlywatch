package com.onlywatch.fleriche.onlywatch.Entity;

/**
 * Created by florian on 28/09/16
 */

public class Heroes {
    private int id;
    private String nom;
    private int health;
    private int armor;
    private int shield;
    private String real_name;
    private String age;
    private String nationality;
    private String occupation;
    private String base_of_operation;
    private String affiliation;
    private String summary;
    private String quote;
    private String id_role;
    private int difficulty;

    public Heroes() {}

    public Heroes(int id, String nom, int difficulty) {
        this.id = id;
        this.nom = nom;
        this.difficulty = difficulty;
    }

    public Heroes(String nom, int id, int health, int difficulty, String id_role, String quote, int armor, int shield, String real_name, String age, String nationality, String occupation, String base_of_operation, String affiliation, String summary) {
        this.nom = nom;
        this.id = id;
        this.health = health;
        this.difficulty = difficulty;
        this.id_role = id_role;
        this.quote = quote;
        this.armor = armor;
        this.shield = shield;
        this.real_name = real_name;
        this.age = age;
        this.nationality = nationality;
        this.occupation = occupation;
        this.base_of_operation = base_of_operation;
        this.affiliation = affiliation;
        this.summary = summary;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBase_of_operation() {
        return base_of_operation;
    }

    public void setBase_of_operation(String base_of_operation) {
        this.base_of_operation = base_of_operation;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }
}
