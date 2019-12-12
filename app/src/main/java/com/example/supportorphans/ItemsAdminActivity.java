package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class ItemsAdminActivity extends AppCompatActivity {
    private Spinner spinner1;

    //private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminitems);

        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity1Intent = new Intent(getApplicationContext(), OrphanageActivity.class);
                startActivity(activity1Intent);
            }
        });
        Button buttonOne = findViewById(R.id.btncloth);
        buttonOne.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), ClothesActivity.class);
                startActivity(activity2Intent);
            }

        });
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
        //addItemsOnSpinner2();
        // addListenerOnButton();
        // addListenerOnSpinnerItemSelection();

    }
}
