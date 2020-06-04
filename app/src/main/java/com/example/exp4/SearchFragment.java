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

    View view;
    public ArrayList<Data> arr;

    public SearchFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search,container,false);
        final EditText textSearch = view.findViewById(R.id.textSearch);
        Button buttonSearch = view.findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncQueryData asyncQueryData = new AsyncQueryData() {
                    @Override
                    public void doInPostExecute(Answer<Data> answer) {
                        arr = new ArrayList<Data>();
                        for(Data u:answer.getData()){
                            Data object = new Data(u.name, u.count, u.place, u.cost, u.users);
                            arr.add(object);
                        }
                        objAdapter adapter = new objAdapter(view.getContext(), arr);
                        ListView lv = (ListView) view.findViewById(R.id.searchList);
                        lv.setAdapter(adapter);
                    }
                };
                asyncQueryData.search(textSearch.getText().toString());
            }
        });
        return view;
    }
}
