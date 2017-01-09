package com.niharikakhanna.app.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Khanna on 23/12/16.
 */



public class LoginSuccessActivity extends AppCompatActivity {

    public String loginName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        //To hide AppBar for fullscreen.
        ActionBar ab = getSupportActionBar();
        ab.hide();

        TextView txtname = (TextView) findViewById(R.id.txt_name);
        Button mBtnlogout = (Button) findViewById(R.id.btnLogout);
        Button mBtnMulti = (Button) findViewById(R.id.btnMulti);
        Button mBtnStart = (Button) findViewById(R.id.btnStart);

        Intent intent = getIntent();
        loginName = intent.getStringExtra("fullname");
        String display = "Are you ready to play the Logo Quiz, " + loginName + "?";
        txtname.setText(display);

        mBtnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(LoginSuccessActivity.this);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure you want to logout?");
                builder.setPositiveButton("Hell Yeah!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(LoginSuccessActivity.this, MainActivity.class);
                        startActivity(intent);

                        finish();

                    }
                });

                builder.setNegativeButton("Absolutely Not!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessActivity.this,QuizActivity.class);
                intent.putExtra("fullname",loginName);
                intent.putExtra("score",0);
                intent.putExtra("id",0);
                startActivity(intent);
                finish();

            }
        });

        mBtnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginSuccessActivity.this,MultiplayerStart.class);
                intent.putExtra("fullname",loginName);
                startActivity(intent);
                finish();
            }
        });



    }
}


