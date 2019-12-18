package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ItemsActivity extends AppCompatActivity {
    /* AdapterView.OnItemSelectedListener

     {
         String[] orphanage = {"Sree Chithra Poor Home", "Santhwana", "Snehalayam"};
     }*/
    private Spinner theSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);


        Button buttonTwo = findViewById(R.id.button2);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity3Intent = new Intent(getApplicationContext(), FoodActivity.class);
                startActivity(activity3Intent);
            }
        });
        Button buttonThree = findViewById(R.id.button3);
        buttonThree.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent activity1Intent = new Intent(getApplicationContext(), ToyActivity.class);
                startActivity(activity1Intent);
            }
        });

        Button buttonOne = findViewById(R.id.btncloth);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), ClothesActivity.class);
                startActivity(activity2Intent);
                System.out.println("Button Clicked");
            }
        });


        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // SpinnerAdapter spinnerArrayAdapter;
        /*spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelectedListener(AdapterView<?> parent, View view, int position, long id) {
               Object o = theSpinner.getItemAtPosition(position);
                Intent activity3Intent = new Intent(view.getContext(), ItemsViewActivity.class);
                startActivity(activity3Intent);

            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            Intent activity3Intent = new Intent(getApplicationContext(), ItemsViewActivity.class);
            startActivity(activity3Intent);
            }
        });
    }*/
    }
}



