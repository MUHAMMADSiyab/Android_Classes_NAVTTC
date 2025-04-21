package com.demo.recyclerview_viewholder.models;

public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getRollNumber() {
        return this.rollNumber;
    }
}
