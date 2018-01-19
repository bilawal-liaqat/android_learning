package com.example.bilawalliaqat.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etFirstName,etLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        Button backButton = findViewById(R.id.buttonBack);
        Intent intent = getIntent();
        if(intent.getExtras() != null){
           Person person = (Person) intent.getExtras().getParcelable("person");
            etFirstName.setText(person.firstName);
            etLastName.setText( person.lastName);
        }



        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, FirstActivity.class);
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        Person person = new Person(firstName, lastName);

        intent.putExtra("person", person);
        setResult(RESULT_OK, intent);
        finish();

    }
}
