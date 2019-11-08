package net.lab.view;

import javax.swing.*;
import java.awt.event.*;

public class Event extends JFrame {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JPanel panelBtn;
    private JPanel panelText;
    private JButton deferBtn;

    public Event() {
        super("Event");
        setSize(200, 200);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(contentPane);
        setVisible(true);
        getRootPane().setDefaultButton(buttonEndTask);

        buttonEndTask.addActionListener(e -> onOK());

        deferBtn.addActionListener(e -> onCancel());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
