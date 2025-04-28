package com.demo.twowaybinding_oal.models;

import androidx.databinding.BaseObservable;
import com.demo.twowaybinding_oal.BR;
import androidx.databinding.Bindable;

public class User extends BaseObservable {

    private String name;
    private String email;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }





}
