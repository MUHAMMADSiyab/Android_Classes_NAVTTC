package com.demo.recyclerview_viewholder.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.recyclerview_viewholder.R;
import com.demo.recyclerview_viewholder.StudentDetailsActivity;
import com.demo.recyclerview_viewholder.models.Student;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private final ArrayList<Student> students;
    private final Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
       public TextView nameTextView, rollNumberTextView;

        public StudentViewHolder(View view) {
            super(view);

            nameTextView = view.findViewById(R.id.nameTextView);
            rollNumberTextView = view.findViewById(R.id.rollNumberTextView);

        }
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
       Student student = this.students.get(position);

       holder.nameTextView.setText(student.getName());
       holder.rollNumberTextView.setText("Roll Number: " + student.getRollNumber());

       holder.itemView.setOnClickListener(v -> {
           Intent intent = new Intent(this.context, StudentDetailsActivity.class);
           intent.putExtra("name", student.getName());
           intent.putExtra("rollNumber", student.getRollNumber());

           this.context.startActivity(intent);
       });

    }

    public int getItemCount() {
        return this.students.size();
    }


}
