package com.example.bujo_48k_projecjt.ui.collections;

import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

public class CollectionItemViewModel extends BaseViewModel<Collection, BasicAction>
{
    public Collection collection;

    public CollectionItemViewModel(Collection collection)
    {
        this.collection = collection;
    }
}
