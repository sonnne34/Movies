package com.sonne.movies.data.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sonne.movies.data.models.Movie;

@Database(entities = {Movie.class}, version = 2, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "movie.db";
    private static MovieDatabase instance = null;
    public static MovieDatabase getInstance(Application application) {
        if (instance == null){
            instance = Room.databaseBuilder(
                    application,
                    MovieDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract MovieDao movieDao();
}
