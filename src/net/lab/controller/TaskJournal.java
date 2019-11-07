package net.lab.controller;
import net.lab.model.JournalManagement;
import net.lab.model.Task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class TaskJournal implements Serializable {
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private final String fileName = "data.bin";
    public TaskJournal(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskJournal() {
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskNumber) {
        tasks.remove(taskNumber);
    }

    public void loadJournal() {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            tasks = JournalManagement.deserializeTasks(fis).tasks;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveJournal() {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            JournalManagement.serializeTasks(this, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
