package com.example.supportorphans;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
        final EditText etRegno = findViewById(R.id.regno);
        final Spinner etUser = findViewById(R.id.user);


        Button btn = findViewById(R.id.signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etName.getText().toString();
                String password = etPassword.getText().toString();
                String mobile = etMobile.getText().toString();
                String address = etAddress.getText().toString();
                String email = etEmail.getText().toString();
                String user = etUser.getSelectedItem().toString();

                RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setName(username);
                registerRequest.setPassword(password);
                registerRequest.setMobile(mobile);
                registerRequest.setAddress(address);
                registerRequest.setEmail(email);
                registerRequest.setTypeuser(user);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.48.35/Mocktest/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                APIService service = retrofit.create(APIService.class);

                Call<RegisterResponse> registerResponse = service.register(registerRequest);
                registerResponse.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<RegisterResponse> call, @NonNull Response<RegisterResponse> response) {
                        if (response.body() != null && response.body().getStatus()) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<RegisterResponse> call, Throwable t) {
                        Log.e("RegisterActivity", t.getMessage().toString());
                        //Toast.makeText(getApplicationContext(), "API Call Failure", Toast.LENGTH_LONG).show();
                    }
                });
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
*/

              /*  RegisterRequest registerRequest = new RegisterRequest();
                registerRequest.setuName(username);
                registerRequest.setuPassword(password);

                Retrofit retrofit = new Retrofit().newBuilder();
            }
        });*/

                // public void processSigninLinkClick(View view) {
                // Intent intent = new Intent(this, LoginActivity.class);
                // startActivity(intent);
                /*Button btn4 = findViewById(R.id.signup);


                btn4.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        //System.out.println("Button Clicked");

                        Intent activity4Intent = new Intent(getApplicationContext(), ItemsActivity.class);
                        startActivity(activity4Intent);

                    }

                });*/
            }
        });
    }
}