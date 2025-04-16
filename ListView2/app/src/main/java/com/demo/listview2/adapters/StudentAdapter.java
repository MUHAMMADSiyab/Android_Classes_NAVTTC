package com.demo.listview2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.demo.listview2.models.Student;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);

        // If no convertView is there
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        TextView nameTextView = convertView.findViewById(android.R.id.text1);
        TextView rollNumberTextView = convertView.findViewById(android.R.id.text2);

        nameTextView.setText(student.getName());
        rollNumberTextView.setText("Roll No: " + student.getRollNumber());

        return convertView;
    }

}
