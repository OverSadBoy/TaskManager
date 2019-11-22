package net.lab.model;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Model implements ModelContract {

    private static final String fileName = "Data.xml";
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static Vector<Task> taskList;

    public Model() throws IOException {
        var tasks = new Vector<Task>();
        tasks.add(0, new Task("Rabota", "OnFriday", new SimpleDateFormat("27.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota2", "OnFriday", new SimpleDateFormat("28.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota3", "OnFriday", new SimpleDateFormat("29.10.2019"), "89297928290"));
        tasks.add(0, new Task("Rabota4", "OnFriday", new SimpleDateFormat("30.10.2019"), "89297928290"));
        tasks.add(0,new Task("Gym","enjoin",new SimpleDateFormat("12.03.2020"),"8-800-555-35-35"));
        addTask(tasks);
    }

    @Override
    public void addTask(Vector<Task> tasks) {
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter(fileName));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("tasks");
            for (var task :
                    tasks) {
                writer.writeStartElement("task");
                //Name
                writer.writeStartElement("name");
                writer.writeCharacters(task.getName());
                writer.writeEndElement();
                //Description
                writer.writeStartElement("description");
                writer.writeCharacters(task.getDescription());
                writer.writeEndElement();
                //Notification Date
                writer.writeStartElement("notificationDate");
                writer.writeCharacters(task.getNotificationDate().toPattern());
                writer.writeEndElement();
                //Contacts
                writer.writeStartElement("contacts");
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
        String name = "";
        String description = "";
        SimpleDateFormat date = new SimpleDateFormat();
        String contact = "";
        String type = "";
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileName, fileInputStream);
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    type = reader.getLocalName();
                } else if (reader.isEndElement() && reader.getLocalName().equals("task")) {
                    tasks.add(new Task(name,description,date,contact));
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    switch (type) {
                        case "name":
                            name = reader.getText();
                            break;
                        case "description":
                            description = reader.getText();
                            break;
                        case "notificationDate":
                            date = new SimpleDateFormat(reader.getText());
                            break;
                        case "contacts":
                            contact = reader.getText();
                            break;
                    }
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
