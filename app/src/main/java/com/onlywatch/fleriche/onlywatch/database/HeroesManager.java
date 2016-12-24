package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.entity.Skill;

import java.util.ArrayList;

/**
 * Created by florian on 28/09/16
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
    private DatabaseHandler mDatabaseHandler;
    private SQLiteDatabase mDatabase;

    public HeroesManager(Context context) {
        mDatabaseHandler = DatabaseHandler.getInstance(context);
    }

    public void open() {
        mDatabase = mDatabaseHandler.getWritableDatabase();
    }

    public void close() {
        mDatabase.close();
    }

    public long addHeroes(Heroes heroes) {
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

        return mDatabase.insert(TABLE_NAME, null, values);
    }

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

        String where = KEY_ID_HEROES+" = ?";
        String[] whereArgs = {heroes.getId()+""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteHeroes(Heroes heroes) {
        String where = KEY_ID_HEROES+" = ?";
        String[] whereArgs = {heroes.getId()+""};

        return mDatabase.delete(TABLE_NAME, where, whereArgs);
    }

    public Heroes getHero(int id) {
        Heroes heroes = new Heroes(0, "", 0);

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_HEROES+"="+id, null);
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
            cursor.close();
        }

        return heroes;
    }

    private ArrayList<Heroes> getHeroes(Cursor cursor) {
        ArrayList<Heroes> heroesList = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
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
            heroesList.add(heroes);
        }

        cursor.close();
        return heroesList;
    }

    public ArrayList<Heroes> getHeroes() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " ORDER BY name", null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getFavoriteHeroes() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+IS_FAVORITE_HEROES+"=1 ORDER BY name", null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getHeroes(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE name LIKE '%"+name+"%' OR canonical_name LIKE '%"+name+"%'", null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getFavoriteHeroes(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+IS_FAVORITE_HEROES+"=1 AND (name LIKE '%"+name+"%' OR canonical_name LIKE '%"+name+"%')", null);
        return getHeroes(cursor);
    }

    public ArrayList<Skill> getHeroSkills(int id_heroes) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+SkillManager.TABLE_NAME+ " WHERE "+SkillManager.KEY_ID_HEROES_SKILL+" = "+id_heroes, null);
        ArrayList<Skill> skillsList = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Skill skill = new Skill();
            skill.setId(cursor.getInt(cursor.getColumnIndex(SkillManager.KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(SkillManager.NOM_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(SkillManager.DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(SkillManager.FEATURES_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(SkillManager.KEY_ID_HEROES_SKILL)));
            skillsList.add(skill);
        }

        return skillsList;
    }

    public ArrayList<Heroes> getHeroesByDifficulty(int difficulty) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE difficulty = "+difficulty+" ORDER BY name", null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getHeroesByDifficultyAndRoles(int difficulty, boolean offense, boolean tank, boolean defense, boolean support, boolean onlyFavorite) {
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
        if(role.length() != 0) {
            role = role.substring(0, role.length()-4);
            role = " AND ( "+role+" )";
        }

        query = "SELECT * FROM "+TABLE_NAME+" WHERE difficulty = "+difficulty+role;
        if(onlyFavorite)
            query += " AND "+IS_FAVORITE_HEROES+"=1 ";
        query += " ORDER BY name";
        Cursor cursor = mDatabase.rawQuery(query, null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getHeroesByDifficultyAndRoles(int difficulty, boolean offense, boolean tank, boolean defense, boolean support) {
        return getHeroesByDifficultyAndRoles(difficulty, offense, tank, defense, support, false);
    }

    public ArrayList<Heroes> getHeroesByRoles(boolean offense, boolean tank, boolean defense, boolean support, boolean onlyFavorite) {
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
        if(role.length() != 0) {
            role = role.substring(0, role.length()-4);
            role = " WHERE "+role;
        }

        query = "SELECT * FROM "+TABLE_NAME+role;
        if(onlyFavorite)
            query += " AND "+IS_FAVORITE_HEROES+"=1 ";
        query += " ORDER BY name";
        Cursor cursor = mDatabase.rawQuery(query, null);
        return getHeroes(cursor);
    }

    public ArrayList<Heroes> getHeroesByRoles(boolean offense, boolean tank, boolean defense, boolean support) {
        return getHeroesByRoles(offense, tank, defense, support, false);
    }
}
