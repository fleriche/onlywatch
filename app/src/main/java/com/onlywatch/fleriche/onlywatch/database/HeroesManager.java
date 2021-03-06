package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.entity.Skill;

import java.util.ArrayList;

/**
 * Class allowing the connection to the database.
 * Contains all methods for managing heroes table data.
 */
public class HeroesManager {

    private static final String TABLE_NAME = "heroes";

    private static final String KEY_ID_HEROES = "id";

    private static final String NOM_HEROES = "name";

    private static final String CANONICAL_NAME_HEROES = "canonical_name";

    private static final String HEALTH_HEROES = "health";

    private static final String ARMOR_HEROES = "armor";

    private static final String SHIELD_HEROES = "shield";

    private static final String REAL_NAME_HEROES = "real_name";

    private static final String AGE_HEROES = "age";

    private static final String NATIONALITY_HEROES = "nationality";

    private static final String OCCUPATION_HEROES = "occupation";

    private static final String BASE_OF_OPERATION_HEROES = "base_of_operation";

    private static final String AFFILIATION_HEROES = "affiliation";

    private static final String SUMMARY_HEROES = "summary";

    private static final String QUOTE_HEROES = "quote";

    private static final String ROLE_HEROES = "role";

    private static final String DIFFICULTY_HEROES = "difficulty";

    private static final String IS_FAVORITE_HEROES = "is_favorite";

    private static final String ID_LOCALE = "id_locale";

    private DatabaseHandler mDatabaseHandler;

    private SQLiteDatabase mDatabase;

    /**
     * Constructeur
     *
     * @param context Current context.
     */
    public HeroesManager(Context context) {
        mDatabaseHandler = DatabaseHandler.getInstance(context);
    }

    /**
     * Create and/or open a database that will be used for reading and writing.
     */
    public void open() {
        mDatabase = mDatabaseHandler.getWritableDatabase();
    }

    /**
     * Close any open database object.
     */
    public void close() {
        mDatabase.close();
    }

    /**
     * Method for updating an hero in the database.
     *
     * @param heroes The hero you want to update.
     * @return Number of row(s) affected.
     */
    public int updateHeroes(Heroes heroes) {
        ContentValues values = new ContentValues();
        values.put(NOM_HEROES, heroes.getNom());
        values.put(CANONICAL_NAME_HEROES, heroes.getCanonical_name());
        values.put(HEALTH_HEROES, heroes.getHealth());
        values.put(ARMOR_HEROES, heroes.getArmor());
        values.put(SHIELD_HEROES, heroes.getShield());
        values.put(REAL_NAME_HEROES, heroes.getReal_name());
        values.put(AGE_HEROES, heroes.getAge());
        values.put(NATIONALITY_HEROES, heroes.getNationality());
        values.put(OCCUPATION_HEROES, heroes.getOccupation());
        values.put(BASE_OF_OPERATION_HEROES, heroes.getBase_of_operation());
        values.put(AFFILIATION_HEROES, heroes.getAffiliation());
        values.put(SUMMARY_HEROES, heroes.getSummary());
        values.put(QUOTE_HEROES, heroes.getQuote());
        values.put(ROLE_HEROES, heroes.getRole());
        values.put(DIFFICULTY_HEROES, heroes.getDifficulty());
        values.put(IS_FAVORITE_HEROES, heroes.getIs_favorite());
        values.put(ID_LOCALE, heroes.getId_locale());

        String where = KEY_ID_HEROES + " = ? AND " + ID_LOCALE + " = ?";
        String[] whereArgs = {heroes.getId() + "", heroes.getId_locale() + ""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    /**
     * Method for getting an hero by id.
     *
     * @param id The id of the hero.
     * @return The hero requested.
     */
    public Heroes getHero(int id) {
        Heroes heroes = new Heroes(0, "", 0);

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID_HEROES
                + "=" + id + " AND " + ID_LOCALE + "=1", null);
        if (cursor.moveToFirst()) {
            heroes.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES)));
            heroes.setNom(cursor.getString(cursor.getColumnIndex(NOM_HEROES)));
            heroes.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_HEROES)));
            heroes.setHealth(cursor.getInt(cursor.getColumnIndex(HEALTH_HEROES)));
            heroes.setArmor(cursor.getInt(cursor.getColumnIndex(ARMOR_HEROES)));
            heroes.setShield(cursor.getInt(cursor.getColumnIndex(SHIELD_HEROES)));
            heroes.setReal_name(cursor.getString(cursor.getColumnIndex(REAL_NAME_HEROES)));
            heroes.setAge(cursor.getString(cursor.getColumnIndex(AGE_HEROES)));
            heroes.setNationality(cursor.getString(cursor.getColumnIndex(NATIONALITY_HEROES)));
            heroes.setOccupation(cursor.getString(cursor.getColumnIndex(OCCUPATION_HEROES)));
            heroes.setBase_of_operation(cursor.getString(cursor.getColumnIndex(BASE_OF_OPERATION_HEROES)));
            heroes.setAffiliation(cursor.getString(cursor.getColumnIndex(AFFILIATION_HEROES)));
            heroes.setSummary(cursor.getString(cursor.getColumnIndex(SUMMARY_HEROES)));
            heroes.setQuote(cursor.getString(cursor.getColumnIndex(QUOTE_HEROES)));
            heroes.setRole(cursor.getString(cursor.getColumnIndex(ROLE_HEROES)));
            heroes.setDifficulty(cursor.getInt(cursor.getColumnIndex(DIFFICULTY_HEROES)));
            heroes.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_HEROES)));
            heroes.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE)));
            cursor.close();
        }

        return heroes;
    }

    /**
     * Method for getting maps.
     *
     * @param cursor which contains the request.
     * @return ArrayList of @see "Heroes".
     */
    private ArrayList<Heroes> getHeroes(Cursor cursor) {
        ArrayList<Heroes> heroesList = new ArrayList<>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Heroes heroes = new Heroes(0, "", 0);
            heroes.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES)));
            heroes.setNom(cursor.getString(cursor.getColumnIndex(NOM_HEROES)));
            heroes.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_HEROES)));
            heroes.setHealth(cursor.getInt(cursor.getColumnIndex(HEALTH_HEROES)));
            heroes.setArmor(cursor.getInt(cursor.getColumnIndex(ARMOR_HEROES)));
            heroes.setShield(cursor.getInt(cursor.getColumnIndex(SHIELD_HEROES)));
            heroes.setReal_name(cursor.getString(cursor.getColumnIndex(REAL_NAME_HEROES)));
            heroes.setAge(cursor.getString(cursor.getColumnIndex(AGE_HEROES)));
            heroes.setNationality(cursor.getString(cursor.getColumnIndex(NATIONALITY_HEROES)));
            heroes.setOccupation(cursor.getString(cursor.getColumnIndex(OCCUPATION_HEROES)));
            heroes.setBase_of_operation(cursor.getString(cursor.getColumnIndex(BASE_OF_OPERATION_HEROES)));
            heroes.setAffiliation(cursor.getString(cursor.getColumnIndex(AFFILIATION_HEROES)));
            heroes.setSummary(cursor.getString(cursor.getColumnIndex(SUMMARY_HEROES)));
            heroes.setQuote(cursor.getString(cursor.getColumnIndex(QUOTE_HEROES)));
            heroes.setRole(cursor.getString(cursor.getColumnIndex(ROLE_HEROES)));
            heroes.setDifficulty(cursor.getInt(cursor.getColumnIndex(DIFFICULTY_HEROES)));
            heroes.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_HEROES)));
            heroes.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE)));
            heroesList.add(heroes);
        }

        cursor.close();
        return heroesList;
    }

    /**
     * Method for getting all the heroes.
     *
     * @return ArrayList containing the heroes requested.
     */
    public ArrayList<Heroes> getHeroes() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                ID_LOCALE + "=1 ORDER BY name", null);
        return getHeroes(cursor);
    }

    /**
     * Method for getting all the favorites heroes.
     *
     * @return ArrayList containing the heroes requested.
     */
    public ArrayList<Heroes> getFavoriteHeroes() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                IS_FAVORITE_HEROES + "=1" + " AND " + ID_LOCALE + "=1 ORDER BY name", null);
        return getHeroes(cursor);
    }

    /**
     * Method for getting an hero by name.
     *
     * @param name The name of the hero.
     * @return ArrayList containing the heroes requested.
     */
    public ArrayList<Heroes> getHeroes(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + ID_LOCALE +
                "=1 AND (name LIKE '%" + name + "%' OR canonical_name LIKE '%" + name + "%')", null);
        return getHeroes(cursor);
    }

    /**
     * Method for getting a favorite hero by name.
     *
     * @param name The name of the favorite hero.
     * @return ArrayList containing the favorite heroes requested.
     */
    public ArrayList<Heroes> getFavoriteHeroes(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                IS_FAVORITE_HEROES + "=1 AND " + ID_LOCALE + "=1 AND (name LIKE '%" + name +
                "%' OR canonical_name LIKE '%" + name + "%')", null);
        return getHeroes(cursor);
    }

    /**
     * Method for getting hero's skills.
     *
     * @param id The id of the hero.
     * @return ArrayList containing the hero's skills requested.
     */
    public ArrayList<Skill> getHeroSkills(int id) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + SkillManager.TABLE_NAME + " WHERE " +
                SkillManager.KEY_ID_HEROES_SKILL + " = " + id + " AND " + ID_LOCALE + "=1", null);
        ArrayList<Skill> skillsList = new ArrayList<>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Skill skill = new Skill();
            skill.setId(cursor.getInt(cursor.getColumnIndex(SkillManager.KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(SkillManager.NOM_SKILL)));
            skill.setCanonical_name(cursor.getString(cursor.getColumnIndex(SkillManager.CANONICAL_NAME_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(SkillManager.DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(SkillManager.FEATURES_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(SkillManager.KEY_ID_HEROES_SKILL)));
            skillsList.add(skill);
        }

        cursor.close();
        return skillsList;
    }

    /**
     * Get hero by difficulty and role.
     *
     * @param difficulty   Difficulty (1, 2 ou 3).
     * @param offense      Look for offense heroes.
     * @param tank         Look for tank heroes.
     * @param defense      Look for defense heroes.
     * @param support      Look for support heroes.
     * @param onlyFavorite Only favorites heroes.
     * @return An heroes list.
     */
    public ArrayList<Heroes> getHeroesByDifficultyAndRoles(int difficulty, boolean offense,
                                                           boolean tank, boolean defense,
                                                           boolean support, boolean onlyFavorite) {
        String role = "";
        String query;
        if (offense)
            role += "role = 'offense' OR ";
        if (tank)
            role += "role = 'tank' OR ";
        if (defense)
            role += "role = 'defense' OR ";
        if (support)
            role += "role = 'support' OR ";
        if (role.length() != 0) {
            role = role.substring(0, role.length() - 4);
            role = " AND ( " + role + " )";
        }

        query = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_LOCALE + "=1 AND difficulty = " +
                difficulty + role;
        if (onlyFavorite)
            query += " AND " + IS_FAVORITE_HEROES + "=1 ";
        query += " ORDER BY name";
        Cursor cursor = mDatabase.rawQuery(query, null);
        return getHeroes(cursor);
    }

    /**
     * Get hero by role.
     *
     * @param offense      Look for offense heroes.
     * @param tank         Look for tank heroes.
     * @param defense      Look for defense heroes.
     * @param support      Look for support heroes.
     * @param onlyFavorite Only favorites heroes.
     * @return An heroes list.
     */
    public ArrayList<Heroes> getHeroesByRoles(boolean offense, boolean tank, boolean defense,
                                              boolean support, boolean onlyFavorite) {
        String role = "";
        String query;
        if (offense)
            role += "role = 'offense' OR ";
        if (tank)
            role += "role = 'tank' OR ";
        if (defense)
            role += "role = 'defense' OR ";
        if (support)
            role += "role = 'support' OR ";
        if (role.length() != 0) {
            role = role.substring(0, role.length() - 4);
            role = " WHERE " + role;
        }

        query = "SELECT * FROM " + TABLE_NAME + role;
        query += " AND " + ID_LOCALE + "=1 ";
        if (onlyFavorite)
            query += " AND " + IS_FAVORITE_HEROES + "=1 ";
        query += " ORDER BY name";
        Cursor cursor = mDatabase.rawQuery(query, null);
        return getHeroes(cursor);
    }
}
