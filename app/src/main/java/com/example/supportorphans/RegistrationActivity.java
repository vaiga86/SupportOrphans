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
        //final EditText etRegno = findViewById(R.id.regno);
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

                Toast toast = Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG);
// to show the toast
                toast.show();
                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setName(name);
                registerRequest.setPassword(password);
                registerRequest.setMobile(mobile);
                registerRequest.setAddress(address);
                registerRequest.setEmail(email);
                registerRequest.setTypeuser(userType);

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
                        Toast.makeText(getApplicationContext(), "API Call Failure", Toast.LENGTH_LONG).show();
                    }
                });

/* RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setuName(username);
                registerRequest.setuPassword(password);

                Retrofit retrofit = new Retrofit().newBuilder();
            }
        });*/
                /*final String reg = etRegno.getText().toString();
                etUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        if (user=="Admin") {
                            etRegno.setVisibility(View.VISIBLE);

                        } else {
                            etRegno.setVisibility(View.INVISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        //
                    }
                });
                  public void processSigninLinkClick(View view) {
                 Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);


            }*/


            }

        });
    }
}