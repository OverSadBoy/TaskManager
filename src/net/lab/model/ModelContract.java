package net.lab.model;

import java.util.Vector;

public interface ModelContract {

    void updateModel(Vector<Task> task);

    Vector<Task> getTasks();
}
