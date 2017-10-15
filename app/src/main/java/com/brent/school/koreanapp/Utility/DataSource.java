package com.brent.school.koreanapp.Utility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.brent.school.koreanapp.Model.Translation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brent on 12-10-2017.
 */

public class DataSource {

    private final DBHelper dbHelper;

    public DataSource(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void SaveTranslation(Translation translation) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ListContract.ListEntry.COLUMN_WORD_KOREAN, translation.getKorean());
        values.put(ListContract.ListEntry.COLUMN_WORD_ENGLISH, translation.getEnglish());

        db.insert(ListContract.ListEntry.TABLE_NAME, null, values);

    }

    public List<Translation> getTranslations() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String selectQuery = "SELECT  " +
                ListContract.ListEntry.COLUMN_WORD_KOREAN + ',' +
                ListContract.ListEntry.COLUMN_WORD_ENGLISH + " FROM " +
                ListContract.ListEntry.TABLE_NAME;

        List<Translation> translationList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        int i = cursor.getCount();
        if (cursor.moveToFirst()) {
            do {
                Translation translation = new Translation();
                translation.setKorean(cursor.getString(cursor.getColumnIndex(ListContract.ListEntry.COLUMN_WORD_KOREAN)));
                translation.setEnglish(cursor.getString(cursor.getColumnIndex(ListContract.ListEntry.COLUMN_WORD_ENGLISH)));
                translationList.add(translation);
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return translationList;
    }

    public void deleteTranslation(int user_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // It's a good practice to use parameter ?, instead of concatenate string

        db.delete(ListContract.ListEntry.TABLE_NAME, ListContract.ListEntry.COLUMN_NAME_ID

                + "= ?", new String[]{String.valueOf(user_Id)});

        db.close(); // Closing database connection

    }

    public void deleteTranslation(String word) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // It's a good practice to use parameter ?, instead of concatenate string

        db.delete(ListContract.ListEntry.TABLE_NAME, ListContract.ListEntry.COLUMN_WORD_KOREAN

                + "= ?", new String[]{String.valueOf(word)});

        db.close(); // Closing database connection

    }




}
