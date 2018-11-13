package com.example.nacho.finaldatabaserecycler;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


@Database(entities = {Alumnos.class}, version = 2)


public abstract class AlumnosRoomDatabase extends RoomDatabase {

    public abstract AlumnosDao alumnosDao();
    private static AlumnosRoomDatabase INSTANCE;

    public static AlumnosRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AlumnosRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AlumnosRoomDatabase.class, BuildConfig.DATABASE_NAME)
                            .fallbackToDestructiveMigration().addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new StudentsAsyncTask(INSTANCE).execute();
                    //Hay que implementar la libreria necesaria
                    /*doAsync(){

                    }*/
                }
            };

}
   class StudentsAsyncTask extends AsyncTask<Void, Void, Void> {

    private final AlumnosDao mDao;

    public StudentsAsyncTask (AlumnosRoomDatabase instance){
        mDao = instance.alumnosDao();

    }

    @Override
    protected Void doInBackground(Void... voids) {

        Alumnos first = new Alumnos(0, "Nacho","2ºDAMP","David", 6);
        Alumnos second = new Alumnos(1, "David","1ºDAMP","Pedro", 7);
        Alumnos third = new Alumnos(2, "Pablo","2ºAGEI","Joaquín", 5);
        Alumnos fourth = new Alumnos(3, "Susana","2ºDAMP","David", 6);
        Alumnos fifth = new Alumnos(4, "Pepe","1ºDAMP","Pedro", 7);
        Alumnos sixth = new Alumnos(5, "Lucía","1ºAGEI","Clara", 4);

        List<Alumnos> values = new ArrayList<>();

        values.add(first);
        values.add(second);
        values.add(third);
        values.add(fourth);
        values.add(fifth);
        values.add(sixth);

        mDao.deleteAll();

        mDao.insertAll(values);
        return null;
    }
}
