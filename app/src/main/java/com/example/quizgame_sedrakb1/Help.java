/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */

// the help class for the screeb that explains the game before it starts.
package com.example.quizgame_sedrakb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Help extends AppCompatActivity {
    Button Start, back;
    TextView Userinfo;

// linking everything with the Activity_layout.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Start = (Button) findViewById(R.id.Start);
        back = (Button) findViewById(R.id.back);
        Userinfo = (TextView) findViewById(R.id.user_info);

        // getting the user name info from the Move intent inside the Main Activity Class.
        String ID = getIntent().getStringExtra("Key1");

        // setting up the welcome message to show for the user after signing in.
        Userinfo.setText("Welcome " + ID + " !");

        // setting up the start button to start the game.
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Help.this, Homescreen.class);
                startActivity(startGame);

                // creating another intent to User name to the next activity
                Intent Move = new Intent(Help.this, Homescreen.class);
                Move.putExtra("Key1", ID);
                startActivity(Move);
            }
        });
        // setting up a back button to sign out and back to the previous screen.
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Help.this, "You are logged out!", Toast.LENGTH_SHORT).show();
                Intent backToMain = new Intent(Help.this, MainActivity.class);
                startActivity(backToMain);
            }
        });
    }
}

// end of this class by Bichoy Sedrak