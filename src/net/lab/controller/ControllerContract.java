package net.lab.controller;

import net.lab.model.Task;

public interface ControllerContract {
    void addTask(Task task);

    void deleteTask(Task task);

    void changeTask(Task taskOld, Task taskNew);
}
