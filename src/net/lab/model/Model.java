package net.lab.model;

import net.lab.controller.Controller;

import java.io.*;
import java.util.Vector;

public class Model implements ModelContract {

    //TODO ЗАПИСЫВАТЬ ИЗ ВЕКТОРА, А НЕ КОНТРОЛЛЕР
    public static void serializeTasks(Controller object, FileOutputStream fStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fStream);
        oos.writeObject(object);
    }

    //TODO ЗАПИСЫВАТЬ В ВЕКТОР, А НЕ КОНТРООЛЛЕР
    public static Controller deserializeTasks(FileInputStream fStream) throws IOException, ClassNotFoundException {
        Controller result;
        ObjectInputStream ois = new ObjectInputStream(fStream);
        result = (Controller) ois.readObject();
        return result;
    }
//TODO продумать логику методов
    @Override
    public void addTask(Task task) {

    }

    @Override
    public void editTask(Task beforeTask, Task afterTask) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public Vector<Task> getTasks() {
        return null;
    }
}
