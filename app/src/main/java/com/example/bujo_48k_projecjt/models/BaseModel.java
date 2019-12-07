package com.example.bujo_48k_projecjt.models;

import androidx.databinding.BaseObservable;

public abstract class BaseModel extends BaseObservable
{
    public String getContent()
    {
        return toString();
    }
}
