package com.sagar.employedme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by MHC on 4/5/2015.
 */
public class Display extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.nameTV);
        tv.setText(username);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.bfjob) {
            Intent i = new Intent(Display.this, findjob.class);
            startActivity(i);

        }
    }

    public void onaClick(View v) {
        if (v.getId() == R.id.bgjob) {
            Intent a = new Intent(Display.this, findservant.class);
            startActivity(a);

        }

    }

    public void onname(View v) {
        if (v.getId() == R.id.nameTV) {
            Intent a = new Intent(Display.this, resume.class);
            startActivity(a);


        }
    }
}








