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
public class findservant extends Activity {
    DatabaseHelper helper=new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findservant);
        String username = getIntent().getStringExtra("Username");
        TextView b = (TextView) findViewById(R.id.textView12);
        b.setText(username);
}
    public void onbButtonClick(View v) {
     try {
         if (v.getId() == R.id.bservantsearch) {

             EditText x=(EditText)findViewById(R.id.serworkf);
             String workname=x.getText().toString();
             EditText y=(EditText)findViewById(R.id.sercitiname);
             String bcity=y.getText().toString();
             String city=helper.searchservant(workname);
             if (bcity.equals(city)){
                 Intent c=new Intent(findservant.this,searchjob.class);
//                 c.putExtra("Avajov",workname);
                 startActivity(c);
             }else {
                 Toast temp=Toast.makeText(findservant.this," SORRY, NO SUCH JOB AVAILABLE AT YOUR PLACE",Toast.LENGTH_SHORT);
                 temp.show();
             }
         }
     }catch (Exception e){
         Toast s=Toast.makeText(findservant.this," oops...something went wrong",Toast.LENGTH_SHORT);
         s.show();
     }
    }
}
