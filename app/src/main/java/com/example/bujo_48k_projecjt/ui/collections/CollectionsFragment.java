package com.example.bujo_48k_projecjt.ui.collections;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.ui.collections.collection_recycler.CollectionRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.collections.collection_recycler.CollectionRecyclerViewModel;
import com.example.bujo_48k_projecjt.ui.common.BaseFragment;
import com.example.bujo_48k_projecjt.ui.items.ItemsActivity;

public class CollectionsFragment extends BaseFragment
{
    private CollectionsViewModel collectionsViewModel;

    private CollectionRecyclerViewModel collectionRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_collections;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        collectionsViewModel = ViewModelProviders.of(this).get(CollectionsViewModel.class);

        BindCollectionRecyclerView(view);
        collectionRecyclerViewModel.fetchData();
    }

    private void BindCollectionRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.collection_list);

        collectionRecyclerViewModel = ViewModelProviders.of(this).get(CollectionRecyclerViewModel.class);

        CollectionRecyclerViewAdapter adapter = new CollectionRecyclerViewAdapter(
                collectionRecyclerViewModel,
                this
        );

        collectionRecyclerViewModel.observeAction(this, chatAction ->
        {
            if (chatAction == null) return;

            switch (chatAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    OnRecyclerItemClicked(chatAction.getModel());
                    break;
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void OnRecyclerItemClicked(Collection collection)
    {
        startActivity(
                ItemsActivity.CreateIntent(getContext(), collection)
        );
    }
}