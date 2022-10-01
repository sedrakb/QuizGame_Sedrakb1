/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */


// the activity for the register screen.
package com.example.quizgame_sedrakb1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    EditText FirstName, LastName, DOB, Email, Password, Repassword;
    Button BRegister;
    TextView AlreadyUser;
    QDatabase Quizdb;
   // FirebaseAuth mAuth;
   // FirebaseUser mUser;


    // setting up all views.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirstName = (EditText) findViewById(R.id.first_name);
        LastName = (EditText) findViewById(R.id.last_name);
        DOB = (EditText) findViewById(R.id.dob);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Repassword = (EditText) findViewById(R.id.repassword);
        BRegister = (Button) findViewById(R.id.bRegister);
        AlreadyUser = (TextView) findViewById(R.id.alreadyuser);
       // mAuth = FirebaseAuth.getInstance();
       // mUser = mAuth.getCurrentUser();

        Quizdb = new QDatabase(this);
// the register button
        BRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = FirstName.getText().toString();
                String lastname = LastName.getText().toString();
                String dob = DOB.getText().toString();
                String email = Email.getText().toString();
                String pass = Password.getText().toString();
                String repass = Repassword.getText().toString();

                // validating the data is not empty
                if (firstname.equals("") || lastname.equals("") || dob.equals("") || email.equals("") || pass.equals("") || repass.equals(""))

                    // a toast message to validate the data is not empty
                    Toast.makeText(Register.this, "Please fill in all fields!", Toast.LENGTH_LONG).show();
                else {
                    // to validate password is the same, a correct email address format and at least 3 characters for First name.
                    if (validateFirstName(FirstName)){
                        Boolean checkFname = Quizdb.checkFname(firstname);
                    }else {
                        Toast.makeText(Register.this, "Please enter at least 3 characters!", Toast.LENGTH_LONG).show();
                    }
                    if  (validateEmail(Email) )
                    {
                    } else {
                        Toast.makeText(Register.this, "Invalid Email address!", Toast.LENGTH_LONG).show();
                    }
                   if (pass.equals(repass) == true){
                    Boolean checkEmail = Quizdb.checkEmail(email);
                    if (checkEmail == false) {
                        Boolean insert = Quizdb.insertData(firstname, email, pass);
                        if (insert== true) {
                            Toast.makeText(Register.this, "User Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent goTologin = new Intent(Register.this, MainActivity.class);
                            startActivity(goTologin);
                        } else {
                                Toast.makeText(Register.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                            else {
                            Toast.makeText(Register.this, "User already Exists!", Toast.LENGTH_LONG).show();
                    }
                    }else {
                        Toast.makeText(Register.this, "Password not matching!", Toast.LENGTH_LONG).show();
                    }
                }

                //PerforAuth();
            }
        });

    // setting up the link to go back to the login screen if you are already a user.

        AlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goTologin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goTologin);
            }
        });
    }
/*
    private void PerforAuth() {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password). addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                }
            }
        });

    }
*/

    // creating method to validate correct email address format Example: abc@abc.com
    private boolean validateEmail (EditText Email) {
        String emailInput = Email.getText().toString();
        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            return true;
        }else{
            return false;
        }
    }

// creating a method to validate the First name is at least 3 characters
    private boolean validateFirstName (EditText FirstName) {
        String regex = "^.*[a-zA-Z0-9]{3}";
        String fnameInput = FirstName.getText().toString();
        if (!(fnameInput.isEmpty() || !fnameInput.matches((regex)))){
            return true;
        }else {
            return false;
        }

    }
}

// End By Bichoy Sedrak