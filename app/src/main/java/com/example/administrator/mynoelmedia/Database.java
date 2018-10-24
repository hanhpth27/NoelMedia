package com.example.administrator.mynoelmedia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    public final static String DB_NAME = "SongDb";
    public final static String TABLE_NAME = "SONG";
    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String PATH = "path";
    public final static String DURATION = "duration";
    public final static int VERSION_DB = 1;

    public final static String CREATE_TABLE_SONG = "CREATE TABLE " + TABLE_NAME + "( "
            + ID +" INTEGER PRIMARY KEY, "
            + NAME + " TEXT, "
            + PATH + " TEXT, "
            + DURATION + " INTEGER)";

    public Database(Context context) {
        super(context, DB_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SONG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
