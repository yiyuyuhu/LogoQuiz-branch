package com.niharikakhanna.app.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private String title = "";
    private String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText txtemail = (EditText) findViewById(R.id.rEditEmail);
        final EditText txtname = (EditText) findViewById(R.id.rName);
        final EditText txtpass = (EditText) findViewById(R.id.rEditPassword);
        Button _btnregister = (Button) findViewById(R.id.btnRegister);
        TextView _btnlog = (TextView) findViewById(R.id.btnLinkToLoginScreen);

        final DBHelper db = new DBHelper(this);

        _btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtname.getText().toString();
                String email = txtemail.getText().toString();
                String pass = txtpass.getText().toString();

                final String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                if (email.matches(emailPattern)) {
                    if (db.getUser(name) == null) {
                        ArrayList<User> users = db.getAllUsers();
                        for (User user : users) {
                            if (email.equals(user.getEmail())) {
                                title = "That email address already registered";
                                message = "Please select a different email";
                                break;
                            }
                        }
                        if(title.equals("")) {
                            db.addUser(new User(name, email, pass));
                            title = "Registered";
                            message = "Your Account was successfully created!";
                        }
                    }
                    else if (db.getUser(name) != null) {
                        title = "Username already exists";
                        message = "Please select a different username";
                    }
                }
                else {
                    title = "Invalid Email Address";
                    message = "Enter a valid email address";
                }
                //Alert dialog after clicking the Register Account
                final AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Finishing the dialog and removing Activity from stack.
                        dialogInterface.dismiss();
                        if(title.equals("Registered"))
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


    }
  });

        // Intent For Opening LoginAccountActivity
        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

