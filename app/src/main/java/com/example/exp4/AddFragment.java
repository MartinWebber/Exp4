package com.example.exp4;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AddFragment extends Fragment {

    public AddFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add,container,false);
        final EditText textName = view.findViewById(R.id.inname);
        final EditText textCount = view.findViewById(R.id.incount);
        final EditText textPlace = view.findViewById(R.id.inplace);
        final EditText textCost = view.findViewById(R.id.incost);
        final EditText textUsers = view.findViewById(R.id.inusers);
        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    AsyncQueryData asyncQueryData = new AsyncQueryData() {
                        @Override
                        public void doInPostExecute(Answer<Data> answer) {
                            textName.setText("");
                            textCount.setText("");
                            textPlace.setText("");
                            textCost.setText("");
                            textUsers.setText("");
                            Activity activity = getActivity();
                            Toast toast = Toast.makeText(activity, "Successfully added!", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    };
                    Data data = new Data(textName.getText().toString(),Integer.valueOf(textCount.getText().toString()),textPlace.getText().toString(),Integer.valueOf(textCost.getText().toString()),textUsers.getText().toString());
                    asyncQueryData.insert(data);
                } catch (NumberFormatException e) {
                    Activity activity = getActivity();
                    Toast toast = Toast.makeText(activity, "Error", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });
        return view;
    }
}
