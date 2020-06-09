package com.example.exp4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

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

        ((TextView) convertView.findViewById(R.id.name)).setText("Название: " + obj.name);
        ((TextView) convertView.findViewById(R.id.count)).setText("Количество: " + String.valueOf(obj.count));
        ((TextView) convertView.findViewById(R.id.place)).setText("Место хранения: " + obj.place);
        ((TextView) convertView.findViewById(R.id.cost)).setText("Цена: " + String.valueOf(obj.cost) + " руб.");
        ((TextView) convertView.findViewById(R.id.users)).setText("Пользователи: " + obj.users);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncQueryData asyncQueryData = new AsyncQueryData() {
                    @Override
                    public void doInPostExecute(Answer<Data> answer) {
                        Toast toast = Toast.makeText(getContext(), "Успешно удалено!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                };
                asyncQueryData.delete(obj.id);
            }
        });
        return convertView;
    }
}