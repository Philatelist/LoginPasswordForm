package com.slavyanin.example.loginpasswordform;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by slavyanin on 03.03.16.
 */
public class IfInvalidUser implements View.OnClickListener {

    private Context context;

    public IfInvalidUser(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String toastText = " ERROR. " + "\n" + " LOGIN and PASSWORD incorrect! ";
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
    }
}
