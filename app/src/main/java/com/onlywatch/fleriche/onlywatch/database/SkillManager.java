package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Skill;

import java.util.ArrayList;

/**
 * Class allowing the connection to the database.
 * Contains all methods for managing skill table data.
 */
public class SkillManager {

    static final String TABLE_NAME = "skill";

    static final String KEY_ID_SKILL = "id";

    static final String NOM_SKILL = "name";

    static final String CANONICAL_NAME_SKILL = "canonical_name";

    static final String DESCRIPTION_SKILL = "description";

    static final String FEATURES_SKILL = "features";

    private static final String IS_FAVORITE_SKILL = "is_favorite";

    static final String KEY_ID_HEROES_SKILL = "id_heroes";

    private static final String ID_LOCALE_SKILL = "id_locale";

    private DatabaseHandler mDatabaseHandler;

    private SQLiteDatabase mDatabase;

    /**
     * Constructeur
     *
     * @param context Current context.
     */
    public SkillManager(Context context) {
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
     * Method for updating a skill in the database.
     *
     * @param skill The skill you want to update.
     * @return Number of row(s) affected.
     */
    public int updateSkill(Skill skill) {
        ContentValues values = new ContentValues();
        values.put(NOM_SKILL, skill.getNom());
        values.put(CANONICAL_NAME_SKILL, skill.getCanonical_name());
        values.put(DESCRIPTION_SKILL, skill.getDescription());
        values.put(FEATURES_SKILL, skill.getFeatures());
        values.put(IS_FAVORITE_SKILL, skill.getIs_favorite());
        values.put(KEY_ID_HEROES_SKILL, skill.getId_heroes());
        values.put(ID_LOCALE_SKILL, skill.getId_locale());

        String where = KEY_ID_SKILL + " = ? AND " + ID_LOCALE_SKILL + " = ?";
        String[] whereArgs = {skill.getId() + "", skill.getId_locale() + ""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    /**
     * Method for getting skills.
     *
     * @param cursor which contains the request.
     * @return ArrayList of @see "Skill".
     */
    private ArrayList<Skill> getSkills(Cursor cursor) {
        ArrayList<Skill> skillList = new ArrayList<>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Skill skill = new Skill();
            skill.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(NOM_SKILL)));
            skill.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(FEATURES_SKILL)));
            skill.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES_SKILL)));
            skill.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE_SKILL)));
            skillList.add(skill);
        }

        cursor.close();
        return skillList;
    }

    /**
     * Method for getting all the skills.
     *
     * @return ArrayList containing the skills requested.
     */
    public ArrayList<Skill> getSkills() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                ID_LOCALE_SKILL + "=1 ORDER BY name", null);
        return getSkills(cursor);
    }

    /**
     * Method for getting a skill by id.
     *
     * @param id The id of the skill.
     * @return The skill requested.
     */
    public Skill getSkill(int id) {
        Skill skill = new Skill();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                KEY_ID_SKILL + "=" + id + " AND " + ID_LOCALE_SKILL + "=1", null);
        if (cursor.moveToFirst()) {
            skill.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_SKILL)));
            skill.setNom(cursor.getString(cursor.getColumnIndex(NOM_SKILL)));
            skill.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_SKILL)));
            skill.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_SKILL)));
            skill.setFeatures(cursor.getString(cursor.getColumnIndex(FEATURES_SKILL)));
            skill.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_SKILL)));
            skill.setId_heroes(cursor.getInt(cursor.getColumnIndex(KEY_ID_HEROES_SKILL)));
            skill.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE_SKILL)));
            cursor.close();
        }

        return skill;
    }

    /**
     * Method for getting skill by name.
     *
     * @param name The name of the skill.
     * @return ArrayList containing the matched skills.
     */
    public ArrayList<Skill> getSkills(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                ID_LOCALE_SKILL + "=1 AND " + NOM_SKILL + " LIKE " + "'%" + name + "%'", null);
        return getSkills(cursor);
    }

    /**
     * Method for getting favorites skills by name.
     *
     * @param name The name of the skill.
     * @return ArrayList containing the matched skills.
     */
    public ArrayList<Skill> getFavoriteSkills(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                IS_FAVORITE_SKILL + "=1 AND " + ID_LOCALE_SKILL + "=1 AND " + NOM_SKILL +
                " LIKE " + "'%" + name + "%'", null);
        return getSkills(cursor);
    }

    /**
     * Method for getting all favorites skills.
     *
     * @return ArrayList containing all the favorite skills.
     */
    public ArrayList<Skill> getFavoriteSkills() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " +
                IS_FAVORITE_SKILL + "=1 AND " + ID_LOCALE_SKILL + "=1", null);
        return getSkills(cursor);
    }
}
