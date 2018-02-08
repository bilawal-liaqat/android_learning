package com.example.bilawalliaqat.myapplication.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.bilawalliaqat.myapplication.App.AppController;
import com.example.bilawalliaqat.myapplication.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.*;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import com.example.bilawalliaqat.myapplication.util.GPSTracker;
import com.example.bilawalliaqat.myapplication.Models.Weather;


public class WeatherListing extends AppCompatActivity  implements AdapterView.OnItemClickListener{

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    private String TAG = WeatherListing.class.getSimpleName();
    ArrayList<Weather> weatherList = new ArrayList<Weather>();
    ListView listView;

    // GPSTracker class
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_listing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       listView = findViewById(R.id.weatherList);
//    Button searchButton = findViewById(R.id.serach_button);
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        googleLocationAutoComplete();
        setCurrentLocation();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //getWeatherAPIresponse();

    }

    private void setCurrentLocation(){
        gps = new GPSTracker(WeatherListing.this);

        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            getWeatherAPIresponse(latitude , longitude);
            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

    }

    private void googleLocationAutoComplete(){
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());

                getWeatherAPIresponse(place.getLatLng().latitude , place.getLatLng().longitude);
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, WeatherDetail.class);

        intent.putExtra("weather", weatherList.get(position));
         startActivity(intent);
        //startActivityForResult(intent , 1);
    }


   private void addWeatherListener(ListView listView , ArrayList<Weather>  list){
          WeatherListAdopter listAdopter = new WeatherListAdopter(this , list);
        listView.setAdapter(listAdopter);
        listView.setOnItemClickListener(this);
    }

    private void getWeatherAPIresponse(double lat , double lon){


        // Tag used to cancel the request
        String tag_json_arry = "json_array_req";

        String url = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&units=imperial&appid=94d1fb1d44e840644d347629c5de982a";
            Log.e(TAG , url);
        weatherList.clear();

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










