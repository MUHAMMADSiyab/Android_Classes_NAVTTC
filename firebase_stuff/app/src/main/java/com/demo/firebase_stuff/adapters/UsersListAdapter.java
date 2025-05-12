package com.demo.firebase_stuff.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.demo.firebase_stuff.R;
import com.demo.firebase_stuff.models.User;

import java.util.ArrayList;

public class UsersListAdapter extends ArrayAdapter<User> {
    public UsersListAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, @NonNull android.view.ViewGroup parent) {
        User user = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2,parent, false);
        }

        TextView nameTextView = convertView.findViewById(android.R.id.text1);
        TextView emailTextView = convertView.findViewById(android.R.id.text2);

        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());

        return convertView;
    }
}
