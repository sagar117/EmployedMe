package com.sagar.employedme;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by MHC on 6/17/2015.
 */
public class displayadaptar extends CursorAdapter {
    public displayadaptar(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.resume,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView tvname = (TextView) view.findViewById(R.id.name);
        TextView tvjob = (TextView) view.findViewById(R.id.work);
        TextView tvciy = (TextView) view.findViewById(R.id.city);
        TextView tvgen = (TextView) view.findViewById(R.id.gender);
        TextView tvcontactno = (TextView) view.findViewById(R.id.contactn);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
        String job = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_RWORK));
        String city = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CITY));
        String gen = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_GENDER));
        int contactno = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CONTACTNO));
        // Populate fields with extracted properties

        tvname.setText(name);
        tvjob.setText(job);
        tvciy.setText(city);
        tvgen.setText(gen);
        tvcontactno.setText(String.valueOf(contactno));
    }
}
