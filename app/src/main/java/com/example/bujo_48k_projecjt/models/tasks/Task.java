package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.bujo_48k_projecjt.models.BaseModel;

import java.util.Date;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = TaskType.class,
                parentColumns = "id",
                childColumns = "taskTypeId",
                onDelete = ForeignKey.CASCADE
        )
})
public class Task extends BaseModel
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(index = true)
    public long taskTypeId;

    public String title;
    public Date dueDate;
    public String description;

    public Task(String title, String description, Date dueDate)
    {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
    }
}
