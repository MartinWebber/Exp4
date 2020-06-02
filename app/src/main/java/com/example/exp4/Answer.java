package com.example.exp4;

import java.util.ArrayList;

public class Answer<T> {
    public String sql;
    public Boolean status;

    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }
}
