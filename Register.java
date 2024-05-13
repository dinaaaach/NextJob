package com.example.nextjobnj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword, ConfirPass;
    private TextView LogIn;
    private Button etSignUp;
    private DatabaseReference database;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        ConfirPass = findViewById(R.id.ConfirPass);
        etSignUp = findViewById(R.id.etSignUp);
        LogIn = findViewById(R.id.LogIn);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nextjob-ba1ad-default-rtdb.firebaseio.com/");

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(), Login.class);
                startActivity(login);
            }
        });

        etSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirpass = ConfirPass.getText().toString();

                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirpass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                }else{
                    database = FirebaseDatabase.getInstance().getReference("users");
                    database.child(username).child("user").setValue(username);
                    database.child(email).child("email").setValue(email);
                    database.child(password).child("password").setValue(password);
                    database.child(confirpass).child("confirpass").setValue(confirpass);

                    Toast.makeText(getApplicationContext(), "Register Berhasil", Toast.LENGTH_SHORT).show();
                    Intent register = new Intent(getApplicationContext(), com.example.nextjobnj.Login.class);
                    startActivity(register);
                }
            }
        });

    }
}
