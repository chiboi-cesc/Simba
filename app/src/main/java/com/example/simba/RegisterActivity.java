package com.example.simba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username,password,email,phone;
    RadioGroup gender;
    Button register, cancel;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        preferences =getSharedPreferences("Userinfo",0);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamevalue = username.getText().toString();
                String passwordvalue = password.getText().toString();
                String emailvalue = email.getText().toString();
                String phonevalue = phone.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String gendervalue = checkedBtn.getText().toString();


                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("username", usernamevalue);
                editor.putString("password", passwordvalue);
                editor.putString("email", emailvalue);
                editor.putString("phone", phonevalue);
                editor.putString("gender", gendervalue);
                editor.apply();

                if(TextUtils.isEmpty(usernamevalue) || TextUtils.isEmpty(passwordvalue) || TextUtils.isEmpty(emailvalue) || TextUtils.isEmpty(phonevalue)){
                    Toast.makeText(RegisterActivity.this, "One field is empty", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                }
            }



        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyfield();

            }
        });

    }

    public void emptyfield(){
        username.setText("");
        password.setText("");
        email.setText("");
        phone.setText("");
    }
}
