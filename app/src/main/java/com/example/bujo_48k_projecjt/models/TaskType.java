package com.example.bujo_48k_projecjt.models;

public class TaskType extends BaseModel
{
    private int importance;
    private String emoji;
    private int color;

    public TaskType(int importance, String emoji, int color)
    {
        this.importance = importance;
        this.emoji = emoji;
        this.color = color;
    }

    public int getImportance()
    {
        return importance;
    }

    public void setImportance(int importance)
    {
        this.importance = importance;
    }

    public String getEmoji()
    {
        return emoji;
    }

    public void setEmoji(String emoji)
    {
        this.emoji = emoji;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }
}
