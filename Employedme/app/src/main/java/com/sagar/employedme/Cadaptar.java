package com.sagar.employedme;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by MHC on 4/16/2015.
 */
public class Cadaptar extends CursorAdapter {
    DatabaseHelper db;

    public Cadaptar(Context context, Cursor cursor) {
        super(context,cursor);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
      return LayoutInflater.from(context).inflate(R.layout.searchjob_item,parent,false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View a = inflater.inflate(R.layout.searchjob_item ,null);
//        bindView(a,context,cursor);

        // Find fields to populate in inflated template

        TextView tvname = (TextView) view.findViewById(R.id.contactnameTV);
        TextView tvjob = (TextView) view.findViewById(R.id.jobnameTV);
        TextView tvciy = (TextView) view.findViewById(R.id.citinm);
        TextView tvgen = (TextView) view.findViewById(R.id.gen);
        TextView tvcontactno = (TextView) view.findViewById(R.id.contactnu);
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
