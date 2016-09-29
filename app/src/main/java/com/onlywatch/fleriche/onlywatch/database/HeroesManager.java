package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.Entity.Heroes;

/**
 * Created by florian on 28/09/16
 */

public class HeroesManager {
    private static final String TABLE_NAME = "heroes";
    public static final String KEY_ID_HEROES = "id";
    public static final String NOM_HEROES = "nom";
    public static final String DIFFICULTY_HEROES = "difficulty";
    public static final String CREATE_TABLE_HEROES = "CREATE TABLE "+TABLE_NAME+
            " (" +
            " "+KEY_ID_HEROES+" INTEGER primary key," +
            " "+NOM_HEROES+" TEXT," +
            " "+DIFFICULTY_HEROES+" INTEGER" +
            ");";
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
        values.put(DIFFICULTY_HEROES, heroes.getDifficulty());

        return mDatabase.insert(TABLE_NAME, null, values);
    }

    public int updateHeroes(Heroes heroes) {
        ContentValues values = new ContentValues();
        values.put(NOM_HEROES, heroes.getNom());
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
            heroes.setDifficulty(cursor.getInt(cursor.getColumnIndex(DIFFICULTY_HEROES)));
            cursor.close();
        }

        return heroes;
    }

    public Cursor getHeroes() {
        return mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }
}
