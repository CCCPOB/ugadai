package com.example.ugadai_sidorychev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvinfo;
    EditText etinput;
    Button bcontrol;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Связываем наши переменные
        tvinfo = (TextView) findViewById(R.id.textView2);
        etinput = (EditText) findViewById(R.id.editText2);
        bcontrol = (Button) findViewById(R.id.button2);

        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

    public void onClick(View v) {
        if (!gameFinished) {
            int imp = Integer.parseInt(etinput.getText().toString());
            if (imp > guess)
                tvinfo.setText(getResources().getString(R.string.ahead));
            if (imp < guess)
                tvinfo.setText(getResources().getString(R.string.behind));
            if (imp == guess) {
                tvinfo.setText(getResources().getString(R.string.hit));
                bcontrol.setText(getResources().getString(R.string.play_now));
                gameFinished = true;
            }
        } else {
            guess = (int) (Math.random() * 100);
            bcontrol.setText(getResources().getString(R.string.input_value));
            tvinfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;

        }
    }
}