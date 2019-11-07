package net.lab.view;

import javax.swing.*;
import java.awt.event.*;

public class Event extends JDialog {
    private JPanel contentPane;
    private JButton buttonEndTask;
    private JButton buttonCancel;

    public Event() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonEndTask);

        buttonEndTask.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> onCancel());

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

    public static void main(String[] args) {
        Event dialog = new Event();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
