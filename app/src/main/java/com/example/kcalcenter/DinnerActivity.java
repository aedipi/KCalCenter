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

public class DinnerActivity extends AppCompatActivity {
    Button btnLunchAddFood;
    ListView lstFoodList;
    Spinner sprFoodList;
    float kalori;
    static ArrayList<Food> foods = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        lstFoodList = (ListView) findViewById(R.id.lstLunchFoodList);
        sprFoodList = (Spinner) findViewById(R.id.sprFoods);
        btnLunchAddFood = (Button) findViewById(R.id.btnAddFood_Lunch);

        FoodAdapter foodAdapter = new FoodAdapter(DinnerActivity.this,R.layout.listview_food,foods);
        lstFoodList.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();

        btnLunchAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedFood =  sprFoodList.getSelectedItem().toString();
                if (selectedFood.toString().toLowerCase().equals("Pilav".toLowerCase())){
                    kalori = 239;
                }
                if (selectedFood.toString().toLowerCase().equals("Kebap".toLowerCase())){
                    kalori = 458;
                }
                if (selectedFood.toString().toLowerCase().equals("Baklava".toLowerCase())){
                    kalori = 329;
                }
                if (selectedFood.toString().toLowerCase().equals("Güllaç".toLowerCase())){
                    kalori = 244;
                }
                if (selectedFood.toString().toLowerCase().equals("Makarna".toLowerCase())){
                    kalori = 416;
                }
                if (selectedFood.toString().toLowerCase().equals("Büryan".toLowerCase())){
                    kalori = 594;
                }
                if (selectedFood.toString().toLowerCase().equals("Kellepaça".toLowerCase())){
                    kalori = 536;
                }
                if (selectedFood.toString().toLowerCase().equals("İşkembe".toLowerCase())){
                    kalori = 512;
                }
                if (selectedFood.toString().toLowerCase().equals("Kokoreç".toLowerCase())){
                    kalori = 715;
                }
                if (selectedFood.toString().toLowerCase().equals("Midye".toLowerCase())){
                    kalori = 34;
                }
                if (selectedFood.toString().toLowerCase().equals("Köfte".toLowerCase())){
                    kalori = 143;
                }
                if (selectedFood.toString().toLowerCase().equals("Et Döner".toLowerCase())){
                    kalori = 468;
                }
                if (selectedFood.toString().toLowerCase().equals("Tavuk Döner".toLowerCase())){
                    kalori = 385;
                }
                foods.add(new Food(selectedFood,kalori,R.drawable.pilav));
                DBHelper.DBFood.add(new Food(selectedFood,kalori,R.drawable.pilav));


                foodAdapter.notifyDataSetChanged();
                Intent intent = new Intent(DinnerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}