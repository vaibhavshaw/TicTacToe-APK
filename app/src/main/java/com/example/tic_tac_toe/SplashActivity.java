package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread time = new Thread(){
            public void run(){
                try {
                    sleep(1500);
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                }finally {
                    Intent open = new Intent("com.example.tic_tac_toe.MAINACTIVITY");
                    startActivity(open);
                }
            }
        };
        time.start();
    }
}
