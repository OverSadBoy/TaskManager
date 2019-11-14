package net.lab.model;

import net.lab.controller.Controller;

import java.io.*;
import java.util.Vector;

public class Model implements ModelContract {

    private static final String fileName = "data.bin";
    private File file;
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;

    private static Vector<Task> listTask;

    public Model() throws IOException {
        file = new File(fileName);
        if(!file.isFile()) {
            file.createNewFile();
        }

        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(Vector<Task> tasks) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            new FileWriter(file).write("");
            oos.writeObject(tasks);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vector<Task> getTasks() {
        Vector<Task> tasks = new Vector<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            tasks = (Vector<Task>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public void editTask(Task beforeTask, Task afterTask) {

    }

    @Override
    public void deleteTask(Task task) {

    }
}
