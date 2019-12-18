package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class ItemDAO
{
    @Insert
    protected abstract void Insert(Item... items);

    public void InsertItemsToCollection(Collection collection, Item... items)
    {
        for (Item item : items)
        {
            item.collectionId = collection.id;
        }

        Insert(items);
    }

    @Query("SELECT * FROM Item")
    public abstract List<Item> GetAllItems();

    @Query("SELECT * FROM Item LIMIT 1")
    public abstract Item GetSingleTask();

    public boolean HasAny()
    {
        return GetSingleTask() == null;
    }

    @Query("DELETE FROM Item")
    public abstract void DeleteAll();
}
