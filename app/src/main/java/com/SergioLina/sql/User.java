package com.SergioLina.sql;

/**
 * Created by braya on 18/10/2017.
 */

public class User {
    private String name, nameL, nameA, phone;
    private String uid;

    public User(String name, String nameL, String nameA, String phone, String uid) {
        this.name = name;
        this.nameL = nameL;
        this.nameA = nameA;
        this.phone = phone;
        this.uid = uid;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNameL() {
        return nameL;
    }

    public void setNameL(String nameL) {
        this.nameL = nameL;
    }


    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}