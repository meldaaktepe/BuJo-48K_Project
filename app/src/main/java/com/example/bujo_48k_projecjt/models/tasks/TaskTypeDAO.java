package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class TaskTypeDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract List<Long> Insert(TaskType... taskTypes);

    @Update
    public abstract void Update(TaskType taskType);

    @Transaction
    public void InsertOrUpdate(TaskType taskType)
    {
        long id = Insert(taskType).get(0);
        if (id == -1)
        {
            Update(taskType);
        }
    }

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
