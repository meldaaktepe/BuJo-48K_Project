package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.bujo_48k_projecjt.models.BaseModel;

@Entity
public class TaskType extends BaseModel
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String name;
    public int priority;
    public String emoji;
    public int color;

    public TaskType(String name, int priority, String emoji, int color)
    {
        this.name = name;
        this.priority = priority;
        this.emoji = emoji;
        this.color = color;
    }
}
