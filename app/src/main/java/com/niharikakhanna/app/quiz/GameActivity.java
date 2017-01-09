package com.niharikakhanna.app.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GameActivity extends Activity {
    public String loginName;
    public int score;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        Intent intent = getIntent();
        loginName = intent.getExtras().getString("fullname").toString();
        score = intent.getExtras().getInt("score");


        // Instance of ImageAdapter Class
        gridView.setAdapter(new LogoAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                // passing array index
                intent.putExtra("id", position);
                intent.putExtra("fullname",loginName);
                intent.putExtra("score",score);
                startActivity(intent);
                finish();
            }
        });
    }
}



