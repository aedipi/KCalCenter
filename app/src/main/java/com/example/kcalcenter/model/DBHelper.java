package com.example.kcalcenter.model;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {
    final private static ArrayList<User> DB = new ArrayList<>();
    final public static ArrayList<Food> DBFood = new ArrayList<>();
    final public static ArrayList<Food> DBWater = new ArrayList<>();
    public static float CalculatedUserGoalWeight = 0;

    //public DBHelper() {
        //DB = new ArrayList<User>();
    //}

    public static float  FoodKCAL(){
        float totalKCal =0;
        for (Food food : DBFood){
            totalKCal = totalKCal + food.getFoodCalori();
        }
        return totalKCal;
    }
    public static float  WaterLtr(){
        float totalML =0;
        for (Food food : DBWater){
            totalML = totalML + food.getFoodCalori();
        }
        float totalL = totalML/1000;
        return (totalL);
    }

    public boolean AddUser(User user) {
        if(IsAvailableUser(user)){
            DB.add(user);
            return true;
        }
        return false;
    }

    public static boolean Login(String email, String password) {
        boolean result = false;
        if (DB != null) {
            for (User user : DB) {
                if (user.getEmail().toLowerCase().equals(email.toLowerCase()) && user.getPassword().equals(password)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public static ArrayList<User> GetUsers() {
        return DB;
    }

    public static boolean IsAvailableUser(User _user) {
        for (User user : DB) {
                if (user.Email.toString().toLowerCase().equals(_user.Email.toString().toLowerCase())) {
                    return false;
                }
        }
        return true;
    }
}
