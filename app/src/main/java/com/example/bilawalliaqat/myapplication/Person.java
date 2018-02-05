package com.example.bilawalliaqat.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bilawalliaqat on 24/01/2018.
 */

class Person  implements Parcelable {

    String firstName, lastName , email ;


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
