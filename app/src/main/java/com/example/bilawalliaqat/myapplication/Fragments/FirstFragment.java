package com.example.bilawalliaqat.myapplication.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bilawalliaqat.myapplication.Models.Person;
import com.example.bilawalliaqat.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

   // Person person;
    TextView firstName, lastName;





    public void setPerson(View view , Person person){
        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);

        firstName.setText(person.firstName);
         lastName.setText( person.lastName);
     }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view  = inflater.inflate(R.layout.fragment_first, container, false);

        Person person  = (Person) getArguments().getParcelable("person");
         setPerson(view , person);
     return  view;

     }

}
