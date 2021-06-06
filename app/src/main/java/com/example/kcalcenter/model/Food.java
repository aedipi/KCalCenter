package com.example.kcalcenter.model;

public class Food {
    private  String foodName;
    private  float foodCalori;
     int foodImage;

    public Food(String foodName, float foodCalori, int foodImage) {
        this.foodName = foodName;
        this.foodCalori = foodCalori;
        this.foodImage = foodImage;
    }

    public  int getFoodImage() {
        return foodImage;
    }

    public  void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public  String getFoodName() {
        return foodName;
    }

    public  void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public  float getFoodCalori() {
        return foodCalori;
    }

    public  void setFoodCalori(float foodCalori) {
        this.foodCalori = foodCalori;
    }
}
