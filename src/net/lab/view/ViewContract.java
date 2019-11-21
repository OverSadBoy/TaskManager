package net.lab.view;

import net.lab.model.Task;

import java.util.Vector;

public interface ViewContract {

    void addNewTask(Task task);
    void deleteTask(Task task);
    void changeTask(Task taskOld,Task taskAct);
    void updateView(Vector<Task> tasks);
    void startEventView(Task task);
}
