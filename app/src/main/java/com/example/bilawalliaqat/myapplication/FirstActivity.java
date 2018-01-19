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
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button nextButton  = findViewById(R.id.buttonNext);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == RESULT_OK){
                String returnString = data.getStringExtra("name");
                EditText editText = (EditText) findViewById(R.id.textName);
                   editText.setText(returnString);

            }
            else { // Result code cancelled


            }


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText) findViewById(R.id.textName);
        String message = editText.getText().toString();
        intent.putExtra("name", message);
       // startActivity(intent);
        startActivityForResult(intent , 1);


    }

}
