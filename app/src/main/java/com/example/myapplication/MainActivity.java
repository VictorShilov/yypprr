package com.example.myapplication;

import static kotlinx.coroutines.CoroutineScopeKt.cancel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    Button button;

    Button order;

    TextView textView;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextNumber);

        button = (Button) findViewById(R.id.button);

        order = (Button) findViewById(R.id.order);

        textView = (TextView) findViewById(R.id.textView);
        Button info  = findViewById(R.id.order);
        Intent intent = new Intent();
        intent.setClass(this,  MainActivity2.class);
      info.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              startActivity(intent);

          }
      });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                    int seconds = Integer.valueOf(editText.getText().toString());
                    CountDownTimer countDownTimer = new CountDownTimer(seconds * 1000, 1) {
                        @Override
                        public void onTick(long millis) {
                            //textView.setText("Осталось времени: " + (int) (millis / 1000));
                            long m = TimeUnit.MILLISECONDS.toMinutes(millis);
                            long s = TimeUnit.MILLISECONDS.toSeconds(millis- m*60*1000);
                            long ms = millis - m*60*1000 - s*1000;
                            textView.setText(""+String.format("%02d:%02d:%02d",m, s, ms));
                        }

                        @Override
                        public void onFinish() {
                            textView.setText("Тут должен быть звук, но да ладно)");
                        }
                        Object tected;

                    }.start();
                }
        });
    }
}