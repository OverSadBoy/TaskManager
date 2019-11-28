package net.lab.controller;

import net.lab.model.*;
import net.lab.view.*;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import static net.lab.utils.ControllerUtils.*;

public class Controller implements ControllerContract {

    private final ModelContract model;
    private final MainView mainView;
    private AddView addView;
    private EventView eventView;
    private boolean isCalled = false;
    private Vector<Task> tasks;

    public Controller(ModelContract model, MainView view) {
        this.model = model;
        tasks = model.getTasks();
        this.mainView = view;
        tableNameCol();
        initView();
        initMainController();
        listenToSystemDate();
    }

    private void initView() {
        mainView.updateView(toNormalVector(model.getTasks()), namCol);
    }

    private void initMainController() {
        mainView.getAddTaskButton().addActionListener(actionEvent -> {
            addView = new AddView();
            initAddController();
        });
        mainView.getDeleteTaskButton().addActionListener(actionEvent -> {
            if (mainView.getTable().getSelectedRow() >= 0)
                deleteTask(tasks.get(mainView.getTable().getSelectedRow()));
        });
    }

    private void initAddController() {
        addView.getAddButton().addActionListener(actionEvent -> {
            if (!addView.getDate().getText().equals("") && !addView.getNameTask().equals("")) {
                try {
                    addTask(getNewTask());
                    addView.dispose();
                } catch (ParseException e) {
                    new ErrorView(INVALID_DATE_FORMAT);
                    addView.getDate().setText("");
                    addView.getDateLable().setForeground(Color.RED);
                }
            }
        });
        addView.getCancelButton().addActionListener(actionEvent -> addView.dispose());
    }

    private void initChangeController(Task task) {
        addView.getAddButton().addActionListener(actionEvent -> {
            try {
                changeTask(task, getNewTask());
            } catch (ParseException e) {
                new ErrorView(ERROR);
            }
            addView.dispose();
            isCalled = false;
        });
        addView.getCancelButton().addActionListener(actionEvent -> {
            addView.dispose();
            isCalled = false;
        });
    }


    private void initEventController(Task task) {
        eventView.getButtonEndTask().addActionListener(actionEvent -> {
            deleteTask(task);
            eventView.dispose();
            isCalled = false;
        });
        eventView.getDeferBtn().addActionListener(actionEvent -> {
            addView = new AddView(task);
            initChangeController(task);
            eventView.dispose();
        });
    }

    public void addTask(Task task) {
        tasks.add(task);
        model.updateModel(tasks);
        initView();
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        model.updateModel(tasks);
        initView();
    }

    public void changeTask(Task taskOld, Task taskNew) {
        tasks.remove(taskOld);
        tasks.add(taskNew);
        model.updateModel(tasks);
        initView();
    }

    private Task getNewTask() throws ParseException {
        return new Task(addView.getNameTask(), addView.getDescription(), Task.dateFormat.parse(addView.getDate().getText()), addView.getContacts());
    }

    private static Vector<String> namCol = new Vector<>(4);

    private void tableNameCol() {
        namCol.add(NAME);
        namCol.add(DESCRIPTION);
        namCol.add(NOTIFICATION_DATE);
        namCol.add(CONTACTS);
    }

    private Vector<Vector<String>> toNormalVector(Vector<Task> tasks) {
        Vector<Vector<String>> data = new Vector<>();
        for (Task value : tasks) {
            Vector<String> task = new Vector<>();
            task.add(value.getName());
            task.add(value.getDescription());
            task.add(Task.dateFormat.format(value.getNotificationDate()));
            task.add(value.getContacts());
            data.add(task);
        }
        return data;
    }

    private void listenToSystemDate() {
        while (true) {
            var taskList = (Vector<Task>) tasks.clone();
            for (var task : taskList) {
                Date currentDate = new Date();
                if (!isCalled && currentDate.after(task.getNotificationDate())) {
                    isCalled = true;
                    eventView = new EventView(task);
                    initEventController(task);
                }
            }
        }
    }

}
