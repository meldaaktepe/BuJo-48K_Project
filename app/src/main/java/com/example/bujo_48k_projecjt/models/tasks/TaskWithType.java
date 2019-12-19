package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Relation;

import java.util.Date;

public class TaskWithType extends Task
{
    @Relation(
            parentColumn = "taskTypeId",
            entityColumn = "id"
    )
    public TaskType taskType;

    public TaskWithType(String title, String description, Date dueDate)
    {
        super(title, description, dueDate);
    }
}
