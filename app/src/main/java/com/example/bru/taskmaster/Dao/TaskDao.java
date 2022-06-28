package com.example.bru.taskmaster.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.bru.taskmaster.models.Tasks;

import java.util.List;
@Dao
public interface TaskDao {
    @Insert
    void insertATask(Tasks task);

    @Query("SELECT * FROM Tasks")
    List<Tasks> findAll();

    @Query("SELECT * FROM Tasks WHERE id = :id")
    Tasks findByAnId(Long id);
}
