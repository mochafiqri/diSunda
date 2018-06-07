package dev.edmt.flagsquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Playing3 extends AppCompatActivity {

    TextView questionWord;
    LinearLayout layjawab,layjawabanA,layjawabanB,layjawabanC,layjawabanD;
    Button cek,jawabA,jawabB,jawabC,jawabD;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing3);

        questionWord = (TextView) findViewById(R.id.questionWord);
        layjawab = (LinearLayout) findViewById(R.id.layjawab);
        layjawabanA = (LinearLayout) findViewById(R.id.layjawabanA);
        layjawabanB = (LinearLayout) findViewById(R.id.layjawabanB);
        layjawabanC = (LinearLayout) findViewById(R.id.layjawabanC);
        layjawabanD = (LinearLayout) findViewById(R.id.layjawabanD);
        cek = (Button) findViewById(R.id.cek);
        jawabA = (Button) findViewById(R.id.jawabA);
        jawabB = (Button) findViewById(R.id.jawabB);
        jawabC = (Button) findViewById(R.id.jawabC);
        jawabD = (Button) findViewById(R.id.jawabD);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        jawabA.setOnClickListener(onClickListener);
        jawabB.setOnClickListener(onClickListener);
        jawabC.setOnClickListener(onClickListener);
        jawabD.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.jawabA){
                LinearLayout oldparent = (LinearLayout) v.getParent();
                if (oldparent.getId() == R.id.layjawabanA){
                    oldparent.removeView(v);
                    layjawab.addView(v);
                }else{
                    oldparent.removeView(v);
                    layjawabanA.addView(v);
                }
            }
            if (v.getId() == R.id.jawabB){
                LinearLayout oldparent = (LinearLayout) v.getParent();
                if (oldparent.getId() == R.id.layjawabanB){
                    oldparent.removeView(v);
                    layjawab.addView(v);
                }else{
                    oldparent.removeView(v);
                    layjawabanB.addView(v);
                }
            }
            if (v.getId() == R.id.jawabC){
                LinearLayout oldparent = (LinearLayout) v.getParent();
                if (oldparent.getId() == R.id.layjawabanC){
                    oldparent.removeView(v);
                    layjawab.addView(v);
                }else{
                    oldparent.removeView(v);
                    layjawabanC.addView(v);
                }
            }
            if (v.getId() == R.id.jawabD){
                LinearLayout oldparent = (LinearLayout) v.getParent();
                if (oldparent.getId() == R.id.layjawabanD){
                    oldparent.removeView(v);
                    layjawab.addView(v);
                }else{
                    oldparent.removeView(v);
                    layjawabanD.addView(v);
                }
            }
        }
    };
}
