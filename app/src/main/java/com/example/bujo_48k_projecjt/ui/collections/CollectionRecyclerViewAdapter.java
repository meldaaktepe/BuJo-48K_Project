package com.example.bujo_48k_projecjt.ui.collections;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.collections.CollectionWithItems;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class CollectionRecyclerViewAdapter extends BaseRecyclerViewAdapter<CollectionWithItems, BasicAction>
{
    public CollectionRecyclerViewAdapter(
            BaseRecyclerViewModel<CollectionWithItems, BasicAction> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, CollectionWithItems model)
    {
        binding.setVariable(com.example.bujo_48k_projecjt.BR.viewModel, new CollectionWithItemsItemViewModel(model));
    }

    @Override
    protected int getItemViewId()
    {
        return R.layout.collection_with_items_item;
    }
}
