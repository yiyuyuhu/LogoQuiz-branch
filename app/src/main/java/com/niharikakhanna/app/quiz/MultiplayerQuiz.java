package com.niharikakhanna.app.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static com.niharikakhanna.app.quiz.R.id.imageView;

public class MultiplayerQuiz extends AppCompatActivity {

    private Questions[] mQuestionBank = QuestionDatabase.getArray();
    private Questions[] selectedQuestions = new Questions[5];
    public String loginName;
    private Button mOptionOne;
    private Button mOptionTwo;
    private Button mOptionThree;
    private Button mOptionFour;
    private Button mNextButton;
    ImageView imageView;
    TextView mScoreTextOne, mScoreTextTwo;
    public int i = 0;
    private int rounds = 1;
    public int answered = 0;
    private int scoreOne, scoreTwo = 0;
    private boolean userOneTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_quiz);

        Intent intent = getIntent();
        loginName = intent.getExtras().getString("fullname").toString();

        UniqueRandomNumbers();

        mOptionOne = (Button) findViewById(R.id.option1);
        mOptionTwo = (Button) findViewById(R.id.option2);
        mOptionThree = (Button) findViewById(R.id.option3);
        mOptionFour = (Button) findViewById(R.id.option4);
        mNextButton = (Button) findViewById(R.id.next_button);
        mScoreTextOne = (TextView) findViewById(R.id.score_one);
        mScoreTextTwo = (TextView) findViewById(R.id.score_two);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion();
            }
        });

        mOptionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                checkAnswer(buttonText);
                updateQuestion();
            }
        });

        mOptionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                checkAnswer(buttonText);
                updateQuestion();
            }
        });

        mOptionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                checkAnswer(buttonText);
                updateQuestion();
            }
        });

        mOptionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String buttonText = b.getText().toString();
                checkAnswer(buttonText);
                updateQuestion();
            }
        });
        i--;
        updateQuestion();

    }


    public void UniqueRandomNumbers() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i=1; i<mQuestionBank.length; i++) {
                list.add(new Integer(i));
            }
            Collections.shuffle(list);
            for (int i=0; i<5; i++) {
                selectedQuestions[i] = mQuestionBank[list.get(i)];
            }
        }

    public void updateQuestion() {
        i++;
        if (i == selectedQuestions.length && rounds < 2) {
            i = 0;
            userOneTurn = false;
            rounds++;
            final AlertDialog.Builder builder = new AlertDialog.Builder(MultiplayerQuiz.this);
            builder.setTitle("Player Two Begins");
            builder.setMessage("It's time for the second player to answer the quiz questions");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();

            imageView = (ImageView) findViewById(R.id.logo);
            imageView.setImageResource(selectedQuestions[i].getImageResId());

            String[] options = selectedQuestions[i].getOptions();
            mOptionOne.setText(options[0]);
            mOptionTwo.setText(options[1]);
            mOptionThree.setText(options[2]);
            mOptionFour.setText(options[3]);
        }
        else if(i == selectedQuestions.length && rounds == 2)
        {
            Intent intent = new Intent(MultiplayerQuiz.this,ScoreDisplayMulti.class);
            intent.putExtra("fullname",loginName);
            intent.putExtra("scoreOne", scoreOne);
            intent.putExtra("scoreTwo", scoreTwo);
            startActivity(intent);
            finish();
        }
        else {
            imageView = (ImageView) findViewById(R.id.logo);
            imageView.setImageResource(selectedQuestions[i].getImageResId());

            String[] options = selectedQuestions[i].getOptions();
            mOptionOne.setText(options[0]);
            mOptionTwo.setText(options[1]);
            mOptionThree.setText(options[2]);
            mOptionFour.setText(options[3]);
        }

    }

    private void checkAnswer(String userAnswer) {
        String answer = selectedQuestions[i].getAnswer();

        int messageResId;
        if (userAnswer.equals(answer)) {
            if(userOneTurn) {
                scoreOne++;
                mScoreTextOne.setText(""+scoreOne);
            }
            else {
                scoreTwo++;
                mScoreTextTwo.setText(""+scoreTwo);
            }
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(MultiplayerQuiz.this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

}
