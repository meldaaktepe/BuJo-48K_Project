package com.example.bujo_48k_projecjt.ui.collections;

import android.app.Application;

import com.example.bujo_48k_projecjt.models.collections.CollectionDAO;
import com.example.bujo_48k_projecjt.models.collections.CollectionDatabase;
import com.example.bujo_48k_projecjt.models.collections.CollectionWithItems;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class CollectionRecyclerViewModel extends BaseRecyclerViewModel<CollectionWithItems, BasicAction>
{
    private CollectionDAO collectionDAO;

    public CollectionRecyclerViewModel(Application application)
    {
        super(application);

        collectionDAO = CollectionDatabase.GetInstance(application).GetCollectionDAO();
    }

    @Override
    public void fetchData()
    {
        mData.setValue(collectionDAO.GetAllCollectionsWithItems());
    }
}
