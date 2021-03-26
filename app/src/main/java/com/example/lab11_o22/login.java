package com.example.lab11_o22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    // step 1 : Declaration des elements
    EditText etLogin,etPassword;
    Button bLogin;
    TextView tvRegister;
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(getApplicationContext(),"unknown user",Toast.LENGTH_SHORT).show();

        }
    }
    //une activité doit avoir en minimum une method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // c'est une methode permetant d'associer un view a un controller
        setContentView(R.layout.activity_logo);
        //etape 2: recuparation de id
        etLogin =(EditText) findViewById(R.id.email);
        etPassword =(EditText) findViewById(R.id.pass);
        tvRegister = (TextView) findViewById(R.id.link);
        bLogin = (Button) findViewById(R.id.signin);
        // etape 3: add lister
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLogin.getText().toString().equals("a") &&
                        etPassword.getText().toString().equals("a"))
                {
                   startActivity(new Intent(login.this,Quiz1.class));
                }else
                {
                    Toast.makeText(getApplicationContext(),"unknown user",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this,Register.class));
            }
        });



    }
}