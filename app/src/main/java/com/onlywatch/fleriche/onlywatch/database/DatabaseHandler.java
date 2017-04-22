package com.onlywatch.fleriche.onlywatch.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Database handler.
 */
class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "onlywatch.db";

    private static final int DATABASE_VERSION = 1;

    private String mDatabasePath;

    private final Context mContext;

    private static DatabaseHandler mInstance;

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
        String filesDir = context.getFilesDir().getPath(); // /data/data/com.onlywatch.fleriche.onlywatch/files/
        mDatabasePath = filesDir.substring(0, filesDir.lastIndexOf("/")) + "/databases/"; // /data/data/com.onlywatch.fleriche.onlywatch/databases/

        // Si la db n'existe pas dans le dossier de l'app
        if (!checkDatabaseExist()) {
            // copie db de 'assets' vers mDatabasePath
            copyDatabase();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            //Log.d("debug", "onUpgrade() : oldVersion=" + oldVersion + ",newVersion=" + newVersion);
            mContext.deleteDatabase(DATABASE_NAME);
            copyDatabase();
        }
    }

    /**
     * Create an instance of database handler.
     *
     * @param context Application context.
     * @return An instance of database handler.
     */
    static synchronized DatabaseHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHandler(context);
        }
        return mInstance;
    }

    /**
     * Check if the database already exists.
     *
     * @return True if the database exist, false otherwise.
     */
    private boolean checkDatabaseExist() {
        File dbfile = new File(mDatabasePath + DATABASE_NAME);
        return dbfile.exists();
    }

    /**
     * Copy the database in the device.
     */
    private void copyDatabase() {
        final String outFileName = mDatabasePath + DATABASE_NAME;

        InputStream myInput;
        try {
            // Ouvre la bd en lecture
            myInput = mContext.getAssets().open(DATABASE_NAME);

            // Dossier de destination
            File pathFile = new File(mDatabasePath);
            if (!pathFile.exists()) {
                if (!pathFile.mkdirs()) {
                    Toast.makeText(mContext, "Erreur : copyDatabase(), pathFile.mkdirs()",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            // Ouverture en écriture du fichier db de destination
            OutputStream myOutput = new FileOutputStream(outFileName);

            // Transfert de inputfile vers outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }

            // Fermeture
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Erreur : copydatabase()", Toast.LENGTH_SHORT).show();
        }

        // on greffe le numéro de version
        try {
            SQLiteDatabase checkdb = SQLiteDatabase.openDatabase(mDatabasePath + DATABASE_NAME,
                    null, SQLiteDatabase.OPEN_READWRITE);
            checkdb.setVersion(DATABASE_VERSION);
        } catch (SQLiteException e) {
            // bdd n'existe pas
        }
    }
}
