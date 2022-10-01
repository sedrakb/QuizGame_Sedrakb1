/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */
// the spask screen activity
package com.example.quizgame_sedrakb1;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState) {
        // linking the splash screen xml to the java class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // hiding the action bar on the splash screen
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);     // will display for 4 seconds
    }
}
// End By Bichoy Sedrak