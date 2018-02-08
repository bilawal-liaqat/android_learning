package com.example.bilawalliaqat.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bilawalliaqat on 24/01/2018.
 */

public class Person  implements Parcelable {

    public String firstName;
    public String lastName;
    String email ;


    public Person(String firstName, String lastName){
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
