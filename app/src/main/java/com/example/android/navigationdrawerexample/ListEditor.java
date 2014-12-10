package com.example.android.navigationdrawerexample;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;


public class ListEditor extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_editor);
//        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater ltInflater = getLayoutInflater();
        DBHelper dbh = new DBHelper(this);
        SQLiteDatabase dbb = dbh.getWritableDatabase();
        String[] listitems = dbh.getlistitems(dbb);
        int countlists = listitems.length;
        for (int i = 0; i < (countlists - 1); i++) {
//            View item = ltInflater.inflate(R.layout.list_item, linLayout, false);
//            EditText listitem = (EditText) item.findViewById(R.id.editText);
//            listitem.setText(listitems[i]);
//            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
//            linLayout.addView(item);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
