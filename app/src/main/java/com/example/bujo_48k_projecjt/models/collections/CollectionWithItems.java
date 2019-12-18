package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Relation;

import java.util.List;

public class CollectionWithItems extends Collection
{
    @Relation(
            parentColumn = "id",
            entityColumn = "collectionId"
    )
    public List<Item> items;

    public CollectionWithItems(String title)
    {
        super(title);
    }
}
