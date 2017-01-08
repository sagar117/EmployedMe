package com.sagar.employedme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by MHC on 6/17/2015.
 */
public class flash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash);
        Thread timer=new Thread(){
            public void run(){
             try {
                 sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }finally {
                 Intent a=new Intent(flash.this,MainActivity.class);
                 startActivity(a);
             }
            }
        };timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
