package com.sagar.employedme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by MHC on 4/5/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static int DATABASE_VERSION = 6;
    public static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_UNAME = "uname";
    public static final String COLUMN_PASSWORD = "pass";
    public static final String COLUMN_CONTACTNO = "contactno";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_RWORK = "reqjob";
    public static final String COLUMN_AWORK = "avjob";

    private SQLiteDatabase db;

    int COL_ID_INDEX = 0;
    int COL_UNAME_INDEX = 1;
    int COL_PASSWORD_INDEX = 2;
    int COL_NAME_INDEX = 3;
    int COL_EMAIL_INDEX = 4;
    int COL_IMAGE_INDEX = 5;
    int COL_CONTACTNO_INDEX = 6;
    int COL_AGE_INDEX = 7;
    int COL_GENDER_INDEX = 8;
    int COL_CITY_INDEX = 9;
    int COL_RWORK_INDEX = 10;
    int COL_AWORK_INDEX = 11;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null, " +
            "name text not null,email text not null,uname text not null,pass text not null,contactno text not null,gender text not null,age text not null,city text not null,reqjob text not null,avjob text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }
    public DatabaseHelper open(){
        db=this.getReadableDatabase();
        return this;
    }
    public Cursor getdata() {
        db=this.getWritableDatabase();
        String query="select id as _id,uname,pass,contactno,name,email,age,city,reqjob,avjob from " + TABLE_NAME;
        Cursor cursor=db.rawQuery(query, null);
        return cursor;
    }
    public Cursor findjob(){
        db=this.getWritableDatabase();
        String whereClause = "city=chikhli";
        String query = "select id as _id,uname,pass,contactno,name,email,age,city,reqjob,avjob from " + TABLE_NAME;
        return db.query(TABLE_NAME, new String[]{query}, whereClause, null, null, null, null);
    }


    public void insertContact(contacts c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASSWORD, c.getPassword());
        values.put(COLUMN_CONTACTNO, c.getContactno());
        values.put(COLUMN_AGE, c.getAge());
        values.put(COLUMN_GENDER, c.getGender());
        values.put(COLUMN_CITY, c.getCity());
        values.put(COLUMN_RWORK, c.getReqjob());
        values.put(COLUMN_AWORK, c.getAvjob());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
//    public String getSinlgeEntry(String uname)
//    {
//        Cursor cursor=db.query(TABLE_NAME, null, " uname=?", new String[]{uname}, null, null, null);
//        if(cursor.getCount()<1) // UserName Not Exist
//        {
//            cursor.close();
//            return "NOT EXIST";
//        }
//        cursor.moveToFirst();
//        String password= cursor.getString(cursor.getColumnIndex("COLUMN_PASSWORD"));
//        cursor.close();
//        return password;
//    }

    public String searchpass(String uname) {
        db = this.getReadableDatabase();
        String query = "select uname, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);

                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    public String searchcontact(String reqjob) {
        db = this.getReadableDatabase();
        String query = "select reqjob, city from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String p, q;
        q = "not found";
        if (cursor.moveToFirst()) {
            do {
                p = cursor.getString(0);

                if (p.equals(reqjob)) {
                    q = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return q;
    }

    public String searchservant(String avjob) {
        db = this.getReadableDatabase();
        String query = "select avjob, city, gender from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String x, y;
        y = "not found";
        if (cursor.moveToFirst()) {
            do {
                x = cursor.getString(0);

                if (x.equals(avjob)) {
                    y = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return y;
    }
//    public String getName(Cursor cursor) {
//        return (cursor.getString(1));
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}




