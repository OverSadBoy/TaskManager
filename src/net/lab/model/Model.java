package net.lab.model;

import net.lab.utils.TasksIO;

import javax.xml.stream.*;
import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

import static net.lab.utils.ModelUtils.*;

public class Model implements ModelContract {

    public Model() {
    }

    @Override
    public void updateModel(Vector<Task> tasks) {
        TasksIO.writeToXML(tasks);
    }

    @Override
    public Vector<Task> getTasks() {
        return TasksIO.readFromXML();
    }
}
