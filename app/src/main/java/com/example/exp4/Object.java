package com.example.exp4;

public class Object {
    protected String name;
    protected int count;
    protected String place;
    protected int cost;
    protected String users;

    Object(String name, int count, String place, int cost, String users){
        this.name = name;
        this.count = count;
        this.place = place;
        this.cost = cost;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count = count;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }
}