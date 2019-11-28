package net.lab.view;

import javax.swing.*;

import static net.lab.utils.ViewUtils.INVALID_DATE_FORMAT;

public class ErrorView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel mesText;

    public ErrorView() {
        pack();
        setContentPane(contentPane);
        setSize( 300, 150);
        setLocationRelativeTo(null);
        mesText.setText(INVALID_DATE_FORMAT);
        setVisible(true);
        buttonOK.addActionListener(e -> dispose());
    }

}
