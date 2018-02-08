package com.example.bilawalliaqat.myapplication.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bilawalliaqat on 08/02/2018.
 */

public class Weather implements Parcelable {

    public String  main;
    public String description;
    public String icon ;
    public Double temp;
    public Double pressure;
    public Double humidity;

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
