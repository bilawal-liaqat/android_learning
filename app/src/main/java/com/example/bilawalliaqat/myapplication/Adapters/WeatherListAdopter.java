package com.example.bilawalliaqat.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bilawalliaqat.myapplication.Models.Weather;
import com.example.bilawalliaqat.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by bilawalliaqat on 08/02/2018.
 */

public class WeatherListAdopter extends BaseAdapter {


    ArrayList<Weather> weatherList ;


    Context context ;

    public  WeatherListAdopter(Context c , ArrayList<Weather> list){

        context = c ;
        this.weatherList = list;

    }



    @Override
    public int getCount() {
        return weatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row== null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.fragment_weather , parent , false);
        }

        ImageView weatherIcon = row.findViewById(R.id.weatherIcon);
        TextView weatherTitle = row.findViewById(R.id.main);
        TextView desciption = row.findViewById(R.id.desciption);
        RelativeLayout mainLayout = row.findViewById(R.id.rl_main);

        Weather weather = weatherList.get(position);

        weatherTitle.setText((CharSequence) weather.main);
        desciption.setText((CharSequence) weather.description);
        String url = "http://openweathermap.org/img/w/" + weather.icon+".png";
        Picasso.with(context)
                .load(url)
                .fit()
                .into(weatherIcon);

//        mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
//            }
//        });

        return  row;
    }


}