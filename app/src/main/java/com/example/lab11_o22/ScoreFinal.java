package com.example.lab11_o22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreFinal extends AppCompatActivity {

    TextView text;
    Button btnRetry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_final);
        text=(TextView) findViewById(R.id.text);
        btnRetry=(Button) findViewById(R.id.btn);
        Bundle extras = getIntent().getExtras();
        int value = extras.getInt("result");
        text.setText("Your score is "+value);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ScoreFinal.this,Quiz1.class);
                startActivity(i);
            }
        });


    }
}