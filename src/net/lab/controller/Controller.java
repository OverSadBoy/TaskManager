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

    public Controller(ModelContract model, ViewContract view) throws InterruptedException {
        this.model = model;
        this.view = view;
        loadJournal();
    }

    public void addTask(Vector<Task> tasks) {
        model.addTask(tasks);
        view.updateView(model.getTasks());
    }

    public void deleteTask(Task task) {
        model.deleteTask(task);
        view.updateView(model.getTasks());
    }

    @Override
    public void editTask(Task beforeTask, Task afterTask) {

    }

    public void loadJournal() {
        // view.updateView(model.getTasks());
    }

    private void checkDate() {
        new Thread(() -> {
            while (true) {

            }
        });
    }

}
