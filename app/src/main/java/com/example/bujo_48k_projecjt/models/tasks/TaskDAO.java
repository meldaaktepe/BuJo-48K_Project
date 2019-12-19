package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public abstract class TaskDAO
{
    @Insert
    protected abstract void Insert(Task... tasks);

    public void InsertTaskWithType(TaskType taskType, Task... tasks)
    {
        for (Task item : tasks)
        {
            item.taskTypeId = taskType.id;
        }

        Insert(tasks);
    }

    @Query("SELECT * FROM Task WHERE id=:id")
    public abstract List<Task> Get(long id);

    @Query("SELECT * FROM Task")
    public abstract List<Task> GetAll();

    @Transaction
    @Query("SELECT * FROM Task WHERE id=:id")
    public abstract TaskWithType GetWithType(long id);

    @Transaction
    @Query("SELECT * FROM Task")
    public abstract List<TaskWithType> GetAllWithTypes();

    @Query("SELECT COUNT(*) FROM Task LIMIT 1")
    public abstract boolean HasAny();

    @Query("DELETE FROM Task")
    public abstract void DeleteAll();
}
