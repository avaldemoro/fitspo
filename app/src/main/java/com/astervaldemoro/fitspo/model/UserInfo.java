package com.astervaldemoro.fitspo.model;
import android.os.Parcel;
import android.os.Parcelable;

public class UserInfo implements Parcelable {
    private String gender;
    private int age;
    private int ftHeight;
    private int inHeight;
    private int currentWeight;
    private int goalWeight;
    private String activityLevel;
    private int daysPerWeekExercise;
    private int minutesPerDayExercise;
    private String goalPercent;

    public UserInfo() { }

    protected UserInfo(Parcel in) {
        gender = in.readString ();
        age = in.readInt ();
        ftHeight = in.readInt ();
        inHeight = in.readInt ();
        currentWeight = in.readInt ();
        goalWeight = in.readInt ();
        activityLevel = in.readString ();
        daysPerWeekExercise = in.readInt ();
        minutesPerDayExercise = in.readInt ();
        goalPercent = in.readString ();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString (gender);
        dest.writeInt (age);
        dest.writeInt (ftHeight);
        dest.writeInt (inHeight);
        dest.writeInt (currentWeight);
        dest.writeInt (goalWeight);
        dest.writeString (activityLevel);
        dest.writeInt (daysPerWeekExercise);
        dest.writeInt (minutesPerDayExercise);
        dest.writeString (goalPercent);
    }

    /*** SETTER METHODS ***/
    public void setGender(String gender) { this.gender = gender; }
    public void setAge(int age) { this.age = age; }
    public void setFtHeight(int ftHeight) { this.ftHeight = ftHeight; }
    public void setInHeight(int inHeight) { this.inHeight = inHeight; }
    public void setCurrentWeight(int currentWeight) { this.currentWeight = currentWeight; }
    public void setGoalWeight(int goalWeight) { this.goalWeight = goalWeight; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    public void setDaysPerWeekExercise(int daysPerWeekExercise) { this.daysPerWeekExercise = daysPerWeekExercise; }
    public void setMinutesPerDayExercise(int minutesPerDayExercise) { this.minutesPerDayExercise = minutesPerDayExercise; }
    public void setGoalPercent(String goalPercent) { this.goalPercent = goalPercent; }

    /*** GETTER METHODS ***/
    public String getGender() { return gender; }
    public int getAge() { return age; }
    public int getFtHeight() { return ftHeight; }
    public int getInHeight() { return inHeight; }
    public int getCurrentWeight() { return currentWeight; }
    public int getGoalWeight() { return goalWeight; }
    public String getActivityLevel() { return activityLevel; }
    public int getDaysPerWeekExercise() { return daysPerWeekExercise; }
    public int getMinutesPerDayExercise() { return minutesPerDayExercise; }
    public String getGoalPercent() { return goalPercent; }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo> () {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo (in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
