package com.example.bujo_48k_projecjt.ui.common.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bujo_48k_projecjt.models.BaseModel;
import com.example.bujo_48k_projecjt.ui.common.BaseViewModel;

import java.util.ArrayList;

public abstract class BaseRecyclerViewAdapter<Model extends BaseModel, ActionType> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder>
{
    static private final String TAG = "BaseRecyclerViewAdapter";

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private ViewDataBinding mBinding;

        ViewHolder(View instructorView, ViewDataBinding binding)
        {
            super(instructorView);

            mBinding = binding;
        }
    }

    protected final ArrayList<Model> mData = new ArrayList<>();
    protected final BaseViewModel<Model, ActionType> mViewModel;

    protected abstract void setViewHolderBindings(ViewDataBinding binding, Model model);

    protected abstract int getItemViewId();

    public BaseRecyclerViewAdapter(
            BaseRecyclerViewModel<Model, ActionType> baseRecyclerViewModel,
            LifecycleOwner lifecycleOwner)
    {
        this(baseRecyclerViewModel.getLiveData(), baseRecyclerViewModel, lifecycleOwner);
    }

    public BaseRecyclerViewAdapter(
            MutableLiveData<ArrayList<Model>> observableData,
            BaseViewModel<Model, ActionType> viewModel,
            LifecycleOwner lifecycleOwner)
    {
        super();

        Log.d(TAG, "Created -> " + this.getClass().getSimpleName());

        observableData.observe(lifecycleOwner, new Observer<ArrayList<Model>>()
        {
            @Override
            public void onChanged(@Nullable ArrayList<Model> changedData)
            {
                setData(changedData);
            }
        });

        mViewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                getItemViewId(),
                parent,
                false
        );

        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewAdapter.ViewHolder holder, int position)
    {
        setViewHolderBindings(holder.mBinding, mData.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public void setData(final ArrayList<Model> newData)
    {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback()
        {
            @Override
            public int getOldListSize()
            {
                return mData.size();
            }

            @Override
            public int getNewListSize()
            {
                return newData.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition)
            {
                return mData.get(oldItemPosition).equals(newData.get(newItemPosition));
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition)
            {
                return mData.get(oldItemPosition).getContent().equals(newData.get(newItemPosition).getContent());
            }
        });

        mData.clear();
        mData.addAll(newData);

        diffResult.dispatchUpdatesTo(this);
    }
}