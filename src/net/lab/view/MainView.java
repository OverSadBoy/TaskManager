package net.lab.view;

import net.lab.model.ModelContract;
import net.lab.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class MainView extends JFrame implements ViewContract {


    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JScrollPane ScrollPane;
    private JTable table;

    private ModelContract model;


    public MainView(ModelContract model) throws HeadlessException {
        super("Task Manager");
        setBounds(400, 150, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        initComponents();
        this.model = model;
        updateView(model.getTasks());
        setVisible(true);
    }

    private void initComponents() {
        addTaskButton.addActionListener(e -> {
            AddView addTaskUI = new AddView();
        });

        deleteTaskButton.addActionListener(e -> {

        });
    }


    @Override
    public Task getAddTask() {
        return null;
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
        for (int i = 0; i < tasks.size(); i++) {
            Vector<String> task = new Vector<>();
            task.add(tasks.get(i).getName());
            task.add(tasks.get(i).getDescription());
            task.add(tasks.get(i).getNotificationDate());
            task.add(tasks.get(i).getContacts());
            data.add(task);
        }
        return data;
    }

    @Override
    public void updateView(Vector<Task> tasks) {
        tableNameCol();
        table.setModel(new TableModel(toNormalVector(tasks), namCol));
    }


    static class TableModel extends DefaultTableModel {
        public TableModel(Vector<Vector<String>> data, Vector namCol) {
            super(data, namCol);
        }
    }

}
