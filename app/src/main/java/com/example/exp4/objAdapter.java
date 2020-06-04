package com.example.exp4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class objAdapter extends ArrayAdapter<Data> {

    //private ArrayList<Data> arr;

    public objAdapter(Context context, ArrayList<Data> arr) {
        super(context, R.layout.adapter_item, arr);
        //this.arr = arr;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final Data obj = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name)).setText(obj.name);
        ((TextView) convertView.findViewById(R.id.count)).setText(String.valueOf(obj.count));
        ((TextView) convertView.findViewById(R.id.place)).setText(obj.place);
        ((TextView) convertView.findViewById(R.id.cost)).setText(String.valueOf(obj.cost));
        ((TextView) convertView.findViewById(R.id.users)).setText(obj.users);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //arr.remove(position);
                AsyncQueryData asyncQueryData = new AsyncQueryData() {
                    @Override
                    public void doInPostExecute(Answer<Data> answer) {

                    }
                };
                asyncQueryData.delete(obj.id);
            }
        });
        return convertView;
    }
}