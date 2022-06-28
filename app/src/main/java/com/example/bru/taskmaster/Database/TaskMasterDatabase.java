package com.example.bru.taskmaster.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.bru.taskmaster.Dao.TaskDao;
import com.example.bru.taskmaster.models.Tasks;

@Database(entities = {Tasks.class}, version = 1)
public abstract class TaskMasterDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
