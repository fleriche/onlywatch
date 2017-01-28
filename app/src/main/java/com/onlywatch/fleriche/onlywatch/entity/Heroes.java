package com.onlywatch.fleriche.onlywatch.entity;
//-encoding UTF-8 -docencoding utf-8 -charset utf-8 -bootclasspath /home/florian/Android/Sdk/platforms/android-23/android.jar

/**
 * This entity represent a hero and will be persisted into the corresponding 'heroes' table in database.
 * It is simple POJO containing get/set methods to store data retrieved using DAO class.
 */
public class Heroes {
    private int id;
    private String nom;
    private String canonical_name;
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
    private String role;
    private int difficulty;
    private int is_favorite;
    private int id_locale;

    /**
     * Empty constructor.
     */
    public Heroes() {}

    /**
     * Constructor.
     * @param id The hero's id.
     * @param nom The hero's name.
     * @param difficulty The hero's difficulty.
     */
    public Heroes(int id, String nom, int difficulty) {
        this.id = id;
        this.nom = nom;
        this.difficulty = difficulty;
    }

    /**
     * Constructor.
     * @param nom The hero's name.
     * @param canonical_name The hero's canonical name.
     * @param id The hero's id.
     * @param health The hero's health.
     * @param difficulty The hero's difficulty.
     * @param role The hero's role.
     * @param quote The hero's quote.
     * @param armor The hero's armor.
     * @param shield The hero's shield.
     * @param real_name The hero's real name.
     * @param age The hero's age.
     * @param nationality The hero's nationality.
     * @param occupation The hero's occupation.
     * @param base_of_operation The hero's base of operation.
     * @param affiliation The hero's affiliation.
     * @param summary The hero's summary.
     */
    public Heroes(String nom, String canonical_name, int id, int health, int difficulty, String role, String quote, int armor, int shield, String real_name, String age, String nationality, String occupation, String base_of_operation, String affiliation, String summary) {
        this.nom = nom;
        this.canonical_name = canonical_name;
        this.id = id;
        this.health = health;
        this.difficulty = difficulty;
        this.role = role;
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

    /**
     * Get the hero's id.
     * @return The hero's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set The hero's id.
     * @param id The hero's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the hero.
     * @return The name of the hero.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the name of the hero.
     * @param nom The name of the hero.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the Blizzard's difficulty rating for the hero.
     * @return The Blizzard's difficulty rating for the hero.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Set the Blizzard's difficulty rating for the hero.
     * @param difficulty The Blizzard's difficulty rating for the hero.
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Get the hero's health.
     * @return The hero's health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set the hero's health.
     * @param health The hero's health.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Get the hero's armor.
     * @return The hero's armor.
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Set the hero's armor.
     * @param armor The hero's armor.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Get the hero's shield.
     * @return The hero's shield.
     */
    public int getShield() {
        return shield;
    }

    /**
     * Set the hero's shield.
     * @param shield The hero's shield.
     */
    public void setShield(int shield) {
        this.shield = shield;
    }

    /**
     * Get the hero's real name.
     * @return The hero's real name.
     */
    public String getReal_name() {
        return real_name;
    }

    /**
     * Set the hero's real name.
     * @param real_name The hero's real name.
     */
    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    /**
     * Get the hero's age.
     * @return The hero's age.
     */
    public String getAge() {
        return age;
    }

    /**
     * Set the hero's age.
     * @param age The hero's age.
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Get the hero's nationality.
     * @return The hero's nationality.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Set the hero's nationality.
     * @param nationality The hero's nationality.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Get the hero's occupation.
     * @return The hero's occupation.
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Set the hero's occupation.
     * @param occupation The hero's occupation.
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Get the hero's base of operation.
     * @return The hero's base of operation.
     */
    public String getBase_of_operation() {
        return base_of_operation;
    }

    /**
     * Set the hero's base of operation.
     * @param base_of_operation The hero's base of operation.
     */
    public void setBase_of_operation(String base_of_operation) {
        this.base_of_operation = base_of_operation;
    }

    /**
     * Get the hero's affiliation.
     * @return The hero's affiliation.
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * Set the hero's affiliation.
     * @param affiliation The hero's affiliation.
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * Get the hero's summary.
     * @return The hero's summary.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Set the hero's summary.
     * @param summary The hero's summary.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Get the hero's quote.
     * @return The hero's quote.
     */
    public String getQuote() {
        return quote;
    }

    /**
     * Set the hero's quote.
     * @param quote The hero's quote.
     */
    public void setQuote(String quote) {
        this.quote = quote;
    }

    /**
     * Get the hero's role.
     * @return The hero's role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the hero's role.
     * @param role The hero's role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Get the hero's canonical name.
     * @return The hero's canonical name.
     */
    public String getCanonical_name() {
        return canonical_name;
    }

    /**
     * Set the hero's canonical name.
     * @param canonical_name The hero's canonical name.
     */
    public void setCanonical_name(String canonical_name) {
        this.canonical_name = canonical_name;
    }

    /**
     * Get if the hero is in the favorite list.
     * @return 1 if the hero is in the fovorite list, otherwise 0.
     */
    public int getIs_favorite() {
        return is_favorite;
    }

    /**
     * Set if the hero is in the favorite list.
     * @param is_favorite 1 if the hero is in the favorite list, otherwise 0.
     */
    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    /**
     * Get if the hero is in the favorite list.
     * @return True if the hero is in the fovorite list, otherwise false.
     */
    public boolean isFavorite() {
        return getIs_favorite() == 1;
    }

    /**
     * Get the id of the hero's locale.
     * @return The id of the hero's locale.
     */
    public int getId_locale() {
        return id_locale;
    }

    /**
     * Set the id of the hero's locale.
     * @param id_locale The id of the hero's locale.
     */
    public void setId_locale(int id_locale) {
        this.id_locale = id_locale;
    }
}
