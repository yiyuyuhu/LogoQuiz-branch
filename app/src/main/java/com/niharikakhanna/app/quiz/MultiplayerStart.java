package com.niharikakhanna.app.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiplayerStart extends AppCompatActivity {

    public String loginName;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_start);
        Intent intent = getIntent();
        loginName = intent.getExtras().getString("fullname").toString();

        mPlayButton = (Button) findViewById(R.id.start);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MultiplayerStart.this, MultiplayerQuiz.class);
                intent.putExtra("fullname", loginName);
                startActivity(intent);
            }
        });
    }
}
