package net.lab.view;

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

    public AddView() {
        super("Add task");
        inflate();
    }

    public AddView(Task task) {
        super("Edit task");
        inflate(task);
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
        date.setText(Task.dateFormat.format(task.getNotificationDate()));
        contacts.setText(task.getContacts());
        addButton.setText("Edit");
        setVisible(true);
    }

    public String getNameTask() {
        return nameTask.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public JTextField getDate() {
        return date;
    }

    public String getContacts() {
        return contacts.getText();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

}
