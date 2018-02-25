package com.studycase.vanard.vianrasyiddiyatma_1202154186_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //buat handler delay
        new Handler().postDelayed(new Runnable() {
            //jalankan setelah waktu yang ditentukan
            @Override
            public void run() {
                //startactivity
                startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                finish();
            }
        },1000);
    }
}
