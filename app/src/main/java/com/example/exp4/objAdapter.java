package com.example.exp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class objAdapter extends ArrayAdapter<Object> {

    public objAdapter(Context context, Object[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Object obj = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name)).setText(obj.name);
        ((TextView) convertView.findViewById(R.id.count)).setText(String.valueOf(obj.count));
        ((TextView) convertView.findViewById(R.id.place)).setText(obj.place);
        ((TextView) convertView.findViewById(R.id.cost)).setText(String.valueOf(obj.cost));
        ((TextView) convertView.findViewById(R.id.users)).setText(obj.users);
        return convertView;
    }
}