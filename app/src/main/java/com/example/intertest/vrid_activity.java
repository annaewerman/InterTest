package com.example.intertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class vrid_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrid);
    }

    public void launchHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}