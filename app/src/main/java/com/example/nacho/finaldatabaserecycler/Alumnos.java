package com.example.nacho.finaldatabaserecycler;

import android.support.annotation.NonNull;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "alumnos_table")
public class Alumnos {

    @PrimaryKey
    @NonNull
    @ColumnInfo (name = "id")
    private int mId;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "clase")
    private String mLesson;

    @ColumnInfo(name = "profesor")
    private String mTeacher;

    @ColumnInfo(name = "horas")
    private int mHours;

    public Alumnos(@NonNull int id, String name, String lesson, String teacher, int hours) {
        this.mId = id;
        this.mName = name;
        this.mLesson = lesson;
        this.mTeacher = teacher;
        this.mHours = hours;
    }

    @NonNull
    public int getMId() {
        return mId;
    }

    public void setMId(@NonNull Integer mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMLesson() {
        return mLesson;
    }

    public void setMLesson(String mClass) {
        this.mLesson = mClass;
    }

    public String getMTeacher() {
        return mTeacher;
    }

    public void setMTeacher(String mTeacher) {
        this.mTeacher = mTeacher;
    }

    public int getMHours() {
        return mHours;
    }

    public void setMHours(Integer mHours) {
        this.mHours = mHours;
    }

    @Override
    public String toString() {
        return "Alumnos{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mLesson='" + mLesson + '\'' +
                ", mTeacher='" + mTeacher + '\'' +
                ", mHours=" + mHours +
                '}';
    }
}