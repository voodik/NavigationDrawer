package com.example.android.navigationdrawerexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Created by mongol on 26.11.2014.
 */
public class Dialog2 extends DialogFragment implements DialogInterface.OnClickListener {

    final String LOG_TAG = "myLogs";
    private EditText editQuantity;



    public Dialog onCreateDialog(Bundle savedInstanceState) {
        editQuantity = new EditText(getActivity());
        DBHelper dbh = new DBHelper(getActivity());
        SQLiteDatabase db = dbh.getReadableDatabase();
        String[] xz = dbh.getlistitems(db);
        int mID = getArguments().getInt("id");
        editQuantity.setText(xz[mID]);
//        editQuantity.setSelectAllOnFocus(true);
        editQuantity.requestFocus();


        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setTitle("Enter a list name").setPositiveButton(R.string.yes, this)
                .setNegativeButton(R.string.no, this)
//                .setNeutralButton(R.string.maybe, this)
                .setView(editQuantity);
//                .setMessage(R.string.message_text);
        return adb.create();
    }

    public void onClick(DialogInterface dialog, int which) {
        int i = 0;
        String value = editQuantity.getText().toString();
        Log.d(LOG_TAG, "Quantity: " + value);
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                i = R.string.yes;
                break;
            case Dialog.BUTTON_NEGATIVE:
                i = R.string.no;
                break;
            case Dialog.BUTTON_NEUTRAL:
                i = R.string.maybe;
                break;
        }
        if (i > 0)
            Log.d(LOG_TAG, "Dialog 2: " + getResources().getString(i));
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        int mID = getArguments().getInt("id");
        Log.d(LOG_TAG, "Dialog 2: onDismiss" + mID);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 2: onCancel");
    }
}