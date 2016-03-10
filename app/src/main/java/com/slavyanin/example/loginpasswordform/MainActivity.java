package com.slavyanin.example.loginpasswordform;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button getTo = (Button) findViewById(R.id.gettoanother);
        final Button share = (Button) findViewById(R.id.share);
        Button checkWifi = (Button) findViewById(R.id.checkwifi);
        Button openBrowser = (Button) findViewById(R.id.openbrowser);


        getTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context activity = null;
                Intent intent = new Intent(activity, LoginPasswordActivity.class);

                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject"); //shareIntent.putExtra(Intent.EXTRA_SUBJECT, activity.getString(R.string.share_sublect));
                shareIntent.putExtra(Intent.EXTRA_TEXT, "EXAMPLE TEXT");

                startActivity(Intent.createChooser(shareIntent, "Hello")); //startActivity(Intent.createChooser(shareIntent, activity.getString(R.string.share_title)
            }
        });

        checkWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://www.google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
