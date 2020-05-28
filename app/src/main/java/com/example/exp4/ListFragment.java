package com.example.exp4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFragment extends Fragment {

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list,container,false);
    objAdapter adapter = new objAdapter(view.getContext(), makeObj());
    ListView lv = (ListView) view.findViewById(R.id.listview);
    lv.setAdapter(adapter);
    return view;
    }

    Object[] makeObj() {
        Object[] arr = new Object[5];
        String[] names = {"A", "B", "C", "D", "E"};
        int[] counts = {1,2,3,4,5};
        String[] places = {"a","b","c","d","e"};
        int[] costs = {10,20,30,40,50};
        String[] users = {"Aa","Bb","Cc","Dd","Ee"};

        for (int i = 0; i < arr.length; i++) {
            Object obj = new Object();
            obj.name = names[i];
            obj.count = counts[i];
            obj.place = places[i];
            obj.cost = costs[i];
            obj.users = users[i];
            arr[i] = obj;
        }
        return arr;
    }
}
