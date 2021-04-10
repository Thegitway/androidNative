package com.example.lab11_o22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ramijemli.percentagechartview.PercentageChartView;

import org.w3c.dom.Text;

public class ScoreFinal extends AppCompatActivity {

    TextView text;
    Button btnRetry;
    PercentageChartView chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_final);
        text=(TextView) findViewById(R.id.text);
        btnRetry=(Button) findViewById(R.id.btn);
        chart=(PercentageChartView) findViewById(R.id.chart);
        Bundle extras = getIntent().getExtras();
        float value = extras.getInt("result");
        text.setText("Your score is "+(int)value+"/2");
        value=(value/2)*100;
        chart.setProgress(value,true);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ScoreFinal.this,Quiz1.class);
                startActivity(i);
            }
        });


    }
}