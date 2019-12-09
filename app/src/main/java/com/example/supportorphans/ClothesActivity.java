package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ClothesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Button btnadd = findViewById(R.id.addcloth);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity2Intent);
            }

        });
    }
}