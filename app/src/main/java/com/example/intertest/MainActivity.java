package com.example.intertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void launchSkak(View v){
        Intent i = new Intent(this, skak_activity.class);
        startActivity(i);
    }

    public void launchOppna(View v){
        Intent i = new Intent(this, open_activity.class);
        startActivity(i);
    }

    public void launchVrida(View v){
        Intent i = new Intent(this, vrid_activity.class);
        startActivity(i);
    }
}