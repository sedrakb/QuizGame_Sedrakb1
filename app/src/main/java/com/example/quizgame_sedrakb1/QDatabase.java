/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating a real quiz game
 */

// the DatabaseHelper class that hold all database values and
package com.example.quizgame_sedrakb1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QDatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public QDatabase(Context context) {

        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Quizdb) {
        Quizdb.execSQL("create Table users (email Text primary key, password TEXT, firstname TEXT) /*, firstname TEXT, lastname TEXT, String dob)*/");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Quizdb, int i, int i1) {
        Quizdb.execSQL("drop Table if exists users");
    }
// the insert data method.
    public Boolean insertData (String firstname, String email, String password) /*, String firstname, String lastname, String dob )*/{
        SQLiteDatabase Quizdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put ("First Name", firstname);
       // contentValues.put ("Last Name", lastname);
        contentValues.put ("Email", email);
      //  contentValues.put ("dob", dob);
        contentValues.put ("Password", password);
        long result = Quizdb.insert("users", null, contentValues);
        //if the insertion is not possible it should return false (-1) indicates failure
        if (result == -1) return false;
        else
            return true;
    }
    //check First name method
   public Boolean checkFname (String firstname){
        SQLiteDatabase Quizdb = this.getWritableDatabase();
        Cursor cursor = Quizdb.rawQuery("Select * from users where email = ?", new String[] {firstname});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    // check email method
    public Boolean checkEmail (String email) {
        SQLiteDatabase Quizdb = this.getWritableDatabase();
        Cursor cursor = Quizdb.rawQuery("Select * from users where email = ?", new String [] {email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

// check password method
    public Boolean checkpassword(String email, String password) {
        SQLiteDatabase Quizdb = this.getWritableDatabase();
        Cursor cursor = Quizdb.rawQuery("Select * from users where email = ? and password = ?", new String[] {email, password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

}

// end by Bichoy Sedrak