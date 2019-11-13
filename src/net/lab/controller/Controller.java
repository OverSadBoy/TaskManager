package net.lab.controller;

import net.lab.model.Model;
import net.lab.model.ModelContract;
import net.lab.model.Task;
import net.lab.view.ViewContract;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Controller implements Serializable, ControllerContract {

    private ModelContract model;
    private ViewContract view;
    private Vector<Task> tasks;
    private static final String fileName = "data.bin";

    public Controller(ModelContract model, ViewContract view) {
        this.model = model;
        this.view = view;
     //   tasks = model.getTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        model.addTask(task);
        view.updateView(tasks);
    }

    public void deleteTask(Task task) {
        tasks.remove(task.getId());
        model.deleteTask(task);
        view.updateView(tasks);
    }

    @Override
    public void editTask(Task beforeTask, Task afterTask) {

    }

    //TODO ДОБАВИТЬ ЗАГРУЗКУ В ВЕКТОР
    public void loadJournal(Vector<Task> tasks) {

    }


}
