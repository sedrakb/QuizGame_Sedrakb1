/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */

// an extra activity to show credits.
package com.example.quizgame_sedrakb1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class menu extends Activity {
    ImageView backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        backToMain = (ImageView) findViewById(R.id.takeourquiz);


        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnToMain = new Intent(menu.this, MainActivity.class);
                startActivity(returnToMain);
            }
        });

    }
}

// end by Bichoy Sedrak

