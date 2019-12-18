package com.example.bujo_48k_projecjt.ui.common.Action;

import com.example.bujo_48k_projecjt.models.BaseModel;

public class Action<Model extends BaseModel, ActionType extends Enum>
{
    private Model mModel;
    private ActionType mActionType;

    public Action(Model model, ActionType actionType)
    {
        mModel = model;
        mActionType = actionType;
    }

    public Model getModel()
    {
        return mModel;
    }

    public ActionType getActionType()
    {
        return mActionType;
    }
}
