package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supportorphans.pojo.RegisterRequest;
import com.example.supportorphans.pojo.RegisterResponse;
import com.example.supportorphans.ws.APIService;

//import retrofit2.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.Retrofit;


public class RegistrationActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final EditText etName = findViewById(R.id.loginName);
        final EditText etPassword = findViewById(R.id.password);
        final EditText etMobile = findViewById(R.id.mobile);
        final EditText etAddress = findViewById(R.id.address);
        final EditText etEmail = findViewById(R.id.email);
        final Spinner etUser = findViewById(R.id.user);


        Button btn = findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                String mobile = etMobile.getText().toString();
                String address = etAddress.getText().toString();
                String email = etEmail.getText().toString();
                String userType = etUser.getSelectedItem().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setName(name);
                registerRequest.setPassword(password);
                registerRequest.setEmail(email);
                registerRequest.setUserType(userType);
                registerRequest.setAddress(address);
                registerRequest.setMobNo(mobile);


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://backtowork.icfoss.qleapbs.com/orphans/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                Call<RegisterResponse> call = service.register(registerRequest);
                call.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.body() != null && response.body().getStatus()) {
                            Toast.makeText(getApplicationContext(), "API Call success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Log.e("RegisterActivity", t.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "API Call Failure" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }

    public void processSigninLinkClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}