package com.example.bilawalliaqat.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = findViewById(R.id.listView);
        ListAdopter listAdopter = new ListAdopter(this);
        list.setAdapter(listAdopter);


    }

}


class ListAdopter extends BaseAdapter {


    String names[] = {
            "India",
            "China",
            "australia",
            "Portugle", "America",
            "NewZealand",
            "India",
            "China",
            "australia",
            "Portugle", "America",
            "NewZealand",
            "India",
            "China",
            "australia",
            "Portugle", "America",
            "NewZealand",
            "India",
            "China",
            "australia",
            "Portugle", "America",
            "NewZealand"
    };
    Context context ;

    ListAdopter(Context c){

       context = c ;

    }

    @Override
    public int getCount() {
        return names.length;
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

        TextView textView = row.findViewById(R.id.textView);
        textView.setText(names[position]);

        return  row;
    }
}