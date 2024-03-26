package com.example.intertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class skak_activity extends AppCompatActivity implements SensorEventListener {
    private static final double SHAKE_THRESHOLD = 20.0;
    private SensorManager sensorManager;
    private Sensor accelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skak);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Kollar om sensor typen är accelerometer
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Hämtar accelerometer värdena
            float x = event.values[0];
            float y = event.values[1];

            double acceleration = Math.sqrt(x * x + y * y);


            if(acceleration > SHAKE_THRESHOLD){
                View view = findViewById(R.id.activity_skak); // Replace main_layout with your root layout id
                view.setBackgroundColor(Color.GREEN);
            }
        }
    }

    public void launchHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}