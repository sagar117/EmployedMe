package com.sagar.employedme;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    LocalDatabase localDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.blogin) {

            EditText uname = (EditText) findViewById(R.id.Luname);
            String str = uname.getText().toString();
            EditText pass = (EditText) findViewById(R.id.Lpass);
            String pas = pass.getText().toString();
            localDatabase=new LocalDatabase(this);

            Contact contact=new Contact(str,pas);
            authenticate(contact);
//            if (str.isEmpty() || pas.isEmpty()) {
//                Toast emptylogin = Toast.makeText(MainActivity.this, "Fill Username and Password", Toast.LENGTH_SHORT);
//                emptylogin.show();
//            }
////            String storedPassword=helper.getSinlgeEntry(str);
////            if(pass.equals(storedPassword))
////            {
////                Intent i = new Intent(MainActivity.this, Display.class);
////                i.putExtra("Username", str);
////                startActivity(i);
////                Toast l = Toast.makeText(MainActivity.this, "successfully log in", Toast.LENGTH_SHORT);
////                l.show();
//            String password = helper.searchpass(str);
//            if (pass.equals(password)) {
//                Intent i = new Intent(MainActivity.this, Display.class);
//                i.putExtra("Username", str);
//                startActivity(i);
//            } else {
//                Toast temp = Toast.makeText(MainActivity.this, "password and username not match", Toast.LENGTH_SHORT);
//                temp.show();
//            }

        }

    }
    private void authenticate(Contact contact){
        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.fetchDataInBackground(contact, new GetUserCallback() {
            @Override
            public void done(Contact returnedContact) {
                if(returnedContact==null){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("username & password don't match");
                    builder.setPositiveButton("Ok",null);
                    builder.show();
                }else{
                    //log user is
                    localDatabase.storeData(returnedContact);
                    localDatabase.setLoggedIn(true);
                    Intent intent=new Intent(MainActivity.this,Display.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void onbClick(View v) {
        if (v.getId() == R.id.esignup) {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }

    public void oncClick(View v) {
        if (v.getId() == R.id.query) {
            Intent c = new Intent(MainActivity.this, searchjob.class);
            startActivity(c);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setType("plain/text");
        sendIntent.setData(Uri.parse("sagarpawar3007@gmail.com"));
        sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "sagarpawar3007@gmail.com" });
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(sendIntent);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


