package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.bujo_48k_projecjt.models.BaseModel;

@Entity
public class Collection extends BaseModel
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String title;

    public Collection(String title)
    {
        this.title = title;
    }
}

