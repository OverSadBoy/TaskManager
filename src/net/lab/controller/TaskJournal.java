package net.lab.controller;
import net.lab.model.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskJournal implements Serializable {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskJournal(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskJournal() {
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskNumber) {
        tasks.remove(taskNumber);
    }
}
