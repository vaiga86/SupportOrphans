package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ToyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy);
        Button btntoy = findViewById(R.id.addtoy);
        btntoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity2Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity2Intent);
            }
        });

        Button btnty = findViewById(R.id.backtoy);
        btnty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actityIntent1 = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(actityIntent1);
            }

        });
    }
}