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
        final View view = inflater.inflate(R.layout.fragment_add,container,false);
        final TextView textName = view.findViewById(R.id.inname);
        final TextView textCount = view.findViewById(R.id.incount);
        final TextView textPlace = view.findViewById(R.id.inplace);
        final TextView textCost = view.findViewById(R.id.incost);
        final TextView textUsers = view.findViewById(R.id.inusers);
        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncQueryData asyncQueryUser = new AsyncQueryData() {
                    @Override
                    public void doInPostExecute(Answer<Data> answer) {
                        Data data = new Data(textName.getText().toString(),Integer.valueOf(textCount.getText().toString()),textPlace.getText().toString(),Integer.valueOf(textCost.getText().toString()),textUsers.getText().toString());
                    }
                };
                asyncQueryUser.insert();
            }
        });
        return view;
    }
}
