package com.example.kcalcenter.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.kcalcenter.LunchActivity;
import com.example.kcalcenter.R;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food>{
    ArrayList<Food> foodList;
    Context context;
    int resourceID;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Food> list) {
        super(context, resource, list);
        this.foodList = list;
        this.context = context;
        this.resourceID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(resourceID,parent,false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.ivFoodImage);
        TextView tvFoodName = (TextView) view.findViewById(R.id.tvFoodName);
        TextView tvFoodKCAL = (TextView) view.findViewById(R.id.tvFoodCalori);

        Food food = foodList.get(position);

        ivImage.setImageDrawable(context.getResources().getDrawable(food.getFoodImage()));
        tvFoodName.setText(food.getFoodName());
        tvFoodKCAL.setText(String.valueOf(food.getFoodCalori()));

        return view;
    }
}
