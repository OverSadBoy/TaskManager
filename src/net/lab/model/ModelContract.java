package net.lab.model;

import java.util.Vector;

public interface ModelContract {

    void updateModel(Vector<Task> task);

    void editTask(Task beforeTask, Task afterTask);

    void deleteTask(Task task);

    Vector<Task> getTasks();
}
