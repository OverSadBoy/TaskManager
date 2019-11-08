package net.lab.view;

import net.lab.controller.TaskJournal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UserInterface extends JFrame {

    private TaskJournal taskJournal;

    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JScrollPane ScrollPane;
    private JTable table1;
    private final static String[] str = {"Name", "Description", "Notification date", "Contacts"};

    public UserInterface(ArrayList arrayList, TaskJournal taskJournal) throws HeadlessException {
        super("Task Manager");
        this.taskJournal = taskJournal;
        setBounds(400,150,800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        initComponents(arrayList);
        fillTable(arrayList);
        setVisible(true);
    }

    private void initComponents(ArrayList arrayList) {
        addTaskButton.addActionListener(e -> {
            AddTaskUI addTaskUI =new AddTaskUI();
        });

        deleteTaskButton.addActionListener(e -> {

        });
    }

    private void toArray(ArrayList list) {

    }

    public void fillTable(ArrayList list) {

    }

    class TableModel extends DefaultTableModel {
        public TableModel(Vector data, Vector<String> colNames) {
            super(data, colNames);
        }
    }

}
