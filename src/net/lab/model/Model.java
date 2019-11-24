package net.lab.model;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Vector;

public class Model implements ModelContract {

    private static final String fileName = "Data.xml";
    private static FileInputStream fileInputStream;
    private static FileOutputStream fileOutputStream;
    private static Vector<Task> taskList;

    public Model() {
    }

    @Override
    public void updateModel(Vector<Task> tasks) {
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
                writer.writeCharacters(Task.dateFormat.format(task.getNotificationDate()));
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
        Date date = new Date();
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
                    tasks.add(new Task(name, description, date, contact));
                    name = "";
                    description = "";
                    contact = "";
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    switch (type) {
                        case "name":
                            name = reader.getText();
                            break;
                        case "description":
                            description = reader.getText();
                            break;
                        case "notificationDate":
                            date = Task.dateFormat.parse(reader.getText());
                            break;
                        case "contacts":
                            contact = reader.getText();
                            break;
                    }
                }
            }
        } catch (XMLStreamException | ParseException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
