package com.example.nacho.finaldatabaserecycler;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AlumnosRepository {
    private AlumnosDao mAlumnoDao;
    private LiveData<List<Alumnos>> mAllAlumnos;

    AlumnosRepository(Application application) {
        AlumnosRoomDatabase db = AlumnosRoomDatabase.getDatabase(application);
        mAlumnoDao = db.alumnosDao();
        mAllAlumnos = mAlumnoDao.getAllWords();
    }


    LiveData<List<Alumnos>> getAllWords() {
        return mAllAlumnos;
    }

    public void insert (Alumnos word) {
        new insertAsyncTask(mAlumnoDao).execute(word);
    }

}
  class insertAsyncTask extends AsyncTask<Alumnos, Void, Void> {

    private AlumnosDao mAsyncTaskDao;

    insertAsyncTask(AlumnosDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Alumnos... params) {
        mAsyncTaskDao.insert(params[0]);
        return null;
    }
}