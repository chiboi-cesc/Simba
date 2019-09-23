package com.example.simba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login, register;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.username);
        password =findViewById(R.id.password);
        login =findViewById(R.id.login);
        register =findViewById(R.id.register);

        preferences =getSharedPreferences("Userinfo",0);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                String registeredUsername = preferences.getString("username", "");
                String registeredPassword = preferences.getString("password", "");


                if (TextUtils.isEmpty(usernameValue) || TextUtils.isEmpty(passwordValue)){
                    Toast.makeText(MainActivity.this, "Username or Password field is empty", Toast.LENGTH_SHORT).show();
                }

                else if (usernameValue.equals(registeredUsername)  && passwordValue.equals(registeredPassword)){

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }


                  else
                        {
                        Toast.makeText(MainActivity.this, "Invalid Username or Password",Toast.LENGTH_SHORT).show();
                    }



            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });



    }
}


