package net.lab.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class MainView extends JFrame implements ViewContract {

    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JTable table;

    public MainView() throws HeadlessException {
        super("Task Manager");
        inflateView();
    }

    private void inflateView() {
        setBounds(400, 150, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jPanel1);
        setVisible(true);
    }

    public void updateView(Vector<Vector<String>> vectorTable, Vector<String> namCol) {
        table.setModel(new TableModel(vectorTable, namCol));
    }

    static class TableModel extends DefaultTableModel {
        TableModel(Vector<Vector<String>> data, Vector namCol) {
            super(data, namCol);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    public JButton getDeleteTaskButton() {
        return deleteTaskButton;
    }

    public JTable getTable() {
        return table;
    }
}
