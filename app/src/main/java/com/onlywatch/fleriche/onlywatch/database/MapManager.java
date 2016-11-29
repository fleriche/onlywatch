package com.onlywatch.fleriche.onlywatch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.onlywatch.fleriche.onlywatch.entity.Heroes;
import com.onlywatch.fleriche.onlywatch.entity.Map;

import java.util.ArrayList;

import static com.onlywatch.fleriche.onlywatch.R.drawable.cursor;

/**
 * Created by florian on 29/11/16
 */

public class MapManager {
    public static final String TABLE_NAME = "map";
    public static final String KEY_ID_MAP = "id";
    public static final String NOM_MAP = "name";
    public static final String CANONICAL_NAME_MAP = "canonical_name";
    public static final String LOCATION_MAP = "location";
    public static final String SUMMARY_MAP = "summary";
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

    public Map getMap(int id) {
        Map map = new Map();

        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_MAP+"="+id, null);
        if (cursor.moveToFirst()) {
            map.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_MAP)));
            map.setNom(cursor.getString(cursor.getColumnIndex(NOM_MAP)));
            map.setCanonical_name(cursor.getString(cursor.getColumnIndex(CANONICAL_NAME_MAP)));
            map.setLocation(cursor.getString(cursor.getColumnIndex(LOCATION_MAP)));
            map.setSummary(cursor.getString(cursor.getColumnIndex(SUMMARY_MAP)));
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
            map.setSummary(cursor.getString(cursor.getColumnIndex(SUMMARY_MAP)));
            mapList.add(map);
        }

        return mapList;
    }

    public ArrayList<Map> getMaps() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM "+TABLE_NAME+ " ORDER BY name", null);
        return getMaps(cursor);
    }
}
