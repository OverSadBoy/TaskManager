package net.lab.view;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;

    public MainForm(String title) throws HeadlessException {
        super(title);
        add(panel1);
    }
}
