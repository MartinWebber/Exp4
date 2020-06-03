package com.example.exp4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    public ArrayList<Object> arr;

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list,container,false);
    final objAdapter adapter = new objAdapter(view.getContext(), makeObj());
    ListView lv = (ListView) view.findViewById(R.id.listview);
    lv.setAdapter(adapter);

    return view;
    }

    ArrayList<Object> makeObj() {
        /*Object[] arr = new Object[5];
        String[] names = {"A", "B", "C", "D", "E"};
        int[] counts = {1,2,3,4,5};
        String[] places = {"a","b","c","d","e"};
        int[] costs = {10,20,30,40,50};
        String[] users = {"Aa","Bb","Cc","Dd","Ee"};

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Object(names[i], counts[i], places[i], costs[i], users[i]);
        }
        return arr;*/
        AsyncQueryData asyncQueryData = new AsyncQueryData() {
            @Override
            public void doInPostExecute(Answer<Data> answer) {
                for(Data u:answer.getData()){
                    Object object = new Object(u.name, u.count, u.place, u.cost, u.users);
                    arr.add(object);
                }
            }
        };
        asyncQueryData.select();
        return arr;
    }
}
