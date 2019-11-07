package net.lab.model;

import net.lab.controller.TaskJournal;

import java.io.*;

public class JournalManagement {
    public static void serializeTasks(TaskJournal object, FileOutputStream fStream) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fStream);
        oos.writeObject(object);
    }

    public static TaskJournal deserializeTasks(FileInputStream fStream) throws IOException, ClassNotFoundException {
        TaskJournal result;
        ObjectInputStream ois = new ObjectInputStream(fStream);
        result = (TaskJournal) ois.readObject();
        return result;
    }
}
