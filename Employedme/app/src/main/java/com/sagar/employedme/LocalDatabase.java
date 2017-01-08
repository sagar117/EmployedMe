package com.sagar.employedme;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MHC on 12/16/2015.
 */
public class LocalDatabase {
    public static final String SP_NAME="UserDetails";
    SharedPreferences localDatabase;
     public LocalDatabase(Context context){
         localDatabase=context.getSharedPreferences(SP_NAME,0);
     }
    public void storeData(Contact contact){
        SharedPreferences.Editor spEditor=localDatabase.edit();
        spEditor.putString("name",contact.name);
        spEditor.putString("uname",contact.uname);
        spEditor.putString("email",contact.email);
        spEditor.putString("pass",contact.pass);
        spEditor.commit();

    }
    public Contact getLoggedInUser()
    {
        String name=localDatabase.getString("name", "");
        String uname=localDatabase.getString("uname","");
        String email=localDatabase.getString("email","");
        String pass=localDatabase.getString("pass","");
        Contact storedContact=new Contact(name,uname);
        return storedContact;

    }
    public void setLoggedIn(boolean loggedIn){

SharedPreferences.Editor spEditor=localDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }
    public boolean getUsserLoggedIn(){
        if(localDatabase.getBoolean("loggIn",false)){
           return true;
        }else{
            return false;
        }

    }
    public void clearData(){
        SharedPreferences.Editor spEditor=localDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }
}
