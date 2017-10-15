package com.brent.school.koreanapp.Utility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Brent on 9-8-2017.
 */

public final class ListContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ListContract() {}

    /* Inner class that defines the table contents */
    public static class ListEntry implements BaseColumns {
        public static final String TABLE_NAME = "testlist";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_WORD_KOREAN = "korean";
        public static final String COLUMN_WORD_ENGLISH = "english";
    }


}


