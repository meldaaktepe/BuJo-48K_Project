package com.example.bujo_48k_projecjt.ui.collections.collection_recycler;

import android.view.View;

import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.ui.common.Action.Action;
import com.example.bujo_48k_projecjt.ui.common.Action.BasicAction;
import com.example.bujo_48k_projecjt.ui.common.BaseAndroidViewModel;
import com.example.bujo_48k_projecjt.ui.common.RecyclerView.BaseRecyclerItemViewModel;

public class CollectionItemViewModel extends BaseRecyclerItemViewModel<Collection, BasicAction>
{
    public CollectionItemViewModel(BaseAndroidViewModel<Collection, BasicAction> viewModel, Collection model)
    {
        super(viewModel, model);
    }

    public void OnClick(View view)
    {
        mViewModel.setAction(new Action<>(mModel, BasicAction.RECYCLER_ITEM_CLICK));
    }
}
