package com.brent.school.koreanapp.Utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Brent on 12-10-2017.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ListContract.ListEntry.TABLE_NAME + " (" +
                    ListContract.ListEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    ListContract.ListEntry.COLUMN_WORD_KOREAN + " TEXT," +
                    ListContract.ListEntry.COLUMN_WORD_ENGLISH + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ListContract.ListEntry.TABLE_NAME;
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ListContract.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ListContract.ListEntry.TABLE_NAME);

        // Create tables again

        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
