package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    ProgressBar progressBar;
    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextNumber);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        button = (Button) findViewById(R.id.button);

        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                    int seconds = Integer.valueOf(editText.getText().toString());
                    CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1000) {
                        @Override
                        public void onTick(long millis) {
                            textView.setText("Осталось времени: " + (int) (millis / 1000));
                            progressBar.setProgress((int)  (millis/1000));
                        }

                        @Override
                        public void onFinish() {
                            textView.setText("Тут должен быть звук, но да ладно)");
                        }
                    }.start();

            }
        });
    }
}