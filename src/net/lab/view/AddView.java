package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;

import static net.lab.utils.ViewUtils.*;

public class AddView extends JFrame {
    private JTextField nameTask;
    private JTextField description;
    private JTextField date;
    private JTextField contacts;
    private JPanel addPanel;
    private JButton addButton;
    private JButton cancelButton;
    private JLabel dateLable;
    private JLabel nameTaskLable;

    public AddView() {
        super(ADD_TASK);
        inflate();
    }

    public AddView(Task task) {
        super(EDIT_TASK);
        inflate(task);
    }

    private void inflate() {
        setSize(500, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        add(addPanel);
        setVisible(true);
    }

    private void inflate(Task task) {
        setSize(500, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        add(addPanel);
        nameTask.setText(task.getName());
        description.setText(task.getDescription());
        date.setText(Task.dateFormat.format(task.getNotificationDate()));
        contacts.setText(task.getContacts());
        addButton.setText(EDIT);
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

    public JLabel getDateLable() {
        return dateLable;
    }

    public JLabel getNameTaskLable() {
        return nameTaskLable;
    }
}
