package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Skill;

import java.util.ArrayList;

/**
 * Created by florian on 08/11/16
 */

public class SkillManager {
    public static final String TABLE_NAME = "skill";
    public static final String KEY_ID_SKILL = "id";
    public static final String NOM_SKILL = "name";
    public static final String CANONICAL_NAME_SKILL = "canonical_name";
    public static final String DESCRIPTION_SKILL = "description";
    public static final String FEATURES_SKILL = "features";
    public static final String KEY_ID_HEROES_SKILL = "id_heroes";
    private DatabaseHandler mDatabaseHandler;
    private SQLiteDatabase mDatabase;

    public SkillManager(Context context) {
        mDatabaseHandler = DatabaseHandler.getInstance(context);
    }

    public void open() {
        mDatabase = mDatabaseHandler.getWritableDatabase();
    }

    public void close() {
        mDatabase.close();
    }

    public long addSkill(Skill skill) {
        ContentValues values = new ContentValues();
        values.put(NOM_SKILL, skill.getNom());
        values.put(CANONICAL_NAME_SKILL, skill.getCanonical_name());
        values.put(DESCRIPTION_SKILL, skill.getDescription());
        values.put(FEATURES_SKILL, skill.getFeatures());
        values.put(KEY_ID_HEROES_SKILL, skill.getId_heroes());

        return mDatabase.insert(TABLE_NAME, null, values);
    }

    public int updateSkill(Skill skill) {
        ContentValues values = new ContentValues();
        values.put(NOM_SKILL, skill.getNom());
        values.put(CANONICAL_NAME_SKILL, skill.getCanonical_name());
        values.put(DESCRIPTION_SKILL, skill.getDescription());
        values.put(FEATURES_SKILL, skill.getFeatures());
        values.put(KEY_ID_HEROES_SKILL, skill.getId_heroes());

        String where = KEY_ID_SKILL+" = ?";
        String[] whereArgs = {skill.getId()+""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    public int deleteSkill(Skill skill) {
        String where = KEY_ID_SKILL+" = ?";
        String[] whereArgs = {skill.getId()+""};

        return mDatabase.delete(TABLE_NAME, where, whereArgs);
    }

    private ArrayList<Skill> getSkills(Cursor cursor) {
        ArrayList<Skill> skillList = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Skill skill = new Skill();
            skill.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(NOM_SKILL)));
            skill.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(FEATURES_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES_SKILL)));
            skillList.add(skill);
        }

        cursor.close();
        return skillList;
    }

    public ArrayList<Skill> getSkills() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " ORDER BY name", null);
        return getSkills(cursor);
    }

    public Skill getSkill(int id) {
        Skill skill = new Skill();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_SKILL+"="+id, null);
        if (cursor.moveToFirst()) {
            skill.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(NOM_SKILL)));
            skill.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(FEATURES_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES_SKILL)));
            cursor.close();
        }

        return skill;
    }
}
