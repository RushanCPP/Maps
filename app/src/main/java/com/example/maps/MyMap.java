package com.example.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyMap {
    private Map<String, String> map;

    public MyMap() {
        this.map = new TreeMap<>();
    }

    public MyMap(Map<String, String> map) {
        this.map = map;
    }

    public void add(String name, String mark) {
        map.put(name, mark);
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Student find(String studentName) {
        if (!map.containsKey(studentName))
            return null;
        return new Student(studentName, Integer.parseInt(map.get(studentName)));
    }

    public List<Student> getList() {
        List<Student> list = new ArrayList<>(map.size());
        for (String studentName : map.keySet())
            list.add(new Student(studentName, Integer.parseInt(map.get(studentName))));
        return list;
    }

    public Student getStudent(String name) {
        if (!map.containsKey(name))
            return null;
        return new Student(name, Integer.parseInt(map.get(name)));
    }
}
