package com.niharikakhanna.app.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper db = new DBHelper(this);

        ActionBar ab = getSupportActionBar();
        ab.hide();

        //Referencing UserEmail, Password EditText and TextView for SignUp Now;
        final EditText _txtemail = (EditText) findViewById(R.id.lEditEmail);
        final EditText _txtpass = (EditText) findViewById(R.id.lEditPassword);
        Button _btnlogin = (Button) findViewById(R.id.btnLogin);
        TextView _btnreg = (TextView) findViewById(R.id.btnLinkToRegisterScreen);
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = _txtemail.getText().toString();
                String pass = _txtpass.getText().toString();
                User user = db.checkUser(email,pass);
                if (user != null) {
                        Toast.makeText(MainActivity.this, "Successfully logged in!", Toast.LENGTH_SHORT).show();
                        String _fname = user.getUserName();
                        String _email = user.getEmail();
                        Intent intent = new Intent(MainActivity.this,LoginSuccessActivity.class);
                        intent.putExtra("fullname",_fname);
                        intent.putExtra("email",_email);
                        startActivity(intent);

                        //Removing MainActivity[Login Screen] from the stack for preventing back button press.
                        finish();
                    }
                    else {

                        //I am showing Alert Dialog Box here for alerting user about wrong credentials
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Alert");
                        builder.setMessage("Incorrect Username or ");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.dismiss();

                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                        //-------Alert Dialog Code Snippet End Here
                    }
                }

            });

        // Intent For Opening RegisterAccountActivity
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}