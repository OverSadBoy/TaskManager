package net.lab.controller;

import net.lab.model.Task;

import java.util.Vector;

public interface ControllerContract {

    void addTask(Vector<Task> tasks);
    void deleteTask(Task task);
    void editTask(Task beforeTask,Task afterTask);
    void loadJournal();
}
