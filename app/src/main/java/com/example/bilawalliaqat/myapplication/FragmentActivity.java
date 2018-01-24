package com.example.bilawalliaqat.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.FragmentManager;
import android.app.FragmentTransaction;


public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String HOME_ACTIVITY_TAG = FragmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLog("Activity Created");


        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button buttonOne = findViewById(R.id.buttonOne);
        Button buttonTwo = findViewById(R.id.buttonTwo);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);



    }
    @Override

    protected void onRestart(){

        super.onRestart();//call to restart after onStop

        showLog("Activity restarted");

    }

    @Override

    protected void onStart() {

        super.onStart();//soon be visible

        showLog("Activity started");

    }

    @Override

    protected void onResume() {

        super.onResume();//visible

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();//invisible

        showLog("Activity paused");

    }

    @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }



    @Override
    public void onClick(View v) {
    Fragment fragment;
    FragmentManager fm  = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();

        if (v == findViewById(R.id.buttonOne)) {
            fragment = new FirstFragment();
        }

        else   {
            fragment = new SecondFragment();
        }

        ft.replace(R.id.fragmentShow , fragment);
        ft.commit();

    }



    private void showLog(String text){

        Log.e(HOME_ACTIVITY_TAG, text);

    }

}
