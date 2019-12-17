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

      /* theSpinner = (Spinner) findViewById(R.id.orphanage);
        final Spinner spinner = (Spinner) findViewById(R.id.orphanage);

        // Initializing a String Array
        String[] plants = new String[]{
                "Laceflower",
                "California sycamore",
                "Mountain mahogany",
                "Butterfly weed",
                "Carrot weed"
        };

        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.activity_itemview,plantsList) {
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                Intent activity3Intent = new Intent(getApplicationContext(), ItemsViewActivity.class);
                startActivity(activity3Intent);
                System.out.println("Button Clicked");

            }

        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.activity_itemview);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                Toast.makeText
                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
    }
}



