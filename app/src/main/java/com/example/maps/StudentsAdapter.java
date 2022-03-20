package com.example.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentsAdapter extends ArrayAdapter<Student> {

    public StudentsAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        if (convertView == null) {
            // создаем по resource layout
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }
        ((TextView) convertView.findViewById(R.id.item_text)).
                setText(student.getName() + " - " + student.getMark());
        return convertView;
    }
}
