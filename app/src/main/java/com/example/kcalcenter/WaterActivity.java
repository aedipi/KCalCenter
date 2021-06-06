package com.example.kcalcenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.kcalcenter.model.DBHelper;
import com.example.kcalcenter.model.Food;
import com.example.kcalcenter.model.FoodAdapter;

import java.util.ArrayList;

public class WaterActivity extends AppCompatActivity {
    Button btnLunchAddFood;
    ListView lstFoodList;
    Spinner sprFoodList;
    float waterML;
    static ArrayList<Food> foods = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);


        lstFoodList = (ListView) findViewById(R.id.lstWaterList);
        sprFoodList = (Spinner) findViewById(R.id.sprWaters);
        btnLunchAddFood = (Button) findViewById(R.id.btnAddWater);

        FoodAdapter foodAdapter = new FoodAdapter(WaterActivity.this,R.layout.listview_food,foods);
        lstFoodList.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

        btnLunchAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedFood =  sprFoodList.getSelectedItem().toString();
                if (selectedFood.toString().toLowerCase().equals("Bir Bardak Su (ML)".toLowerCase())){
                    waterML = 100;
                    foods.add(new Food(selectedFood,waterML,R.drawable.sparkling_water));
                    DBHelper.DBWater.add(new Food(selectedFood,waterML,R.drawable.sparkling_water));
                }
                if (selectedFood.toString().toLowerCase().equals("Bir Şişe Su (ML)".toLowerCase())){
                    waterML = 500;
                    foods.add(new Food(selectedFood,waterML,R.drawable.bottle_of_water));
                    DBHelper.DBWater.add(new Food(selectedFood,waterML,R.drawable.bottle_of_water));
                }



                foodAdapter.notifyDataSetChanged();
                Intent intent = new Intent(WaterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}