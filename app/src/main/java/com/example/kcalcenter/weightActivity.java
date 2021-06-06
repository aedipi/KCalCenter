package com.example.kcalcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kcalcenter.model.DBHelper;

public class weightActivity extends AppCompatActivity {
    static float current_weight = 0;
    static float goal_weight = 0;
    EditText et_current_weight;
    EditText et_goal_weight;
    Button btn_Calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        et_current_weight = (EditText) findViewById(R.id.et_current_weight);
        et_goal_weight = (EditText) findViewById(R.id.et_goal_weight);

        et_current_weight.setText(String.valueOf(current_weight));
        et_goal_weight.setText(String.valueOf(goal_weight));

        btn_Calculate = (Button) findViewById(R.id.btn_weight_calculate);
        btn_Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_weight = Float.parseFloat(et_current_weight.getText().toString());
                goal_weight = Float.parseFloat(et_goal_weight.getText().toString());
                DBHelper.CalculatedUserGoalWeight = current_weight - goal_weight;
                Intent intent = new Intent(weightActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}