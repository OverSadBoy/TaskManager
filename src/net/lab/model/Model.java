package net.lab.model;

import net.lab.controller.Controller;

import java.io.*;
import java.util.Vector;

public class Model implements ModelContract{
    public static void serializeTasks(Controller object, FileOutputStream fStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fStream);
        oos.writeObject(object);
    }

    public static Controller deserializeTasks(FileInputStream fStream) throws IOException, ClassNotFoundException {
        Controller result;
        ObjectInputStream ois = new ObjectInputStream(fStream);
        result = (Controller) ois.readObject();
        return result;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public Vector<Task> getTasks() {
        return null;
    }
}
