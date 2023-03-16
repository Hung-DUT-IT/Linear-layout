package com.lehuuhung.midterm.viewmodel;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lehuuhung.midterm.model.Coffee;

import java.util.List;

@Dao
public interface CoffeeDao {
    @Query("SELECT * FROM Coffee")
    List<Coffee> getAll();

    @Query("SELECT * FROM Coffee where id=:id")
    Coffee getContact(int id);

    @Insert
    void insert (Coffee... contacts);

    @Update
    void update (Coffee... contacts);

    @Query("DELETE FROM Coffee where id=:id")
    void delete (int id);
}
