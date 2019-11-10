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

    public AddView() {
        super("Add task");
        setBounds(500, 350, 500, 350);
        setResizable(false);
        add(addPanel);
        setListener();
        setVisible(true);
    }

    private void setListener() {
        addButton.addActionListener(e -> {
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());
    }

    private Task createNewTask(String name, String description, String data, String contact) {
        return new Task(name, description, data, contact);
    }

}
