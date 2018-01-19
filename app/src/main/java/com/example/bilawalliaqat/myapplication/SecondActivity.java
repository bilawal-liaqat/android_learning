package com.example.bilawalliaqat.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String s = getIntent().getStringExtra("name");
        EditText editText = findViewById(R.id.textNameSecond);
        editText.setText(s);
        Button backButton = findViewById(R.id.buttonBack);

                backButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        EditText editText = (EditText) findViewById(R.id.textNameSecond);
        String message = editText.getText().toString();
        intent.putExtra("name", message);
        setResult(RESULT_OK, intent);
        finish();

    }
}
