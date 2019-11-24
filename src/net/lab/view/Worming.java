package net.lab.view;

import javax.swing.*;

public class Worming extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel mesText;

    public Worming() {
        pack();
        setContentPane(contentPane);
        setBounds(300, 300, 300, 150);
        mesText.setText("invalid date format");
        setVisible(true);
        buttonOK.addActionListener(e -> dispose());
    }

}
