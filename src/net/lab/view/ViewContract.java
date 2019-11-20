package net.lab.view;

import net.lab.model.Task;

import java.util.Vector;

public interface ViewContract {

    void addNewTask(Task task);
    void deleteTask(int pos);
    void updateView(Vector<Task> tasks);

}
