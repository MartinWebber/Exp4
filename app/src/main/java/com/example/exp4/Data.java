package com.example.exp4;

public class Data {
    Data(String name, int count, String place, int cost, String users){
        this.name = name;
        this.count = count;
        this.place = place;
        this.cost = cost;
        this.users = users;
    }

    Data(int id, String name, int count, String place, int cost, String users){
        this.id = id;
        this.name = name;
        this.count = count;
        this.place = place;
        this.cost = cost;
        this.users = users;
    }

    public String name, place, users;
    public int count, cost, id;

    public String getInsertData(){
        return "'" + name + "'," + count + ",'" + place + "'," + cost + ",'" + users + "'";
    }

}
