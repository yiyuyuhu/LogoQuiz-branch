package com.niharikakhanna.app.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreDisplay extends AppCompatActivity {

    public String loginName;
    public int score;
    private TextView mScoreDisplay;
    private Button mReplay;
    private TextView mScoreAll;
    private int[] scoreList = new int[100];
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        mScoreDisplay = (TextView) findViewById(R.id.score_display);
        mScoreAll = (TextView) findViewById(R.id.score_all);
        mReplay = (Button) findViewById(R.id.replay);
        DBHelper db = new DBHelper(this);

        Intent intent = getIntent();
        loginName = intent.getExtras().getString("fullname").toString();
        score = intent.getExtras().getInt("score");

        User user = db.getUser(loginName);
        db.addAttempt(new Attempt(user.getUserName(), score));

        mScoreDisplay.setText(""+score);

        ArrayList<Attempt> attempts = db.getAllAttempts();

        for (Attempt attempt : attempts) {
            if(loginName.equals(attempt.getUserName())) {
                    scoreList[index] = attempt.getScore();
                    index++;
            }
        }

        for(int i = 0; i<scoreList.length;i++) {
            for(int j = i+1; j<scoreList.length;j++) {
                if(scoreList[i]<scoreList[j]) {
                    int temp = scoreList[i];
                    scoreList[i] = scoreList[j];
                    scoreList[j] = temp;
                }
            }
        }

        for(int i = 0;i<scoreList.length;i++) {
            if(scoreList[i]!=0)
            mScoreAll.append("\n"+scoreList[i]);
        }

        mReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreDisplay.this,LoginSuccessActivity.class);
                intent.putExtra("fullname",loginName);
                startActivity(intent);
                finish();
            }
        });

    }
}
