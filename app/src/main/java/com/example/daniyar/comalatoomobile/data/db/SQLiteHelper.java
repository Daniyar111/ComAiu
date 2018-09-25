package com.example.daniyar.comalatoomobile.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.daniyar.comalatoomobile.data.entity.GradesModel;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "COM";
    private static final int DB_VERSION = 2;

    private static final String TABLE_GRADES = "TABLE_GRADES";

    private static final String ID = "_id";

    private static final String GRADE = "GRADE";

    public static final String CREATE_TABLE_GRADES = "CREATE TABLE IF NOT EXISTS " +
            TABLE_GRADES + "(" +
            ID + " INTEGER_PRIMARY_KEY, " +
            GRADE + " TEXT);";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_GRADES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_GRADES);
        onCreate(sqLiteDatabase);
    }

    public void saveRadioButtons(GradesModel gradesModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        db.delete(TABLE_GRADES, null, null);

        cv.put(GRADE, gradesModel.getGrade());

        db.insert(TABLE_GRADES, null, cv);
        db.close();
    }

    public GradesModel getRadioButtons(){
        SQLiteDatabase db = this.getWritableDatabase();
        GradesModel gradesModel = new GradesModel();
        Cursor cursor = db.query(TABLE_GRADES, null, null, null, null, null, null);

        if(cursor.moveToFirst()){
            int gradeIndex = cursor.getColumnIndex(GRADE);
            do{
                String grade = cursor.getString(gradeIndex);
                gradesModel.setGrade(grade);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return gradesModel;
    }
}
