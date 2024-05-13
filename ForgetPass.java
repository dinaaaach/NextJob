package com.example.nextjobnj;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ForgetPass extends AppCompatActivity {

    private EditText etEmail, etPassword, ConfirPass;
    private Button etResetPassword;
    private DatabaseReference database;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        ConfirPass = findViewById(R.id.ConfirPass);
        etResetPassword = findViewById(R.id.etResetPassword);


        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://nextjob-ba1ad-default-rtdb.firebaseio.com/");

        etResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirpass = ConfirPass.getText().toString();

                if (email.isEmpty() || password.isEmpty() || confirpass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada Data Yang Masih Kosong!!", Toast.LENGTH_SHORT).show();
                }else{
                    class User {
                        private String email;
                        private String password;

                        // Constructor
                        public User(String email, String password) {
                            this.email = email;
                            this.password = password;
                        }

                        // Getter and setter methods
                        public String getEmail() {
                            return email;
                        }

                        public void setEmail(String email) {
                            this.email = email;
                        }

                        public String getPassword() {
                            return password;
                        }

                        public void setPassword(String password) {
                            this.password = password;
                        }

                        {Toast.makeText(getApplicationContext(), "Password Berhasil Diganti", Toast.LENGTH_SHORT).show();
                        Intent forgetpass = new Intent(getApplicationContext(), Login.class);
                        startActivity(forgetpass); }
                    }


                }

            }
        });

    }
}
