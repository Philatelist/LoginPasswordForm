package com.slavyanin.example.loginpasswordform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);


        final View.OnClickListener buttonLogin = new IfValidUser(this);

        final Button login = (Button) findViewById(R.id.buttonLogin);
//        Button register = (Button) findViewById(R.id.buttonRegister);
//        Button remind = (Button) findViewById(R.id.buttonRemindPassword);

        EditText emailView = (EditText) findViewById(R.id.editTextEmail);
        EditText passwView = (EditText) findViewById(R.id.editTextPassword);

        final String emailText = emailView.getText().toString();
        final String passwText = passwView.getText().toString();


        final User admin = new User("admin", "admin");

        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (admin.isValideUser(emailText) && admin.isValidPassword(passwText)) {
                    login.setOnClickListener(buttonLogin);
                }
            }
        });
    }
}
