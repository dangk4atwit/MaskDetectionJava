package com.example.maskdetectionjava;

import android.graphics.drawable.Drawable;

public class Data {
    enum Level {
        EMPLOYEE,
        MANAGER,
        ADMIN;
    }
    //Publicly accessed data
    public static Data  currData;

    String ID;
    String firstName;
    String lastName;
    boolean symptomCleared;
    boolean maskCleared;
    String phoneNumber;
    Level access;
    int profileImageID;

    //Default Constructor
    public Data(){
        this("none", "Bob", "Daniels",false, false, "000-000-0000", Level.ADMIN, R.drawable.ic_baseline_person_24);
    }

    public Data(Data data){
        this(data.ID, data.firstName, data.lastName, data.symptomCleared, data.maskCleared, data.phoneNumber, data.access, data.profileImageID);
    }

    public Data(String ID, String firstName, String lastName, boolean symptomCleared, boolean maskCleared, String phoneNumber, Level access, int profileImageID){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.symptomCleared = symptomCleared;
        this.maskCleared = maskCleared;
        this.phoneNumber = phoneNumber;
        this.access = access;
        this.profileImageID = profileImageID;
    }

    static public void setCurrData(Data data){
        currData = data;
    }
    static public void setSymptomCleared(boolean cleared){
        Data newData = currData;
        newData.symptomCleared = cleared;
        setCurrData(new Data(newData));
    }
    static public void setMaskCleared(boolean cleared){
        Data newData = currData;
        newData.maskCleared = cleared;
        setCurrData(new Data(newData));
    }

    public static boolean isCleared(){
        return currData.maskCleared && currData.symptomCleared;
    }

}
