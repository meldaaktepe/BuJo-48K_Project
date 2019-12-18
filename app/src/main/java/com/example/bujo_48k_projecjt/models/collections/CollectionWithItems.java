package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.bujo_48k_projecjt.models.BaseModel;

import java.util.List;

public class CollectionWithItems extends BaseModel
{
    @Embedded
    public Collection collection;
    @Relation(
            parentColumn = "id",
            entityColumn = "listId"
    )
    public List<Item> items;
}
