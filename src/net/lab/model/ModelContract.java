package net.lab.model;

import java.util.Vector;

public interface ModelContract {

    void addTask(Task task);
    void deleteTask(Task task);
    Vector<Task> getTasks();
}
