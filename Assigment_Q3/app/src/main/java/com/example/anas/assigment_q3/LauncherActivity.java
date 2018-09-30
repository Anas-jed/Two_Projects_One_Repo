package com.example.anas.assigment_q3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class LauncherActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        //call to OnCreate Method
        super.onCreate(savedInstanceState);

        //setting view
        setContentView(R.layout.activity_launcher);

        //special code for 5 second wait activity
        new Timer().schedule(new TimerTask(){
            public void run() {
                //start login activity after 5 seconds
                startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
                finish();

                Log.d("MyTag:", "onCreate: waiting 5 seconds for LauncherActivity... loading LoginActivity.class");
            }
        }, 5000 );
    }

    }

