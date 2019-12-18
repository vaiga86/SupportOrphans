package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.supportorphans.pojo.LoginRequest;
import com.example.supportorphans.pojo.LoginResponse;
import com.example.supportorphans.ws.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etName = findViewById(R.id.loginName);
        final EditText etPassword = findViewById(R.id.password);

        Button btn = findViewById(R.id.loginid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setName(name);
                loginRequest.setPassword(password);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://backtowork.icfoss.qleapbs.com/orphans/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                Call<LoginResponse> call = service.login(loginRequest);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if (response.body() != null && response.body().getStatus()) {
                            Toast.makeText(getApplicationContext(), "API Call success", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), ItemsActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("RegisterActivity", t.getMessage().toString());
                        Toast.makeText(getApplicationContext(), "API Call Failure" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }

        });
    }


    public void processSignup(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);

    }
}