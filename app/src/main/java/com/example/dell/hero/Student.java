package com.example.dell.hero;

import java.io.Serializable;

/**
 * Created by Dell on 15-Jan-18.
 */

public class Student implements Serializable{

    private int mImage;
    private String mName;
    private String mID;
    private String mClassName;

    Student(int img, String name) {
        mImage = img;
        mName = name;
    }

    public Student(int image, String name, String ID, String aClass) {
        mImage = image;
        mName = name;
        mID = ID;
        mClassName = aClass;
    }

    public String getClassName() {
        return mClassName;
    }

    public void setClassName(String className) {
        mClassName = className;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }
}

