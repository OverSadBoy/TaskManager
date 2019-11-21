package net.lab.model;

import net.lab.controller.Controller;

import javax.xml.stream.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Model implements ModelContract {

    private static final String fileName = "Data.xml";
   // private File file;
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static Vector<Task> taskList;

    public Model() throws IOException {
//        file = new File(fileName);
//        if(!file.isFile()) {
//            file.createNewFile();
//        }

//        try {
//            fileInputStream = new FileInputStream(file);
//            fileOutputStream = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        var tasks = new Vector<Task>();
        tasks.add(0, new Task("Rabota", "OnFriday", new SimpleDateFormat("27.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota2", "OnFriday", new SimpleDateFormat("28.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota3", "OnFriday", new SimpleDateFormat("29.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota4", "OnFriday", new SimpleDateFormat("30.10.2019"), "89297928290"));
        addTask(tasks);
    }

    @Override
    public void addTask(Vector<Task> tasks) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter(fileName));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("Tasks");
            for (var task :
                    tasks) {
                writer.writeStartElement("Task");
                //Name
                writer.writeStartElement("Name");
                writer.writeCharacters(task.getName());
                writer.writeEndElement();
                //Description
                writer.writeStartElement("Description");
                writer.writeCharacters(task.getDescription());
                writer.writeEndElement();
                //Notification Date
                writer.writeStartElement("NotificationDate");
                writer.writeCharacters(task.getNotificationDate().toPattern());
                writer.writeEndElement();
                //Contacts
                writer.writeStartElement("Contacts");
                writer.writeCharacters(task.getContacts());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            //writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vector<Task> getTasks() {
        Vector<Task> tasks = new Vector<>();
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileName, fileInputStream);
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    System.out.println(reader.getLocalName());
                } else if (reader.isEndElement()) {
                    System.out.println("/" + reader.getLocalName());
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    System.out.println("   " + reader.getText());
                }
            }
        } catch (XMLStreamException e) {
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
