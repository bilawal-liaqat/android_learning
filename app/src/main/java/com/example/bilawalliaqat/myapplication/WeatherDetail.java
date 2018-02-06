package com.example.bilawalliaqat.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class WeatherDetail extends AppCompatActivity {



    ImageView weatherIcon ;
    TextView description , humidity , pressure, temprature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        weatherIcon = findViewById(R.id.weatherIcon);
        description = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);
        temprature = findViewById(R.id.tempWeather);



        Intent intent = getIntent();

        if(intent.getExtras() != null){
            Weather weather = (Weather) intent.getExtras().getParcelable("weather");

            description.setText(weather.description);
            humidity.setText("Humidity: " + weather.humidity.intValue() + "%");
            pressure.setText("Pressure: "  +weather.pressure.intValue() + " hPa");
            temprature.setText(weather.temp.intValue() + " °C");

            String url = "http://openweathermap.org/img/w/" + weather.icon+".png";
            Picasso.with(this)
                    .load(url)
                    .fit()
                    .into(weatherIcon);
        }

    }

}
