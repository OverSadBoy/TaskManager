package net.lab.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

import static net.lab.utils.ViewUtils.TASK_MANAGER;
import static net.lab.utils.ViewUtils.TROUBLE_WHICH_SCHEME;

public class MainView extends JFrame implements ViewContract {

    private JPanel jPanel1;
    private JButton addTaskButton;
    private JButton deleteTaskButton;
    private JTable table;

    public MainView() throws HeadlessException {
        super(TASK_MANAGER);
        inflateView();
    }

    private void inflateView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showConfirmDialog(this, TROUBLE_WHICH_SCHEME);
        }
        setSize(800, 600);
        setLocationRelativeTo(null);
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
