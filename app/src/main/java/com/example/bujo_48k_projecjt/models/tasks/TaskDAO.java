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
public abstract class TaskDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract List<Long> Insert(Task... tasks);

    public List<Long> InsertTaskWithType(TaskType taskType, Task... tasks)
    {
        for (Task item : tasks)
        {
            item.taskTypeId = taskType.id;
        }

        return Insert(tasks);
    }

    public void InsertOrUpdate(TaskType taskType, Task task)
    {
        long id = InsertTaskWithType(taskType, task).get(0);
        if (id == -1)
        {
            task.taskTypeId = taskType.id;
            Update(task);
        }
    }

    @Update
    public abstract void Update(Task task);

    @Query("SELECT * FROM Task WHERE id=:id")
    public abstract Task Get(long id);

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

    @Delete
    public abstract void Delete(Task value);

    @Query("DELETE FROM Task")
    public abstract void DeleteAll();
}
