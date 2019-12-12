package com.example.supportorphans;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class ClothesActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);
        Button btncloth = findViewById(R.id.addcloth);
        btncloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity2Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity2Intent);
            }


        });


    }
}


