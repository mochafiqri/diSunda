package dev.edmt.flagsquizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dev.edmt.flagsquizapp.DbHelper.DbHelper;
import dev.edmt.flagsquizapp.Model.Question;
import dev.edmt.flagsquizapp.Model.Question1;

public class Playing1 extends AppCompatActivity implements View.OnClickListener {

    final static long INTERVAL = 1000; // 1 second
    final static long TIMEOUT = 20000; // 7 sconds
    int progressValue = 0;

    CountDownTimer mCountDown; // for progressbar
    List<Question1> questionPlay = new ArrayList<>(); //total Question
    DbHelper db;
    int index=0,score=0,thisQuestion=0,totalQuestion,correctAnswer;
    String mode="";

    //Control
    ProgressBar progressBar;
    ImageView imageView;
    Button cek;
    TextView txtScore,txtQuestion,questionWord;
    EditText Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing1);

        //Get Data from MainActivity
        Bundle extra = getIntent().getExtras();
        if(extra != null)
            mode=extra.getString("MODE");

        db = new DbHelper(this);

        txtScore = (TextView)findViewById(R.id.txtScore);
        txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        questionWord = (TextView)findViewById(R.id.questionWord);
        Answer = (EditText)findViewById(R.id.answer);
        cek=(Button)findViewById(R.id.cek);

        cek.setOnClickListener(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

       questionPlay = db.getQuestion0();
        totalQuestion = questionPlay.size();


        showQuestion(index);
    }

    private void showQuestion(int index) {
        if(index < totalQuestion){
            thisQuestion++;
            txtQuestion.setText(String.format("%d/%d",thisQuestion,totalQuestion));
            progressBar.setProgress(0);
            progressValue = 0;


            questionWord.setText(questionPlay.get(index).getQuest());


        }
        else{
            Intent intent = new Intent(this,Done.class);
            Bundle dataSend = new Bundle();
            dataSend.putInt("SCORE",score);
            dataSend.putInt("TOTAL",totalQuestion);
            dataSend.putInt("CORRECT",correctAnswer);
            intent.putExtras(dataSend);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {


        if(index < totalQuestion){
            String answer = Answer.getText().toString();
            System.out.println(answer);

            if(answer.equals(questionPlay.get(index).getCorrectAnswer()))
            {
                score+=10; // increase score
                correctAnswer++ ; //increase correct answer
                showQuestion(++index);
            }
            else
                showQuestion(++index); // If choose right , just go to next question

            txtScore.setText(String.format("%d",score));
        }

    }
}
