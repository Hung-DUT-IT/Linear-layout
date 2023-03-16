package com.example.contact_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM Contact")
    List<Contact> getAll();

    @Query("SELECT * FROM Contact where id=:id")
    Contact getContact(int id);

    @Insert
    void insert (Contact... contacts);

    @Update
    void update (Contact... contacts);

    @Query("DELETE FROM Contact where id=:id")
    void delete (int id);
}
