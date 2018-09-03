package com.astervaldemoro.fitspo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String foodName;
    private double proteins;
    private double fats;
    private double carbs;
    private double sugars;
    private int calories;

    public Food() { }

    protected Food(Parcel in) {
        foodName = in.readString ();
        proteins = in.readDouble ();
        fats = in.readDouble ();
        carbs = in.readDouble ();
        sugars = in.readDouble ();
        calories = in.readInt ();

    }

    public static final Creator<Food> CREATOR = new Creator<Food> () {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food (in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /*** SETTER METHODS ***/
    public void setFoodName(String foodName) { this.foodName = foodName; }
    public void setProteins(double proteins) { this.proteins = proteins; }
    public void setFats(double fats) { this.fats = fats; }
    public void setCarbs(double carbs) { this.carbs = carbs; }
    public void setSugars(double sugars) { this.sugars = sugars; }
    public void setCalories(int calories) { this.calories = calories; }

    /*** GETTER METHODS ***/
    public String getFoodName() { return foodName; }
    public double getProteins() { return proteins; }
    public double getFats() { return fats; }
    public double getCarbs() { return carbs; }
    public double getSugars() { return sugars; }
    public int getCalories() { return calories; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (foodName);
        dest.writeDouble (proteins);
        dest.writeDouble (fats);
        dest.writeDouble (carbs);
        dest.writeDouble (sugars);
        dest.writeInt (calories);
    }
}
