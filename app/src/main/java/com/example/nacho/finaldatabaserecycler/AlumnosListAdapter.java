package com.example.nacho.finaldatabaserecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlumnosListAdapter extends RecyclerView.Adapter<AlumnosListAdapter.StudentsViewHolder> {


    private List<Alumnos> mAlumnos; // Cached copy of words

    public AlumnosListAdapter(List<Alumnos> myDataset){
      mAlumnos = myDataset;
    }
    @Override
    public StudentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new StudentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentsViewHolder holder, int position) {
        if (mAlumnos != null) {
            Alumnos current = mAlumnos.get(position);
            holder.idTV.setText(String.valueOf(current.getMId()));
            holder.nameTV.setText(current.getMName());
            holder.lessonsTV.setText(current.getMLesson());
            holder.teacherTV.setText(current.getMTeacher());
            holder.hoursTV.setText(String.valueOf(current.getMHours()));
        } else {
            // Covers the case of data not being ready yet.
            holder.idTV.setText("NO DATA");
            holder.nameTV.setText("NO DATA");
            holder.lessonsTV.setText("NO DATA");
            holder.teacherTV.setText("NO DATA");
            holder.hoursTV.setText("NO DATA");
        }
    }

    void setWords(List<Alumnos> words){
        mAlumnos = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mAlumnos != null)
            return mAlumnos.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.tvName);
        }
    }
    public static class StudentsViewHolder extends RecyclerView.ViewHolder {
        private final TextView idTV;
        private final TextView nameTV;
        private final TextView lessonsTV;
        private final TextView teacherTV;
        private final TextView hoursTV;

        private StudentsViewHolder(View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.tvId);
            nameTV = itemView.findViewById(R.id.tvName);
            lessonsTV = itemView.findViewById(R.id.tvLessons);
            teacherTV = itemView.findViewById(R.id.tvTeacher);
            hoursTV = itemView.findViewById(R.id.tvHours);
        }
    }

}