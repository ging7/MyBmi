package com.greed.ging.mybmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        //float bmi = intent.getFloatExtra("BMI_EXTRA",0);
        //float bmi = intent.getExtras().getFloat("BMI_EXTRA", 0);
        Bundle bag = intent.getExtras();
        float bmi = bag.getFloat("BMI_EXTRA", 0);
        String test = bag.getString("TEST_EXTRA",null);
        TextView txtTest = findViewById(R.id.txtTest);
        TextView result = findViewById(R.id.result);
        result.setText("您的BMI值: " + bmi);
        txtTest.setText(test);
    }
}
