package com.example.bujo_48k_projecjt.ui.items.item_recycler;

import android.app.Application;

import com.example.bujo_48k_projecjt.models.collections.CollectionDAO;
import com.example.bujo_48k_projecjt.models.collections.CollectionDatabase;
import com.example.bujo_48k_projecjt.models.collections.Item;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class ItemRecyclerViewModel extends BaseRecyclerViewModel<Item, BasicAction>
{
    private CollectionDAO collectionDAO;
    private long collectionId;

    public ItemRecyclerViewModel(Application application)
    {
        super(application);

        collectionDAO = CollectionDatabase.GetInstance(application).GetCollectionDAO();
    }

    public ItemRecyclerViewModel SetCollectionId(long id)
    {
        collectionId = id;
        return this;
    }

    @Override
    public void fetchData()
    {
        mData.setValue(collectionDAO.GetWithItems(collectionId).items);
    }
}
