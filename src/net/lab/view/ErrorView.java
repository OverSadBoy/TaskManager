package net.lab.view;

import net.lab.utils.ViewUtils;

import javax.swing.*;

public class ErrorView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel mesText;

    public ErrorView(String message) {
        setTitle(ViewUtils.ERROR);
        setContentPane(contentPane);
        setSize(300, 150);
        setLocationRelativeTo(null);
        mesText.setText(message);
        setVisible(true);
        buttonOK.addActionListener(e -> dispose());
    }
}
