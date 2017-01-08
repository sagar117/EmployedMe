package com.sagar.employedme;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by MHC on 4/13/2015.
 */
public class searchservant extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchsrvant);
        ListView lv=(ListView)findViewById(R.id.list_item1);
    }
}
