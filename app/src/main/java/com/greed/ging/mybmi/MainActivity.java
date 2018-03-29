package com.greed.ging.mybmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI說明")
                        .setMessage("體重kg/身高平方m")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        bHelp = findViewById(R.id.b_help);
    }

    public void bmi(View v){
        //取得元件值並計算BMI
        String h = edHeight.getText().toString();
        String w = edWeight.getText().toString();
        float weight = Float.parseFloat(w); //強制轉型
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("BMI", String.valueOf(bmi));
        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setMessage(bmi+"")
                .setTitle("BMI結果")
                .setPositiveButton("OK", null)
                .setNeutralButton("Cancel", null)
                .show();

    }
}
