/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */

// Main Activity Class to log in or to go to the register screen.

package com.example.quizgame_sedrakb1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EnterEmail, EnterPassword;
    Button Login;
    TextView Register;
    QDatabase Quizdb;
    ImageView Menu;

// linking all views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EnterEmail = (EditText) findViewById(R.id.enteremail);
        EnterPassword = (EditText) findViewById(R.id.password_toggle);
        Login = (Button) findViewById(R.id.login);
        Register = (TextView) findViewById(R.id.register);
        Menu = (ImageView) findViewById(R.id.menu);
        Quizdb = new QDatabase(this);

// the login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = EnterEmail.getText().toString();
                String Password = EnterPassword.getText().toString();

                if (Email.equals("") || Password.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter your credentials!", Toast.LENGTH_LONG).show();
                else {
                    Boolean checkuserpass = Quizdb.checkpassword(Email, Password);
                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                        Intent goToHome = new Intent(MainActivity.this, Help.class);
                        startActivity(goToHome);
                        // creating another intent to User name to the next activity
                        Intent Move = new Intent(MainActivity.this, Help.class);
                        Move.putExtra("Key1", Email);
                        startActivity(Move);

                    }// if user name and password doesnt match will restore values
                    else {
                        Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

// the register button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(MainActivity.this, Register.class);
                startActivity(goToRegister);
            }
        });

// a menu button for credits.
        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoCredits = new Intent(MainActivity.this, menu.class);
                startActivity(gotoCredits);
            }
        });

        }
    }
// end by Bichoy Sedrak