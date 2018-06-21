package com.auburnuniversity.www.educationalApp;

/**
 * Created by Sonali on 9/13/2017.
 */

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "educationalApp.db";
    // Contacts table name
    private static final String TABLE_NAME = "Rational";

    // Shops Table Columns names
    private static final String ID = "R_id";
    private static final String NUMERATOR = "numerator";
    private static final String DENOMINATOR = "denominator";
    private static final String ANSWER = "answer";
    SQLiteDatabase mySQLiteDatabase;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RATIONAL_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NUMERATOR + " TEXT,"
                + DENOMINATOR + " TEXT," + ANSWER + " TEXT" + ")";
        db.execSQL(CREATE_RATIONAL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

// Creating table again
        onCreate(db);
    }

    public void insertRational(String numerator, String denominator, String answer) {
        mySQLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //Inserting the values in the columns Question and Answer
        values.put(NUMERATOR, numerator);
        values.put(DENOMINATOR, denominator);
        values.put(ANSWER, answer);

        //The single row is inserted in the database
        mySQLiteDatabase.insert(TABLE_NAME, null, values);

        //This closure creates security of the database
        mySQLiteDatabase.close();

    }

    public String [] getRational() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        String [] resp = new String[2];
        if (cursor != null){
            cursor.moveToLast();
            if (cursor.getCount()>0){
                resp[0] = cursor.getString(1);
                resp[1] = cursor.getString(2);
                db.close(); // Closing database connection
                return resp;
            }else {
                db.close(); // Closing database connection
                return null;
            }
        }
        else{
            db.close(); // Closing database connection
            return null;
        }

    }
}
