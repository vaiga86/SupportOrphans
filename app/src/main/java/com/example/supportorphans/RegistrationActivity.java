package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EditText etName = findViewById(R.id.loginName);

        // public void processSigninLinkClick(View view) {
        // Intent intent = new Intent(this, LoginActivity.class);
        // startActivity(intent);
        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //System.out.println("Button Clicked");

                Intent activity4Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity4Intent);

            }

        });
    }
}