package com.sagar.employedme;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by MHC on 5/7/2015.
 */
public class UserAdaptar extends ArrayAdapter<String> {
    DatabaseHelper db;
    Cursor cursor;

    public UserAdaptar(Context context, int resource) {
        super(context, resource);
    }

    public UserAdaptar(Context context, int resource, ViewGroup parent) {
        super(context, resource);
        View view = null;
        TextView tvname = (TextView) view.findViewById(R.id.contactnameTV);
        TextView tvjob = (TextView) view.findViewById(R.id.jobnameTV);
        TextView tvciy = (TextView) view.findViewById(R.id.citinm);
        TextView tvcontactno = (TextView) view.findViewById(R.id.contactnu);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow(db.COLUMN_NAME));
        String job = cursor.getString(cursor.getColumnIndexOrThrow(db.COLUMN_RWORK));
        String city = cursor.getString(cursor.getColumnIndexOrThrow(db.COLUMN_CITY));
        int contactno = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_CONTACTNO));
        // Populate fields with extracted properties
        tvname.setText(name);
        tvjob.setText(job);
        tvciy.setText(city);
        tvcontactno.setText(String.valueOf(contactno));

    }
}
