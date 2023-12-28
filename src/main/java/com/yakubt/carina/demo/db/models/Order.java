package com.yakubt.carina.demo.db.models;

public class Order {

    private int id;

    private int userId;

    private String name;

    public Order() {

    }

    public Order(int id, int userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
