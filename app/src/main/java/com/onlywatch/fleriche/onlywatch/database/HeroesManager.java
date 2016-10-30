package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;

import java.util.ArrayList;

/**
 * Created by florian on 28/09/16
 */

public class HeroesManager {
    private static final String TABLE_NAME = "heroes";
    private static final String KEY_ID_HEROES = "id";
    private static final String NOM_HEROES = "name";
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
    private static final String ID_ROLE_HEROES = "id_role";
    private static final String DIFFICULTY_HEROES = "difficulty";
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
        values.put(ID_ROLE_HEROES, heroes.getId_role());
        values.put(DIFFICULTY_HEROES, heroes.getDifficulty());

        return mDatabase.insert(TABLE_NAME, null, values);
    }

    public int updateHeroes(Heroes heroes) {
        ContentValues values = new ContentValues();
        values.put(NOM_HEROES, heroes.getNom());
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
        values.put(ID_ROLE_HEROES, heroes.getId_role());
        values.put(DIFFICULTY_HEROES, heroes.getDifficulty());

        String where = KEY_ID_HEROES+" = ?";
        String[] whereArgs = {heroes.getId()+""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteHeroes(Heroes heroes) {
        String where = KEY_ID_HEROES+" = ?";
        String[] whereArgs = {heroes.getId()+""};

        return mDatabase.delete(TABLE_NAME, where, whereArgs);
    }

    public Heroes getHeroe(int id) {
        Heroes heroes = new Heroes(0, "", 0);

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_HEROES+"="+id, null);
        if (cursor.moveToFirst()) {
            heroes.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES)));
            heroes.setNom(cursor.getString(cursor.getColumnIndex(NOM_HEROES)));
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
            heroes.setDifficulty(cursor.getInt(cursor.getColumnIndex(DIFFICULTY_HEROES)));
            cursor.close();
        }

        return heroes;
    }

    public ArrayList<Heroes> getHeroes() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        ArrayList<Heroes> heroesList = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Heroes heroes = new Heroes(0, "", 0);
            heroes.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES)));
            heroes.setNom(cursor.getString(cursor.getColumnIndex(NOM_HEROES)));
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
            heroes.setDifficulty(cursor.getInt(cursor.getColumnIndex(DIFFICULTY_HEROES)));
            heroesList.add(heroes);
        }

        cursor.close();
        return heroesList;
    }
}
