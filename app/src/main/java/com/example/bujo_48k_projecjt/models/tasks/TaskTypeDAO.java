package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class TaskTypeDAO
{
    @Insert
    public abstract void Insert(TaskType... taskTypes);

    @Delete
    public abstract void Delete(TaskType taskType);

    @Query("SELECT * FROM TaskType WHERE id=:id")
    public abstract TaskType Get(long id);

    @Query("SELECT * FROM TaskType")
    public abstract List<TaskType> GetAll();

    @Query("SELECT COUNT(*) FROM TaskType LIMIT 1")
    public abstract boolean HasAny();

    @Query("DELETE FROM TaskType")
    public abstract void DeleteAll();
}
