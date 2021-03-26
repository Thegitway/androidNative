package com.example.lab11_o22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {

    // step 1 : Declaration des elements
    RadioButton radio1,radio2,radio3;
    RadioGroup radioGroup;
    Button btnValider;

    //une activité doit avoir en minimum une method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        //etape 2: recuparation de id
        radio1 =(RadioButton) findViewById(R.id.radio1);
        radio2 =(RadioButton) findViewById(R.id.radio2);
        radio3 =(RadioButton) findViewById(R.id.radio3);
        radioGroup=(RadioGroup) findViewById(R.id.group);
        btnValider=(Button) findViewById(R.id.valider);

        // etape 3: add lister
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Quiz1.this,Quiz2.class);
                i.putExtra("result",radio2.isChecked()?1:0);
                startActivity(i);
            }
        });


    }
}