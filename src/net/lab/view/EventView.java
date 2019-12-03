package net.lab.view;

import net.lab.model.Task;

import javax.swing.*;

import static net.lab.utils.ViewUtils.*;

public class EventView extends JFrame {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JPanel panelBtn;
    private JButton deferBtn;
    private JLabel eventMes;
    private JLabel description;

    private Task task;


    public EventView(Task task) {
        super(EVENT);
        this.task = task;
        inflate();
    }

    private void inflate() {
        setSize(600, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        add(contentPane);
        eventMes.setText(setEventName());
        description.setText(setEventDescription());
        setVisible(true);
    }

    private String setEventName() {
        return SCHEDULED_TASK + task.getName();
    }

    private String setEventDescription() {
        return DESCRIPTION + task.getDescription();
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
