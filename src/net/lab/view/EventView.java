package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;

public class EventView extends JFrame {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JPanel panelBtn;
    private JButton deferBtn;
    private JLabel eventMes;

    private ViewContract view;
    private Task task;

    EventView(ViewContract view, Task task) {
        super("Event");
        this.view = view;
        this.task = task;
        inflate();
        setListener();
    }

    private void inflate() {
        setBounds(500, 200, 350, 200);
        setResizable(false);
        add(contentPane);
        eventMes.setText(setEventText());
        setVisible(true);
    }

    private String setEventText() {
        return task.getName() + " will be complete?";
    }

    private void setListener() {
        buttonEndTask.addActionListener(e -> {
            view.deleteTask(task);
            dispose();
        });
        deferBtn.addActionListener(e -> {
            new AddView(view, task);
            dispose();
        });
    }


}
