package com.example.bujo_48k_projecjt.models.tasks;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.bujo_48k_projecjt.models.BaseModel;

@Entity
public class TaskType extends BaseModel
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    public int importance;
    public String emoji;
    public int color;

    public TaskType(int importance, String emoji, int color)
    {
        this.importance = importance;
        this.emoji = emoji;
        this.color = color;
    }
}
