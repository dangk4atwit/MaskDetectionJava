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
    boolean cleared;
    String phoneNumber;
    Level access;
    int profileImageID;

    public Data(){
        this("none", "Bob", "Daniels", false, "000-000-0000", Level.ADMIN, R.drawable.ic_baseline_person_24);
    }

    public Data(String ID, String firstName, String lastName, boolean cleared, String phoneNumber, Level access, int profileImageID){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cleared = cleared;
        this.phoneNumber = phoneNumber;
        this.access = access;
        this.profileImageID = profileImageID;
    }

    static public void setCurrData(Data data){
        currData = data;
    }

}
