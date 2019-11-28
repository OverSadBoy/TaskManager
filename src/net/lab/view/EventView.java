package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;

import static net.lab.utils.ViewUtils.EVENT;

public class EventView extends JFrame {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JPanel panelBtn;
    private JButton deferBtn;
    private JLabel eventMes;

    private Task task;


    public EventView(Task task) {
        super(EVENT);
        this.task = task;
        inflate();
    }

    private void inflate() {
        setSize( 350, 200);
        setLocationRelativeTo(null);
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
