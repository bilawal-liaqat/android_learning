package com.example.bilawalliaqat.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText etFirstName,etLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button nextButton  = findViewById(R.id.buttonNext);
        etFirstName = (EditText) findViewById(R.id.firstName);
        etLastName = (EditText) findViewById(R.id.lastName);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);

            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

            if (resultCode == RESULT_OK){
                Person person = intent.getParcelableExtra("person");

                etFirstName.setText(person.firstName);
               etLastName.setText( person.lastName);

            }
            else { // Result code cancelled


            }


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        Person person = new Person(firstName, lastName);

        intent.putExtra("person", person);
       // startActivity(intent);
        startActivityForResult(intent , 1);


    }

}




class Person  implements Parcelable{

    String firstName, lastName  ;


    Person(String firstName, String lastName ){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}

