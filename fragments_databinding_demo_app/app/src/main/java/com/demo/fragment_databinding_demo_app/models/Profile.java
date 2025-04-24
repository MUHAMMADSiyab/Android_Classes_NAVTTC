package com.demo.fragment_databinding_demo_app.models;

public class Profile {
    private String name;
    private int age;
    private String email;
    private String phone;

    public Profile(String name, int age, String email, String phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return  this.phone;
    }
}
