package net.lab.view;

import net.lab.controller.TaskJournal;
import net.lab.model.Task;

import javax.swing.*;
import javax.xml.crypto.Data;

public class AddTaskUI extends JFrame {
    private JTextField nameTask;
    private JTextField description;
    private JTextField date;
    private JTextField contacts;
    private JPanel addPanel;
    private JButton addButton;
    private JButton cancelButton;

    private TaskJournal controller;

    public AddTaskUI(TaskJournal ctrl) {
        super("Add task");
        setBounds(500, 350, 500, 350);
        add(addPanel);
        setListener();
        setVisible(true);
        this.controller = ctrl;
    }

    private void setListener() {
        addButton.addActionListener(e -> {
            controller.addTask(createNewTask(nameTask.getText(), description.getText(), date.getText(), contacts.getText()));
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private Task createNewTask(String name, String description, String data, String contact) {
        return new Task(name, description, data, contact);
    }

}
