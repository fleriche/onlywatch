package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Map;

import java.util.ArrayList;

/**
 * Created by florian on 29/11/16
 */

public class MapManager {
    public static final String TABLE_NAME = "map";
    public static final String KEY_ID_MAP = "id";
    public static final String NOM_MAP = "name";
    public static final String CANONICAL_NAME_MAP = "canonical_name";
    public static final String LOCATION_MAP = "location";
    public static final String GAMEMODE_MAP = "gamemode";
    public static final String DESCRIPTION_MAP = "description";
    public static final String BACKGROUND_MAP = "background";
    public static final String STRATEGY_MAP = "strategy";
    public static final String EASTER_EGGS_MAP = "easter_eggs";
    public static final String IS_FAVORITE_MAP = "is_favorite";
    private DatabaseHandler mDatabaseHandler;
    private SQLiteDatabase mDatabase;

    public MapManager(Context context) {
        mDatabaseHandler = DatabaseHandler.getInstance(context);
    }

    public void open() {
        mDatabase = mDatabaseHandler.getWritableDatabase();
    }

    public void close() {
        mDatabase.close();
    }

    public int updateMap(Map map) {
        ContentValues values = new ContentValues();
        values.put(NOM_MAP, map.getNom());
        values.put(CANONICAL_NAME_MAP, map.getCanonical_name());
        values.put(LOCATION_MAP, map.getLocation());
        values.put(GAMEMODE_MAP, map.getGamemode());
        values.put(DESCRIPTION_MAP, map.getDescription());
        values.put(BACKGROUND_MAP, map.getBackground());
        values.put(STRATEGY_MAP, map.getStrategy());
        values.put(EASTER_EGGS_MAP, map.getEaster_eggs());
        values.put(IS_FAVORITE_MAP, map.getIs_favorite());

        String where = KEY_ID_MAP+" = ?";
        String[] whereArgs = {map.getId()+""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    public Map getMap(int id) {
        Map map = new Map();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_MAP+"="+id, null);
        if (cursor.moveToFirst()) {
            map.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_MAP)));
            map.setNom(cursor.getString(cursor.getColumnIndex(NOM_MAP)));
            map.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_MAP)));
            map.setLocation(cursor.getString(cursor.getColumnIndex(LOCATION_MAP)));
            map.setGamemode(cursor.getString(cursor.getColumnIndex(GAMEMODE_MAP)));
            map.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_MAP)));
            map.setBackground(cursor.getString(cursor.getColumnIndex(BACKGROUND_MAP)));
            map.setStrategy(cursor.getString(cursor.getColumnIndex(STRATEGY_MAP)));
            map.setEaster_eggs(cursor.getString(cursor.getColumnIndex(EASTER_EGGS_MAP)));
            map.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_MAP)));
        }
        cursor.close();

        return map;
    }

    private ArrayList<Map> getMaps(Cursor cursor) {
        ArrayList<Map> mapList = new ArrayList<>();

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Map map = new Map();
            map.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_MAP)));
            map.setNom(cursor.getString(cursor.getColumnIndex(NOM_MAP)));
            map.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_MAP)));
            map.setLocation(cursor.getString(cursor.getColumnIndex(LOCATION_MAP)));
            map.setGamemode(cursor.getString(cursor.getColumnIndex(GAMEMODE_MAP)));
            map.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_MAP)));
            map.setBackground(cursor.getString(cursor.getColumnIndex(BACKGROUND_MAP)));
            map.setStrategy(cursor.getString(cursor.getColumnIndex(STRATEGY_MAP)));
            map.setEaster_eggs(cursor.getString(cursor.getColumnIndex(EASTER_EGGS_MAP)));
            map.setIs_favorite(cursor.getInt(cursor.getColumnIndex(IS_FAVORITE_MAP)));
            mapList.add(map);
        }

        return mapList;
    }

    public ArrayList<Map> getMaps() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " ORDER BY name", null);
        return getMaps(cursor);
    }
}
