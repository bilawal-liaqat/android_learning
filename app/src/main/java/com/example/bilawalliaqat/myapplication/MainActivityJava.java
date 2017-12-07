package com.example.bilawalliaqat.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by bilawalliaqat on 06/12/2017.
 */

public class MainActivityJava extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);
        final ProgressBar progressbar = (ProgressBar) findViewById(R.id.progressBar);

        seekbar.setMax(100);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progressbar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }



    private void getMessage(){

        Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show();
    }




}
