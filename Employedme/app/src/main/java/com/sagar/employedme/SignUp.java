package com.sagar.employedme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MHC on 4/5/2015.
 */
public class SignUp extends Activity {
//    Spinner spinner;
//    String[] gender={"male","female"};

    DatabaseHelper ahelper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.bsignup) {

            EditText name = (EditText) findViewById(R.id.name);
            EditText email = (EditText) findViewById(R.id.email);
            EditText uname = (EditText) findViewById(R.id.Luname);
            EditText pass = (EditText) findViewById(R.id.Lpass);
            EditText cpass = (EditText) findViewById(R.id.cpass);
            EditText contactno = (EditText) findViewById(R.id.bcontact);
            EditText age = (EditText) findViewById(R.id.bAge);
            EditText gender = (EditText) findViewById(R.id.genderTV);
            EditText city = (EditText) findViewById(R.id.bcity);
            EditText reqjob = (EditText) findViewById(R.id.breqwork);
            EditText avjob = (EditText) findViewById(R.id.bsereq);


            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String passstr = pass.getText().toString();
            String cpassstr = cpass.getText().toString();
            String contactnostr = contactno.getText().toString();
            String agestr = age.getText().toString();
            String genderstr = gender.getText().toString();
            String citystr = city.getText().toString();
            String reqjobstr = reqjob.getText().toString();
            String avjobstr = avjob.getText().toString();

            try {
                if (!passstr.equals(cpassstr)) {
                    Contact contact = new Contact(namestr, emailstr);
                    ServerRequest serverRequest = new ServerRequest(this);
                    serverRequest.storeDataInBackground(contact, new GetUserCallback() {
                        @Override
                        public void done(Contact returnedContact) {
                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });

                } else {
                    Toast temp = Toast.makeText(SignUp.this, "password and username not match", Toast.LENGTH_SHORT);
                temp.show();
                }

                }catch(Exception e){
                Toast Serror = Toast.makeText(SignUp.this, "oops something went wrong ,TRY AGAIN", Toast.LENGTH_SHORT);
                Serror.show();
//        ArrayAdapter<String> adapatr=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,gender);
//        spinner=(Spinner)findViewById(R.id.spinner);
//        spinner.setAdapter(adapatr);

            }
        }
    }
}
