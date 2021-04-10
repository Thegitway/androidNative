package com.example.lab11_o22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class login extends AppCompatActivity {
    // step 1 : Declaration des elements
    EditText etLogin,etPassword;
    Button bLogin;
    ImageView img;
    TextView tvRegister;
    private final FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private static final String TAG = login.class.getSimpleName();
    FirebaseUser currentUser;
    FirebaseStorage storage;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
         currentUser = mAuth.getCurrentUser();
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
        img=(ImageView) findViewById(R.id.logo);

        
            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.setValue("Hello, World");

        try {
            storage= FirebaseStorage.getInstance();
            StorageReference httpsReference = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/tpandroidnative.appspot.com/o/logofire.jpg?alt=media&token=a11a52c2-cfed-484a-acd6-c07d26ae29ff");
            final long ONE_MEGABYTE = 1024 * 1024;

            httpsReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    img.setImageBitmap(bm);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    Toast.makeText(login.this, "failed to load the logo",
                            Toast.LENGTH_SHORT).show();
                    System.out.println("Omar "+ exception.getMessage());
                }
            });
        }catch(Exception e)
        {
            Toast.makeText(login.this, e.getMessage()+" download exception",
                    Toast.LENGTH_SHORT).show();
            System.out.println("download Exception "+e.getMessage());
        }


        // etape 3: add lister
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signInWithEmailAndPassword(etLogin.getText().toString(),etPassword.getText().toString())
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithCustomToken:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    bLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            startActivity(new Intent(login.this, Quiz1.class));
                                        }
                                        });


                                    } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                                    Toast.makeText(login.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

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