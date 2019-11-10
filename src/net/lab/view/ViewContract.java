package net.lab.view;

import net.lab.model.Task;

import java.util.Vector;

public interface ViewContract {

    Task getAddTask();
    void updateView(Vector<Task> tasks);

}
