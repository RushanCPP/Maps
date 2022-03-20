package com.example.maps;

public class Student {
    private int mark;
    private String name;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name, int mark) {
        this.mark = mark;
        this.name = name;
    }
}
