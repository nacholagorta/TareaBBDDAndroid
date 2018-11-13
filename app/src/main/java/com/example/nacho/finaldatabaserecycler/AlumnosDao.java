package com.example.nacho.finaldatabaserecycler;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AlumnosDao {

    @Insert
    void insert(Alumnos name);

    @Insert
    void insertAll (List<Alumnos> data);

    @Query("DELETE FROM alumnos_table")
    void deleteAll();

    @Query("SELECT * from alumnos_table ORDER BY name ASC")
    LiveData<List<Alumnos>> getAllWords();
}