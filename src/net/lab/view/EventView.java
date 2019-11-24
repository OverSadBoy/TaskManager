package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;

public class EventView extends JFrame {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JPanel panelBtn;
    private JButton deferBtn;
    private JLabel eventMes;

    private Task task;

    public EventView(Task task) {
        super("Event");
        this.task = task;
        inflate();
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

    public JButton getButtonEndTask() {
        return buttonEndTask;
    }

    public JButton getDeferBtn() {
        return deferBtn;
    }

    public JLabel getEventMes() {
        return eventMes;
    }
}
