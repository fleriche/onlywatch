package com.onlywatch.fleriche.onlywatch.entity;

/**
 * This entity represent a map and will be persisted into the corresponding 'map' table in database.
 * It is simple POJO containing get/set methods to store data retrieved using DAO class.
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

    /**
     * Empty constructor.
     */
    public Map(){}

    /**
     * Get the map's id.
     * @return The map's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the map's id.
     * @param id The map's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the map's name
     * @return the map's name.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the map's name.
     * @param nom The map's name.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the map's lacation.
     * @return The map's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the map's location.
     * @param location The map's location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the map's canonical name.
     * @return The map's canonical name.
     */
    public String getCanonical_name() {
        return canonical_name;
    }

    /**
     * Set the map's canonical name.
     * @param canonical_name The map's canonical name.
     */
    public void setCanonical_name(String canonical_name) {
        this.canonical_name = canonical_name;
    }

    /**
     * Get the map's gamemode.
     * @return The map's gamemode.
     */
    public String getGamemode() {
        return gamemode;
    }

    /**
     * Set the map's gamemode.
     * @param gamemode The map's gamemode.
     */
    public void setGamemode(String gamemode) {
        this.gamemode = gamemode;
    }

    /**
     * Get the map's description.
     * @return The map's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the map's description.
     * @param description The map's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the map's background.
     * @return The map's background.
     */
    public String getBackground() {
        return background;
    }

    /**
     * Set the map's background.
     * @param background The map's background.
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Get the strategy associated with the map.
     * @return The strategy associated with the map.
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * Set the strategy associated with the map.
     * @param strategy The strategy associated with the map.
     */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    /**
     * Get the map's easter eggs.
     * @return The map's easter eggs.
     */
    public String getEaster_eggs() {
        return easter_eggs;
    }

    /**
     * Set the map's easter eggs.
     * @param easter_eggs The map's easter eggs.
     */
    public void setEaster_eggs(String easter_eggs) {
        this.easter_eggs = easter_eggs;
    }

    /**
     * Get if the map is in the favorite list.
     * @return 1 if the map is in the favorite list, otherwise 0.
     */
    public Integer getIs_favorite() {
        return is_favorite;
    }

    /**
     * Set if the map is in the favorite list.
     * @param is_favorite 1 if the map is in the favorite list, otherwise 0.
     */
    public void setIs_favorite(Integer is_favorite) {
        this.is_favorite = is_favorite;
    }

    /**
     * Get if the map is in the favorite list.
     * @return True if the map is in the favorite list, otherwise false.
     */
    public boolean isFavorite() {
        return getIs_favorite() == 1;
    }

    /**
     * Get the id of the locale.
     * @return The id of the locale.
     */
    public Integer getId_locale() {
        return id_locale;
    }

    /**
     * Set the id of the locale.
     * @param id_locale The id of the locale.
     */
    public void setId_locale(Integer id_locale) {
        this.id_locale = id_locale;
    }
}
