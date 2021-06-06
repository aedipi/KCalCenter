package com.example.kcalcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kcalcenter.model.DBHelper;
import com.example.kcalcenter.model.User;

public class MainActivity extends AppCompatActivity {
    Button btn_Breakfast;
    Button btn_Brunch;
    Button btn_Lunch;
    Button btn_Dinner;
    Button btn_Supper;
    Button btn_Water;
    Button btn_Weight;
    TextView tv_main_calori;
    TextView tv_main_water;
    TextView tv_main_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_main_weight = (TextView) findViewById(R.id.tv_main_weight);
        tv_main_weight.setText(String.valueOf(DBHelper.CalculatedUserGoalWeight));

        tv_main_calori = (TextView) findViewById(R.id.tv_main_calori);
        tv_main_calori.setText(String.valueOf(DBHelper.FoodKCAL()));

        tv_main_water = (TextView) findViewById(R.id.tv_main_water);
        tv_main_water.setText(String.valueOf(DBHelper.WaterLtr()));

        btn_Breakfast = (Button) findViewById(R.id.btn_Breakfast);
        btn_Breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BreakfastActivity.class);
                startActivity(intent);
            }
        });
        btn_Brunch = (Button) findViewById(R.id.btn_Brunch);
        btn_Brunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BrunchActivity.class);
                startActivity(intent);
            }
        });
        btn_Lunch = (Button) findViewById(R.id.btn_Lunch);
        btn_Lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LunchActivity.class);
                startActivity(intent);
            }
        });
        btn_Dinner = (Button) findViewById(R.id.btn_Dinner);
        btn_Dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DinnerActivity.class);
                startActivity(intent);
            }
        });
        btn_Supper = (Button) findViewById(R.id.btn_Supper);
        btn_Supper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SupperActivity.class);
                startActivity(intent);
            }
        });
        btn_Water = (Button) findViewById(R.id.btn_main_water);
        btn_Water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WaterActivity.class);
                startActivity(intent);
            }
        });
        btn_Weight = (Button) findViewById(R.id.btn_main_kg);
        btn_Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,weightActivity.class);
                startActivity(intent);
            }
        });
    }
}