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

    View view;
    public ArrayList<Data> arr;

    public ListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_list,container,false);
        AsyncQueryData asyncQueryData = new AsyncQueryData() {
            @Override
            public void doInPostExecute(Answer<Data> answer) {
                arr = new ArrayList<Data>();
                for(Data u:answer.getData()){
                    Data object = new Data(u.id, u.name, u.count, u.place, u.cost, u.users);
                    arr.add(object);
                }
                objAdapter adapter = new objAdapter(view.getContext(), arr);
                ListView lv = (ListView) view.findViewById(R.id.listview);
                lv.setAdapter(adapter);
            }
        };
        asyncQueryData.select();
    return view;
    }
}