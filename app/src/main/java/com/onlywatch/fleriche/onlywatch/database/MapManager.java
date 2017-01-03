package com.onlywatch.fleriche.onlywatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
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
    public static final String ID_LOCALE_MAP = "id_locale";
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
        values.put(ID_LOCALE_MAP, map.getId_locale());

        String where = KEY_ID_MAP+" = ? AND "+ID_LOCALE_MAP+" = ?";
        String[] whereArgs = {map.getId()+"", map.getId_locale()+""};

        return mDatabase.update(TABLE_NAME, values, where, whereArgs);
    }

    public Map getMap(int id) {
        Map map = new Map();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_MAP+"="+id+" AND "+ID_LOCALE_MAP+"=1", null);
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
            map.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE_MAP)));
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
            map.setId_locale(cursor.getInt(cursor.getColumnIndex(ID_LOCALE_MAP)));
            mapList.add(map);
        }

        return mapList;
    }

    public ArrayList<Map> getMaps() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+ID_LOCALE_MAP+"=1 ORDER BY name", null);
        return getMaps(cursor);
    }

    public ArrayList<Map> getMap(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+ID_LOCALE_MAP+"=1 AND (name LIKE '%"+name+"%' OR canonical_name LIKE '%"+name+"%')", null);
        return getMaps(cursor);
    }

    public ArrayList<Map> getFavoriteMap(String name) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+IS_FAVORITE_MAP+"=1 AND "+ID_LOCALE_MAP+"=1 AND (name LIKE '%"+name+"%' OR canonical_name LIKE '%"+name+"%')", null);
        return getMaps(cursor);
    }

    public ArrayList<Map> getFavoriteMaps() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " WHERE "+IS_FAVORITE_MAP+"=1 AND "+ID_LOCALE_MAP+"=1 ORDER BY name", null);
        return getMaps(cursor);
    }

    public ArrayList<Map> getMapsByGamemode(boolean assault, boolean control, boolean escort, boolean hybrid, boolean onlyFavorite) {
        String gamemode = "";
        String query;
        if (assault)
            gamemode += "gamemode = 'Assault' OR ";
        if (control)
            gamemode += "gamemode = 'Control' OR ";
        if (escort)
            gamemode += "gamemode = 'Escort' OR ";
        if (hybrid)
            gamemode += "gamemode = 'Hybrid' OR ";
        if(gamemode.length() != 0) {
            gamemode = gamemode.substring(0, gamemode.length()-4);
            gamemode = " WHERE ( "+gamemode+" )";
        }

        query = "SELECT * FROM "+TABLE_NAME+gamemode;
        if(onlyFavorite) {
            if(gamemode.length() != 0)
                query += " AND "+IS_FAVORITE_MAP+"=1";
            else
                query += " WHERE "+IS_FAVORITE_MAP+"=1";
        }
        query += " AND "+ID_LOCALE_MAP+"=1 ORDER BY name";
        Cursor cursor = mDatabase.rawQuery(query, null);
        return getMaps(cursor);
    }
}
