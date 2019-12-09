package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         }
     public void processSignupLinkClick(View view){
         Intent intent = new Intent(  this,RegistrationActivity.class);
         startActivity(intent);

     }
}