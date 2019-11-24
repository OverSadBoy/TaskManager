package net.lab.controller;

import net.lab.model.ModelContract;
import net.lab.model.Task;
import net.lab.view.AddView;
import net.lab.view.EventView;
import net.lab.view.MainView;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Controller implements Serializable, ControllerContract {

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
        mainView.getDeleteTaskButton().addActionListener(actionEvent -> deleteTask(tasks.get(mainView.getTable().getSelectedRow())));
    }

    private void initAddController() {
        addView.getAddButton().addActionListener(actionEvent -> {
            try {
                addTask(getNewTask());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            addView.dispose();
        });
        addView.getCancelButton().addActionListener(actionEvent -> addView.dispose());
    }

    private void initChangeController(Task task) {
        addView.getAddButton().addActionListener(actionEvent -> {
            try {
                changeTask(task, getNewTask());
            } catch (ParseException e) {
                e.printStackTrace();
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
        return new Task(addView.getNameTask(), addView.getDescription(), Task.dateFormat.parse(addView.getDate()), addView.getContacts());
    }

    private static Vector<String> namCol = new Vector<>(4);

    private void tableNameCol() {
        namCol.add("Name");
        namCol.add("Description");
        namCol.add("Notification date");
        namCol.add("Contacts");
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
            for (var task :
                    taskList) {
                Date currentDate = new Date();
                if (!isCalled && currentDate.after(task.getNotificationDate())) {
                    isCalled = true;
                    eventView = new EventView(mainView, task);
                    initEventController(task);
                }
            }
        }
    }

}
