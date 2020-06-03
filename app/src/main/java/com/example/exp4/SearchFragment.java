package com.example.exp4;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    public ArrayList<Object> arr;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search,container,false);
        final objAdapter adapter = new objAdapter(view.getContext(), makeObj());
        ListView lv = (ListView) view.findViewById(R.id.searchList);
        lv.setAdapter(adapter);
        final EditText textSearch = view.findViewById(R.id.textSearch);
        Button buttonSearch = view.findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncQueryData asyncQueryData = new AsyncQueryData() {
                    @Override
                    public void doInPostExecute(Answer<Data> answer) {

                    }
                };
                asyncQueryData.search(textSearch.getText().toString());
            }
        });
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
