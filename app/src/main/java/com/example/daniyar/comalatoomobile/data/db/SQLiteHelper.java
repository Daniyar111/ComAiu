package com.example.daniyar.comalatoomobile.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.daniyar.comalatoomobile.data.entity.timetable.TimetableModel;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "COM";
    private static final int DB_VERSION = 2;

    private static final String TABLE_TIMETABLE = "TABLE_TIMETABLE";
    private static final String TABLE_TIMES = "TABLE_TIMES";

    private static final String ID = "_id";

    private static final String NAME = "NAME";
    private static final String OTHER = "OTHER";
    private static final String TIME = "TIME";

    public static final String CREATE_TABLE_TIMETABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_TIMETABLE + "(" +
            ID + " INTEGER_PRIMARY_KEY, " +
            NAME + " TEXT, " +
            OTHER + " TEXT);";

    public static final String CREATE_TABLE_TIMES = "CREATE TABLE IF NOT EXISTS " +
            TABLE_TIMES + "(" +
            ID + " INTEGER_PRIMARY_KEY, " +
            TIME + " TEXT);";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TIMETABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE_TIMES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TIMETABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TIMES);
        onCreate(sqLiteDatabase);
    }

    public void saveTimetable(TimetableModel timetableModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        db.delete(TABLE_TIMETABLE, null, null);
        db.delete(TABLE_TIMES, null, null);
        for (int i = 0; i < timetableModel.getTimes().size(); i++) {
            cv.put(TIME, timetableModel.getTimes().get(i));
            db.insert(TABLE_TIMES, null, cv);
        }
        for (int i = 0; i < timetableModel.getWeeks().size(); i++) {

        }
        db.close();
    }

    public ArrayList<String> getTimetable(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<String> times = new ArrayList<>();
        Cursor cursor = db.query(TABLE_TIMES, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            int timeIndex = cursor.getColumnIndex(TIME);
            do {
                String time = cursor.getString(timeIndex);
                times.add(time);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return times;
    }
}
