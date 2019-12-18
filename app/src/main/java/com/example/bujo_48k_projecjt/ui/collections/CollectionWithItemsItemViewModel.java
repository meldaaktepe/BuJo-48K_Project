package com.example.bujo_48k_projecjt.ui.collections;

import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.models.collections.CollectionWithItems;
import com.example.bujo_48k_projecjt.models.collections.Item;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

import java.util.List;

public class CollectionWithItemsItemViewModel extends BaseViewModel<CollectionWithItems, BasicAction>
{
    private CollectionWithItems collectionWithItems;
    public List<Item> items;
    public Collection collection;

    public CollectionWithItemsItemViewModel(CollectionWithItems collectionWithItems)
    {
        this.collectionWithItems = collectionWithItems;
        this.collection = collectionWithItems.collection;
        this.items = collectionWithItems.items;
    }
}
