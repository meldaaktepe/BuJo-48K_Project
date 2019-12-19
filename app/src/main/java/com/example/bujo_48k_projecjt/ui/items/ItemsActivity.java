package com.example.bujo_48k_projecjt.ui.items;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.R;
import com.example.bujo_48k_projecjt.models.collections.Collection;
import com.example.bujo_48k_projecjt.ui.common.BaseActivity;
import com.example.bujo_48k_projecjt.ui.items.item_recycler.ItemRecyclerViewAdapter;
import com.example.bujo_48k_projecjt.ui.items.item_recycler.ItemRecyclerViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ItemsActivity extends BaseActivity
{
    ItemRecyclerViewModel itemRecyclerViewModel;

    @Override
    protected int getLayoutId()
    {
        return R.layout.activity_items;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            String collectionTitle = getIntent().getStringExtra(collectionTitleKey);
            actionBar.setTitle(collectionTitle);

            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        FloatingActionButton fab = findViewById(R.id.items_floating_button);
        fab.setOnClickListener(view -> Snackbar
                .make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        );

        View view = mViewDataBinding.getRoot();
        BindCollectionRecyclerView(view);

        long collectionId = getIntent().getLongExtra(collectionIdKey, 1);
        itemRecyclerViewModel.SetCollectionId(collectionId).fetchData();
    }

    private void BindCollectionRecyclerView(View view)
    {
        RecyclerView recyclerView = view.findViewById(R.id.item_list);

        itemRecyclerViewModel = ViewModelProviders.of(this).get(ItemRecyclerViewModel.class);

        ItemRecyclerViewAdapter adapter = new ItemRecyclerViewAdapter(
                itemRecyclerViewModel,
                this
        );

        itemRecyclerViewModel.observeAction(this, chatAction ->
        {
            if (chatAction == null) return;

            switch (chatAction.getActionType())
            {
                case RECYCLER_ITEM_CLICK:
                    Log.d("RECYCLER_ITEM_CLICK", "will try to ");
                    break;
            }
        });

        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private static final String collectionIdKey = "collectionId";
    private static final String collectionTitleKey = "collectionTitle";

    public static Intent CreateIntent(Context context, Collection collection)
    {
        Intent intent = new Intent(context, ItemsActivity.class);
        intent.putExtra(collectionIdKey, collection.id);
        intent.putExtra(collectionTitleKey, collection.title);
        return intent;
    }
}
