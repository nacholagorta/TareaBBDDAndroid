package com.example.nacho.finaldatabaserecycler;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     mRecyclerView = findViewById(R.id.recyclerview);
     mRecyclerView.setHasFixedSize(true);
     mLayoutManager = new GridLayoutManager(this,2);
     mRecyclerView.setLayoutManager(mLayoutManager);

       AlumnosRepository alumnosRepository = new AlumnosRepository(getApplication());
       alumnosRepository.getAllWords().observe(this, new Observer<List<Alumnos>>() {
           @Override
           public void onChanged(@Nullable List<Alumnos> alumnos) {
               if(alumnos != null){
                   Log.d("BASE DE DATOS","Listado: "+alumnos.toString());
                   mAdapter = new AlumnosListAdapter(alumnos);
                   mRecyclerView.setAdapter(mAdapter);
               }
           }
       });


    }
}
