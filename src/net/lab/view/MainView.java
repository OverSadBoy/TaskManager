package net.lab.view;

import net.lab.model.ModelContract;
import net.lab.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class MainView extends JFrame implements ViewContract {

    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JTable table;
    private ModelContract model;
    private Vector<Task> tasks;

    public MainView(ModelContract model) throws HeadlessException {
        super("Task Manager");
        inflateView();
        setListener();
        tasks = new Vector<>();
        tasks.add(new Task("Work","my main mork",new SimpleDateFormat("13.05.2019"),"23-43-555"));
        this.model = model;
        tasks = model.getTasks();
        updateView(tasks);
        startEventView(new Task("Gym","enjoin",new SimpleDateFormat("12.03.2020"),"8-800-555-35-35"));
    }

    private void inflateView() {
        setBounds(400, 150, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        tableNameCol();
        setVisible(true);
    }

    private void setListener() {
        addTaskButton.addActionListener(e -> new AddView(this));
        deleteTaskButton.addActionListener(e -> deleteTask(tasks.get(table.getSelectedRow())));
    }

    @Override
    public void updateView(Vector<Task> tasks) {
        table.setModel(new TableModel(toNormalVector(tasks), namCol));
    }

    @Override
    public void addNewTask(Task task) {
        tasks.add(task);
        updateView(tasks);
    }

    @Override
    public void changeTask(Task taskOld, Task taskAct) {
        tasks.remove(taskOld);
        tasks.add(taskAct);
        updateView(tasks);
    }

    @Override
    public void deleteTask(Task task) {
        tasks.remove(task);
        updateView(tasks);
    }

    public void startEventView(Task task) {
        new EventView(this, task);
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
            task.add(value.getNotificationDate().format(new Date()));
            task.add(value.getContacts());
            data.add(task);
        }
        return data;
    }

    static class TableModel extends DefaultTableModel {
        TableModel(Vector<Vector<String>> data, Vector namCol) {
            super(data, namCol);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }
}
