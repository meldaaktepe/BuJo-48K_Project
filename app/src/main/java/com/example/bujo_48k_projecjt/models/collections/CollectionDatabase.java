package com.example.bujo_48k_projecjt.models.collections;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Random;

@Database(version = 5, entities = {Item.class, Collection.class})
public abstract class CollectionDatabase extends RoomDatabase
{
    static private CollectionDatabase instance = null;

    static public CollectionDatabase GetInstance(Context context)
    {
        if (instance == null)
        {
            instance = Room.databaseBuilder(context, CollectionDatabase.class, "Collection Database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

            instance.PopulateInitialData();
        }

        return instance;
    }

    private void PopulateInitialData()
    {
        CollectionDAO collectionDAO = GetCollectionDAO();

        if (collectionDAO.HasAny()) return;

        collectionDAO.DeleteAll();
        collectionDAO.Insert(
                new Collection("collection 1"),
                new Collection("collection 2"),
                new Collection("collection 3")
        );

        ItemDAO itemDAO = GetItemDAO();

        // Iterate on Collections from database so their ids will be valid
        for (Collection collection : collectionDAO.GetAll())
        {
            int item_count = new Random().nextInt(2) + 3; // 3 to 5 items for each Collection

            for (int i = 0; i < item_count; i++)
            {
                itemDAO.InsertItemsToCollection(
                        collection,
                        new Item("Item number " + i + " of collection[" + collection.id + "]")
                );
            }
        }
    }

    public abstract CollectionDAO GetCollectionDAO();

    public abstract ItemDAO GetItemDAO();
}
