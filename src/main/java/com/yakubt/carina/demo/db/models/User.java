package com.yakubt.carina.demo.db.models;

import java.util.List;

public class User {

    private int id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String zip;

    List<Integer> orders;


    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public List<Integer> getOrders() {
        return orders;
    }

    public String getUserName() {
        return userName;
    }

    public String getZip() {
        return zip;
    }

    public void setOrders(List<Integer> orders) {
        this.orders = orders;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
