package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDAO
{
    @Insert
    public void Insert(Item... items);

    @Query("SELECT * FROM Item")
    public abstract List<Item> GetAllItems();
}
