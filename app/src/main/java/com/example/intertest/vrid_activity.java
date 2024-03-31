package com.example.intertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;


public class vrid_activity extends AppCompatActivity implements SensorEventListener{


    private SensorManager sensorManager;
    private Sensor gyroscope;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vrid);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

    }

    public void launchHome(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float z = event.values[1];

        float y = event.values[2];

        if(z < -4 || z> 4) {
            Toast.makeText(getApplicationContext(), "The turn of the screw", Toast.LENGTH_SHORT).show();
            //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
              //  vibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
          //  }
        }
        if(y < -3 || y> 3) {
            Toast.makeText(getApplicationContext(), "Timber!", Toast.LENGTH_SHORT).show();
           // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //    vibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
           // }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }
}

