package com.example.bujo_48k_projecjt.models;

import java.util.Date;

public class Task extends BaseModel
{
    private String title;
    private TaskType taskClass;
    private Date dueDate;
    private String description;

    public Task(String title, String description, Date dueDate, TaskType taskClass) {
        this.title = title;
        this.taskClass = taskClass;
        this.dueDate = dueDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskType getTaskClass() {
        return taskClass;
    }

    public void setTaskClass(TaskType taskClass) {
        this.taskClass = taskClass;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
