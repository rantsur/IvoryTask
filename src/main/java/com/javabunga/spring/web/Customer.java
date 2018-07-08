package com.javabunga.spring.web;

import java.sql.Timestamp;

public class Customer {
    String ename;
    String hname;
    String city;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getActivity_status_code() {
        return activity_status_code;
    }

    public void setActivity_status_code(int activity_status_code) {
        this.activity_status_code = activity_status_code;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    String homeNumber;
    String street;
    String phone;
    int activity_status_code;
    Timestamp timestamp;
    int code;

    public Customer(int code, String ename, String hname, String city, String homeNumber, String street, String phone, int activity_status_code, Timestamp timestamp) {
        this.ename = ename;
        this.hname = hname;
        this.city = city;
        this.homeNumber = homeNumber;
        this.street = street;
        this.phone = phone;
        this.activity_status_code = activity_status_code;
        this.timestamp = timestamp;
        this.code = code;
    }
    public Customer() {}
}
