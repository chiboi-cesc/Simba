package com.example.simba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button logout;

    SharedPreferences preferences;

    TextView username,email,phone,gender;


            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.logout);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);

        preferences =getSharedPreferences("Userinfo",0);

                String usrname = preferences.getString("username", "");
                String uemail = preferences.getString("email", "");
                String uphone = preferences.getString("phone", "");
                String ugender = preferences.getString("gender", "");

                username.setText(usrname);
                email.setText(uemail);
                phone.setText(uphone);
                gender.setText(ugender);


                logout.setOnClickListener(new View.OnClickListener()

                {
                    @Override
                    public void onClick (View view){
                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

    });
}

}
