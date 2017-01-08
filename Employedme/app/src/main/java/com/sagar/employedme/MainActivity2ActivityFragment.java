package com.sagar.employedme;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivity2ActivityFragment extends Fragment {
    DatabaseHelper dbHelper;

    public MainActivity2ActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ListView listView = (ListView) container.findViewById(R.id.list_item);
        dbHelper.open();
        Cursor cursor = dbHelper.getdata();
        final Cadaptar cursorad = new Cadaptar(getActivity(),cursor);
        listView.setAdapter(cursorad);
        View rootView = inflater.inflate(R.layout.activity_main_activity2, container, false);
        dbHelper.close();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dbHelper.getdata().moveToPosition(position);
                String ad = (String) cursorad.getItem(position);
                Intent intent = new Intent(getActivity(), MainActivity2Activity.class)
                        .putExtra(Intent.EXTRA_TEXT, ad);
                startActivity(intent);


            }
        });


        return rootView;
    }
}

