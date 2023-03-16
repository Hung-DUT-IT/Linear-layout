package com.example.contact_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Contact.class, version = 1,  exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDAO();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if(instance == null  ){
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "contacts")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }
}
