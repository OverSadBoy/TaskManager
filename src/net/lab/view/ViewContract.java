package net.lab.view;

import java.util.Vector;

public interface ViewContract {
    void updateView(Vector<Vector<String>> vectorTable, Vector<String> namCol);
}
