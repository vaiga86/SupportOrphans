package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import androidx.appcompat.app.AppCompatActivity;


public class ItemsActivity extends AppCompatActivity {

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
    }
}
