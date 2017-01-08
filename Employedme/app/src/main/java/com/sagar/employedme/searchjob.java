package com.sagar.employedme;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class searchjob extends Activity {
    public DatabaseHelper dbHelper;
    CursorAdapter cursorad;
    UserAdaptar arrayAdapter;
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.searchjob);
            ListView listView = (ListView) findViewById(R.id.list_item);
            dbHelper=new DatabaseHelper(searchjob.this);
            dbHelper.open();
            Cursor cursor = dbHelper.getdata();
            final Cadaptar cursorad = new Cadaptar(this,cursor);
            listView.setAdapter(cursorad);
            dbHelper.close();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    dbHelper.getdata().moveToPosition(position);
                    String ad= (String) cursorad.getItem(position);
//                    Intent intent = new Intent((), searchjob_item.class)
//                            .putExtra(Intent.EXTRA_TEXT, ad);
//                    startActivity(intent);


                }
            });
        }catch (Exception e){
            Toast s=Toast.makeText(searchjob.this," fucked up",Toast.LENGTH_SHORT);
            s.show();
        }
    }
}

