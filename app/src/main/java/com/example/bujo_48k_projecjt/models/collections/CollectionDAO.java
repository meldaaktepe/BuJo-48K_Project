package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class CollectionDAO
{
    //    @Insert
    //    public abstract void Insert(collection... collections);

    @Insert
    public abstract void InsertWithItems(Collection collection, List<Item> items);

    @Delete
    protected abstract void Delete(Collection collection);

    @Query("SELECT * FROM Collection")
    public abstract List<CollectionWithItems> GetAllCollectionsWithItems();

}
