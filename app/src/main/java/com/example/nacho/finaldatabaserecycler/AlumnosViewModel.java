package com.example.nacho.finaldatabaserecycler;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class AlumnosViewModel extends AndroidViewModel {

    private AlumnosRepository mRepository;
    private LiveData<List<Alumnos>> mAllAlumnos;

    public AlumnosViewModel (Application application) {
        super(application);
        mRepository = new AlumnosRepository(application);
        mAllAlumnos = mRepository.getAllWords();
    }

    LiveData<List<Alumnos>> getAllWords() { return mAllAlumnos; }

    public void insert(Alumnos alumnos) { mRepository.insert(alumnos); }

}
