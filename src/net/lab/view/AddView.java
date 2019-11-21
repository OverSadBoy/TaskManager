package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddView extends JFrame {
    private JTextField nameTask;
    private JTextField description;
    private JTextField date;
    private JTextField contacts;
    private JPanel addPanel;
    private JButton addButton;
    private JButton cancelButton;

    private ViewContract view;
    private Task task;

    AddView(ViewContract view) {
        super("Add task");
        inflate();
        setListenerAdd();
        this.view = view;
    }

    AddView(ViewContract view, Task task) {
        super("Edit task");
        inflate(task);
        setListenerEdit();
        this.view = view;
    }

    private void inflate() {
        setBounds(500, 350, 500, 350);
        setResizable(false);
        add(addPanel);
        setVisible(true);
    }

    private void inflate(Task task) {
        setBounds(500, 350, 500, 350);
        setResizable(false);
        add(addPanel);
        nameTask.setText(task.getName());
        description.setText(task.getDescription());
        date.setText(task.getNotificationDate().format(new Date()));
        contacts.setText(task.getContacts());
        addButton.setText("Edit");
        setVisible(true);
    }

    private void setListenerAdd() {
        addButton.addActionListener(e -> {
            view.addNewTask(getNewTask());
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private void setListenerEdit() {
        addButton.addActionListener(e -> {
            view.changeTask(task, getNewTask());
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private Task getNewTask() {
        return new Task(nameTask.getText(), description.getText(), new SimpleDateFormat(date.getText()), contacts.getText());
    }

}
