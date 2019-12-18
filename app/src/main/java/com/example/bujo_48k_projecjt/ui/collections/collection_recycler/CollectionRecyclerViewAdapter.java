package com.example.bujo_48k_projecjt.ui.collections.collection_recycler;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;

import com.example.bujo_48k_projecjt.BR;
import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerViewModel;

public class CollectionRecyclerViewAdapter extends BaseRecyclerViewAdapter<Collection, BasicAction>
{
    public CollectionRecyclerViewAdapter(
            BaseRecyclerViewModel<Collection, BasicAction> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        super(baseRecyclerViewModel, lifecycleOwner);
    }

    @Override
    protected void setViewHolderBindings(ViewDataBinding binding, Collection model)
    {
        binding.setVariable(BR.viewModel, new CollectionItemViewModel(mViewModel, model));
    }

    @Override
    protected int getItemViewId()
    {
        return R.layout.collection_with_items_item;
    }
}
