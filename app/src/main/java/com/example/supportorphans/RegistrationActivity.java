package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supportorphans.pojo.RegisterRequest;

import retrofit2.Retrofit;

public class RegistrationActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

       /* final EditText etName = findViewById(R.id.loginName);
       final  EditText etPassword = findViewById(R.id.password);
         Button btn = findViewById(R.id.signup);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String username = etName.getText().toString();
                 String password = etPassword.getText().toString();
                 RegisterRequest registerRequest = new RegisterRequest();
                 registerRequest.setuName(username);
                 registerRequest.setuPassword(password);

                 Retrofit retrofit = new Retrofit().newBuilder();
             }
         });*/

        // public void processSigninLinkClick(View view) {
        // Intent intent = new Intent(this, LoginActivity.class);
        // startActivity(intent);
        Button btn4 = findViewById(R.id.signup);


        btn4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //System.out.println("Button Clicked");

                Intent activity4Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                startActivity(activity4Intent);

            }

        });
    }
}