package com.niharikakhanna.app.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreDisplayMulti extends AppCompatActivity {

    private TextView mWonDisplay;
    public int scoreOne;
    public int scoreTwo;
    private TextView mScoreDisplay;
    private String loginName;
    private Button mReplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display_multi);

        Intent intent = getIntent();
        loginName = intent.getStringExtra("fullname").toString();

        mWonDisplay = (TextView) findViewById(R.id.won);
        mReplay = (Button) findViewById(R.id.replay);
        mScoreDisplay = (TextView) findViewById(R.id.score_display);
        scoreOne = intent.getExtras().getInt("scoreOne");
        scoreTwo = intent.getExtras().getInt("scoreTwo");

        if(scoreOne > scoreTwo) {
            mWonDisplay.setText("Player One Won!");
        }
        else if(scoreTwo > scoreOne) {
            mWonDisplay.setText("Player Two Won!");
        }
        else
            mWonDisplay.setText("It's a tie!");

        mWonDisplay.append("\nFinal Scores:");
        mScoreDisplay.setText("Player One: "+scoreOne+"\nPlayer Two: "+scoreTwo);

        mReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreDisplayMulti.this,LoginSuccessActivity.class);
                intent.putExtra("fullname",loginName);
                startActivity(intent);
                finish();
            }
        });

    }
}