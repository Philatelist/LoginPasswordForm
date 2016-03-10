package com.slavyanin.example.loginpasswordform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);

        final View.OnClickListener buttonLoginCorrect = new IfValidUser(this);
        final View.OnClickListener buttonLoginIncorrect = new IfInvalidUser(this);

        final Button login = (Button) findViewById(R.id.buttonLogin);
//        Button register = (Button) findViewById(R.id.buttonRegister);
//        Button remind = (Button) findViewById(R.id.buttonRemindPassword);

        final User admin = new User("admin", "admin");
        Toast.makeText(LoginPasswordActivity.this, admin.toString(), Toast.LENGTH_LONG).show();

//        emailView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailView = (EditText) findViewById(R.id.editTextEmail);
                EditText passwView = (EditText) findViewById(R.id.editTextPassword);

                User newUser = new User(emailView.getText().toString(), passwView.getText().toString());

//                Toast.makeText(MainActivity.this, newUser.toString(), Toast.LENGTH_LONG).show();

                if (newUser.isValideUser(admin.getName()) && newUser.isValidPassword(admin.getPassword())) {
                    login.setOnClickListener(buttonLoginCorrect);
                } else {
                    login.setOnClickListener(buttonLoginIncorrect);
                }
            }
        });
    }

}
