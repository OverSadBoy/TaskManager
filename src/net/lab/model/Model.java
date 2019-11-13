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

    public Model() {
        file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //TODO ЗАПИСЫВАТЬ ИЗ ВЕКТОРА, А НЕ КОНТРОЛЛЕР
    public static void serializeTasks(Vector<Task> object, FileOutputStream fStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fStream);
        oos.writeObject(object);
    }

    //TODO ЗАПИСЫВАТЬ В ВЕКТОР, А НЕ КОНТРООЛЛЕР
    public static Vector<Task> deserializeTasks() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        Vector<Task> res = (Vector<Task>) ois.readObject();
        return res;
    }

    //TODO продумать логику методов
    @Override
    public void addTask(Task task) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(Task beforeTask, Task afterTask) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public Vector<Task> getTasks() {
        Vector<Task> tasks = new Vector<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            try {
                tasks = (Vector<Task>) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
