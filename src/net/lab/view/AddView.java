package net.lab.view;

import net.lab.controller.Controller;
import net.lab.controller.ControllerContract;
import net.lab.model.Task;

import javax.swing.*;

public class AddView extends JFrame {
    private JTextField nameTask;
    private JTextField description;
    private JTextField date;
    private JTextField contacts;
    private JPanel addPanel;
    private JButton addButton;
    private JButton cancelButton;

    private ControllerContract controller;
    private ViewContract view;

    AddView(ViewContract view) {
        super("Add task");
        setBounds(500, 350, 500, 350);
        setResizable(false);
        add(addPanel);
        setListener();
        this.view = view;
        setVisible(true);
    }

    private void setListener() {
        addButton.addActionListener(e -> {
            view.addNewTask(getTask());
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private Task getTask() {
        return new Task(nameTask.getText(), description.getText(), date.getText(), contacts.getText());
    }

    private Task createNewTask(int id, String name, String description, String data, String contact) {
        return new Task(name, description, data, contact);
    }

}
