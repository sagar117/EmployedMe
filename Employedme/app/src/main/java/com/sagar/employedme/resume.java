package com.sagar.employedme;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by MHC on 6/17/2015.
 */
public class resume extends ActionBarActivity {
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);
//        TextView textView = (TextView) findViewById(R.id.list_item);
        dbHelper = new DatabaseHelper(resume.this);
        dbHelper.open();
//        Cursor cursor = dbHelper.displaydata();
    }


//    public void bindView(View view, Context context, Cursor cursor) {
//
//        TextView tvname = (TextView) view.findViewById(R.id.name);
//        TextView tvjob = (TextView) view.findViewById(R.id.work);
//        TextView tvciy = (TextView) view.findViewById(R.id.city);
//        TextView tvgen = (TextView) view.findViewById(R.id.gender);
//        TextView tvcontactno = (TextView) view.findViewById(R.id.contactn);
//        // Extract properties from cursor
//        String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
//        String job = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_RWORK));
//        String city = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CITY));
//        String gen = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_GENDER));
//        int contactno = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CONTACTNO));
//        // Populate fields with extracted properties
//
//        tvname.setText(name);
//        tvjob.setText(job);
//        tvciy.setText(city);
//        tvgen.setText(gen);
//        tvcontactno.setText(String.valueOf(contactno));
    }


