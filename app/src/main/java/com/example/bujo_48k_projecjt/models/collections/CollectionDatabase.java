package com.example.bujo_48k_projecjt.models.collections;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Database(version = 1, entities = {Item.class, Collection.class})
public abstract class CollectionDatabase extends RoomDatabase
{
    static private CollectionDatabase instance = null;

    static public CollectionDatabase GetInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, CollectionDatabase.class, "Item Database")
                    .allowMainThreadQueries()
                    .build();

            instance.PopulateInitialData();
        }

        return instance;
    }

    private void PopulateInitialData()
    {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("item 1"),
                new Item("item 2"),
                new Item("item 3"),
                new Item("item 4")
        ));

        CollectionDAO collectionDAO = GetCollectionDAO();
        collectionDAO.InsertWithItems(new Collection("collection 1"), items);
        collectionDAO.InsertWithItems(new Collection("collection 2"), items);
        collectionDAO.InsertWithItems(new Collection("collection 3"), items);
    }

    public abstract CollectionDAO GetCollectionDAO();
}
