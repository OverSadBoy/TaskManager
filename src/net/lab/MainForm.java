package net.lab;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;

    public MainForm(String title) throws HeadlessException {
        super(title);
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel1);
        setVisible(true);
    }
}
