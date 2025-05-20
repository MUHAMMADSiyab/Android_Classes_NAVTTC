package com.demo.firebaseauth.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.firebaseauth.models.Journal;

import java.util.List;

public class JournalListAdapter extends RecyclerView.Adapter<JournalListAdapter.ViewHolder> {
    private List<Journal> journalList;

    public JournalListAdapter(List<Journal> list) {
        this.journalList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Journal journal = this.journalList.get(position);
        holder.titleView.setText(journal.getTitle());
        holder.contentView.setText(journal.getContent());
    }

    @Override
    public int getItemCount() {
        return this.journalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView, contentView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(android.R.id.text1);
            contentView = itemView.findViewById(android.R.id.text2);
        }
    }
}
