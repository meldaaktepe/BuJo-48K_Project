package com.example.bujo_48k_projecjt.models.collections;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.bujo_48k_projecjt.models.BaseModel;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Collection.class,
                parentColumns = "id",
                childColumns = "collectionId",
                onDelete = ForeignKey.CASCADE
        )
})
public class Item extends BaseModel
{
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String text;

    public long collectionId;

    public Item(String text)
    {
        this.text = text;
    }
}
