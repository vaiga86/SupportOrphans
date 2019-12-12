package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ClothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Button btnfood = findViewById(R.id.btncloth);
        btnfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity2Intent);
            }

        });


    }
}