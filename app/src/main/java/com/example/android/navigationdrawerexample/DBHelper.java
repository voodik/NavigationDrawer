package com.example.android.navigationdrawerexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mongol on 26.11.2014.
 */
public class DBHelper extends SQLiteOpenHelper {
    final String LOG_TAG = "DBHelper";


    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, "myDB", null, 1);
        Log.d(LOG_TAG,"constructor called");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- onCreate database ---");
        // создаем таблицу с полями
        db.execSQL("create table lists ("
                + "id integer primary key autoincrement,"
                + "name text" + ");");
        ContentValues values = new ContentValues();
        values.put("name", "Main List");
        long rowID = db.insert("lists", null, values);
        values.put("name", "Seccond List");
        rowID = db.insert("lists", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String[] getlistitems(SQLiteDatabase db){

//        SQLiteDatabase db = getWritableDatabase();
        Cursor crs = db.rawQuery("SELECT name FROM lists", null);
        String[] array = new String[crs.getCount()+1];

        int i = 0;
        while(crs.moveToNext()){
            String uname = crs.getString(0);
            array[i] = uname;
            i++;
        }

        array[i] = "Settings";
        return array;
    }
}