package net.lab.view;

import net.lab.model.ModelContract;
import net.lab.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

public class MainView extends JFrame implements ViewContract {


    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JScrollPane ScrollPane;
    private JTable table;
    private ModelContract model;
    private Vector<Task> tasks;


    public MainView(ModelContract model) throws HeadlessException {
        super("Task Manager");
        inflateView();
        setListener();
        tasks = model.getTasks();
        this.model = model;
        tableNameCol();
        updateView(tasks);
        setVisible(true);
    }

    private void setListener() {
        addTaskButton.addActionListener(e -> new AddView(this));

        deleteTaskButton.addActionListener(e -> deleteTask(table.getSelectedRow()));
    }

    private void inflateView() {
        setBounds(400, 150, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
    }

    public Vector<Task> getTasks() {
        return tasks;
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
    public void deleteTask(int pos) {
        tasks.remove(pos);
        updateView(tasks);
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
            task.add(value.getNotificationDate());
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
