package com.sagar.employedme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MHC on 4/12/2015.
 */
public class findjob extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findjob);
        String username = getIntent().getStringExtra("Username");
        TextView a = (TextView) findViewById(R.id.jobwel);
        a.setText(username);
    }

    public void onbButtonClick(View v) {

        if (v.getId() == R.id.bjobseach) {

            EditText p = (EditText) findViewById(R.id.bjobname);
            String jobname = p.getText().toString();
            EditText q = (EditText) findViewById(R.id.bcityname);
            String acity = q.getText().toString();
            String city = helper.searchcontact(jobname);
            if (acity.equals(city)) {
                Intent i = new Intent(findjob.this, MainActivity2ActivityFragment.class);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(findjob.this, " SORRY, NO SUCH JOB AVAILABLE AT YOUR PLACE", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    }
}


