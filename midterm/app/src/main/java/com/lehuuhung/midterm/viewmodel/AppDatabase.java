package com.lehuuhung.midterm.viewmodel;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lehuuhung.midterm.model.Coffee;


@Database(entities = Coffee.class, version = 1,  exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CoffeeDao coffeeDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if(instance == null  ){
            instance = Room.databaseBuilder(context,
                            AppDatabase.class, "Coffee")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
