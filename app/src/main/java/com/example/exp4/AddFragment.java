package com.example.exp4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class AddFragment extends Fragment {

    public AddFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add,container,false);
        TextView textName = view.findViewById(R.id.inname);
        TextView textCount = view.findViewById(R.id.incount);
        TextView textPlace = view.findViewById(R.id.inplace);
        TextView textCost = view.findViewById(R.id.incost);
        TextView textUsers = view.findViewById(R.id.inusers);
        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}
