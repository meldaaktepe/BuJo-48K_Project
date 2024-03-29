package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public abstract class CollectionDAO
{
    @Insert
    public abstract void Insert(Collection... collections);

    @Delete
    public abstract void Delete(Collection collection);

    @Query("SELECT * FROM Collection WHERE id=:id")
    public abstract Collection Get(long id);

    @Query("SELECT * FROM Collection")
    public abstract List<Collection> GetAll();

    @Transaction
    @Query("SELECT * FROM Collection WHERE id=:id")
    public abstract CollectionWithItems GetWithItems(long id);

    @Transaction
    @Query("SELECT * FROM Collection")
    public abstract List<CollectionWithItems> GetAllWithItems();

    @Query("SELECT COUNT(*) FROM Collection LIMIT 1")
    public abstract boolean HasAny();

    @Query("DELETE FROM Collection")
    public abstract void DeleteAll();
}
