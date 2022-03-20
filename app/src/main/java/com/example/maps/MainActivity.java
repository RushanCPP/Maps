package com.example.maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button saveButton, findButton, removeButton;
    EditText markEditText, nameEditText;
    StudentsAdapter studentsAdapter;
    List<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.studentsList);
        saveButton = findViewById(R.id.saveButton);
        findButton = findViewById(R.id.findButton);
        removeButton = findViewById(R.id.removeButton);
        markEditText = findViewById(R.id.editTextPersonMark);
        nameEditText = findViewById(R.id.editTextPersonName);

        studentList = new ArrayList<>();
        MyMap myMap = new MyMap();
        studentsAdapter = new StudentsAdapter(this, R.layout.adapter_item, studentList);
        listView.setAdapter(studentsAdapter);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String mark = markEditText.getText().toString();
                if (name.isEmpty() || mark.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введи данные", Toast.LENGTH_SHORT).show();
                    return;
                }
                myMap.add(name, mark);
                studentList.clear();
                studentList.addAll(myMap.getList());
                studentsAdapter.notifyDataSetChanged();
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введи данные", Toast.LENGTH_SHORT).show();
                    return;
                }
                myMap.remove(name);
                studentList.clear();
                studentList.addAll(myMap.getList());
                studentsAdapter.notifyDataSetChanged();
            }
        });
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                if (name.isEmpty()) {
                    studentList.clear();
                    studentList.addAll(myMap.getList());
                    studentsAdapter.notifyDataSetChanged();
                    return;
                }
                Student student = myMap.find(name);
                if (student == null)
                    return;
                studentList.clear();
                studentList.add(student);
                studentsAdapter.notifyDataSetChanged();
            }
        });
    }
}