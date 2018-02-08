package com.example.bilawalliaqat.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bilawalliaqat.myapplication.Models.Person;
import com.example.bilawalliaqat.myapplication.R;

import java.util.ArrayList;

/**
 * Created by bilawalliaqat on 08/02/2018.
 */

public class ListAdopter extends BaseAdapter {


    ArrayList<Person> personList ;


    Context context ;

    public ListAdopter(Context c, ArrayList<Person> list){

        context = c ;
        this.personList = list;

    }



    @Override
    public int getCount() {
        return personList.size();
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
            row = inflater.inflate(R.layout.content_list , parent , false);
        }

        TextView firstName = row.findViewById(R.id.firstName);
        TextView lastName = row.findViewById(R.id.lastName);

        Person person = personList.get(position);

        firstName.setText((CharSequence) person.firstName);
        lastName.setText((CharSequence) person.lastName);

        return  row;
    }


}