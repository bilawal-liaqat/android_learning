package com.example.bilawalliaqat.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bilawalliaqat.myapplication.Models.Weather;
import com.example.bilawalliaqat.myapplication.R;
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
            toolbar.setTitle((CharSequence) weather.main);
            WeatherDetail.this.setTitle(weather.main);

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
