package com.example.bilawalliaqat.myapplication.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bilawalliaqat.myapplication.Fragments.FirstFragment;
import com.example.bilawalliaqat.myapplication.Models.Person;
import com.example.bilawalliaqat.myapplication.R;
import com.example.bilawalliaqat.myapplication.Adapters.ListAdopter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<Person> personList = new ArrayList<Person>();

    private void addList(){
        personList.add(new Person("Bilal", "Mushtaq"));
        personList.add(new Person("Ali", "Hamza"));
        personList.add(new Person("Usman", "Tarrar"));
        personList.add(new Person("Ghulam", "Mujtaba"));
        personList.add(new Person("Jaffar", "Raza"));
        personList.add(new Person("Ahsan", "Hameed"));
        personList.add(new Person("Ahmad", "Akhtar"));
        personList.add(new Person("Umar", "Akbar"));
        personList.add(new Person("Bilal", "Ahmed"));
        personList.add(new Person("Ejaz", "Ehmad"));
        personList.add(new Person("Bilal", "Mushtaq"));
        personList.add(new Person("Ali", "Hamza"));
        personList.add(new Person("Usman", "Tarrar"));
        personList.add(new Person("Ghulam", "Mujtaba"));
        personList.add(new Person("Jaffar", "Raza"));
        personList.add(new Person("Ahsan", "Hameed"));
        personList.add(new Person("Ahmad", "Akhtar"));
        personList.add(new Person("Umar", "Akbar"));
        personList.add(new Person("Bilal", "Ahmed"));
        personList.add(new Person("Ejaz", "Ehmad"));
        personList.add(new Person("Bilal", "Mushtaq"));
        personList.add(new Person("Ali", "Hamza"));
        personList.add(new Person("Usman", "Tarrar"));
        personList.add(new Person("Ghulam", "Mujtaba"));
        personList.add(new Person("Jaffar", "Raza"));
        personList.add(new Person("Ahsan", "Hameed"));
        personList.add(new Person("Ahmad", "Akhtar"));
        personList.add(new Person("Umar", "Akbar"));
        personList.add(new Person("Bilal", "Ahmed"));
        personList.add(new Person("Ejaz", "Ehmad"));
        personList.add(new Person("Bilal", "Mushtaq"));
        personList.add(new Person("Ali", "Hamza"));
        personList.add(new Person("Usman", "Tarrar"));
        personList.add(new Person("Ghulam", "Mujtaba"));
        personList.add(new Person("Jaffar", "Raza"));
        personList.add(new Person("Ahsan", "Hameed"));
        personList.add(new Person("Ahmad", "Akhtar"));
        personList.add(new Person("Umar", "Akbar"));
        personList.add(new Person("Bilal", "Ahmed"));
        personList.add(new Person("Ejaz", "Ehmad"));

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView list = findViewById(R.id.listView);
        addList();
        ListAdopter listAdopter = new ListAdopter(this , personList);
        list.setAdapter(listAdopter);
        list.setOnItemClickListener(this);
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person person = personList.get(position);
      //  Toast.makeText(this, person.firstName, Toast.LENGTH_SHORT).show();

        FragmentManager fm  = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment  fragment = new FirstFragment();

        //ft.replace(R.id.fragmentShow , fragment);
//        fragment.setPerson(person);

        Bundle bundle = new Bundle();
        bundle.putParcelable("person" , person);
        fragment.setArguments(bundle);



        ft.add(R.id.containerBox , fragment);
        ft.addToBackStack("OK");
        ft.commit();



    }
}


