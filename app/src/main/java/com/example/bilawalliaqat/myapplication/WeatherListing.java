package com.example.bilawalliaqat.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherListing extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private String TAG = WeatherListing.class.getSimpleName();
    ArrayList<Weather> weatherList = new ArrayList<Weather>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_listing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.weatherList);

        Button getButton = findViewById(R.id.getButton);

                getButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getWeatherAPIresponse();

                    }
                });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    private void addWeatherListener(ListView listView , ArrayList<Weather>  list){
          WeatherListAdopter listAdopter = new WeatherListAdopter(this , list);
        listView.setAdapter(listAdopter);
        listView.setOnItemClickListener(this);
    }

    private void getWeatherAPIresponse(){


        // Tag used to cancel the request
        String tag_json_arry = "json_array_req";

        String url = "http://samples.openweathermap.org/data/2.5/forecast?zip=94040&appid=b6907d289e10d714a6e88b30761fae22";


        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray list =  response.getJSONArray("list");

                            for (int i=0 ; i < list.length() ; i++) {
                                JSONObject obj = list.getJSONObject(i);
                              JSONObject  mainObj = obj.getJSONObject("main");
                              JSONArray weatherArray = obj.getJSONArray("weather");
                              JSONObject weatherObj = weatherArray.getJSONObject(0);
                                Weather weather = new Weather(weatherObj.getString("main") ,
                                weatherObj.getString("description") ,
                                        weatherObj.getString("icon"), mainObj.getDouble("temp") ,
                                  mainObj.getDouble("pressure") , mainObj.getDouble("humidity"));
                                weatherList.add(weather);
                            }

                            addWeatherListener(listView , weatherList);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.d(TAG, response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

}




class WeatherListAdopter extends BaseAdapter {


    ArrayList<Weather> weatherList ;


    Context context ;

    WeatherListAdopter(Context c , ArrayList<Weather> list){

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

        Weather weather = weatherList.get(position);

        weatherTitle.setText((CharSequence) weather.main);
        desciption.setText((CharSequence) weather.description);
        String url = "http://openweathermap.org/img/w/" + weather.icon+".png";
        Picasso.with(context)
                .load(url)
                .fit()
                .into(weatherIcon);

        return  row;
    }


}





class Weather implements Parcelable {

    String  main , description , icon ;
    Double temp , pressure , humidity;

    public Weather(String main, String description, String icon, Double temp, Double pressure, Double humidity) {
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    protected Weather(Parcel in) {
        main = in.readString();
        description = in.readString();
        icon = in.readString();
        if (in.readByte() == 0) {
            temp = null;
        } else {
            temp = in.readDouble();
        }
        if (in.readByte() == 0) {
            pressure = null;
        } else {
            pressure = in.readDouble();
        }
        if (in.readByte() == 0) {
            humidity = null;
        } else {
            humidity = in.readDouble();
        }
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(main);
        dest.writeString(description);
        dest.writeString(icon);
        if (temp == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(temp);
        }
        if (pressure == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(pressure);
        }
        if (humidity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(humidity);
        }
    }
}
