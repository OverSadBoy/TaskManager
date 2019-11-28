package net.lab.model;

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
        try {
            XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileWriter(FILE_NAME));
            writer.writeStartDocument(VERSION);
            writer.writeStartElement(TASKS);
            for (var task : tasks) {
                writer.writeStartElement(TASK);
                //Name
                writer.writeStartElement(NAME);
                writer.writeCharacters(task.getName());
                writer.writeEndElement();
                //Description
                writer.writeStartElement(DESCRIPTION);
                writer.writeCharacters(task.getDescription());
                writer.writeEndElement();
                //Notification Date
                writer.writeStartElement(NOTIFICATION_DATE);
                writer.writeCharacters(Task.dateFormat.format(task.getNotificationDate()));
                writer.writeEndElement();
                //Contacts
                writer.writeStartElement(CONTACTS);
                writer.writeCharacters(task.getContacts());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            //writer.flush();
            writer.close();
        } catch (XMLStreamException | IOException ignored) {
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
            XMLStreamReader reader = inputFactory.createXMLStreamReader(FILE_NAME, new FileInputStream(FILE_NAME));
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement()) {
                    type = reader.getLocalName();
                } else if (reader.isEndElement() && reader.getLocalName().equals(TASK)) {
                    tasks.add(new Task(name, description, date, contact));
                    name = "";
                    description = "";
                    contact = "";
                } else if (reader.hasText() && reader.getText().trim().length() > 0) {
                    switch (type) {
                        case NAME:
                            name = reader.getText();
                            break;
                        case DESCRIPTION:
                            description = reader.getText();
                            break;
                        case NOTIFICATION_DATE:
                            date = Task.dateFormat.parse(reader.getText());
                            break;
                        case CONTACTS:
                            contact = reader.getText();
                            break;
                    }
                }
            }
        } catch (XMLStreamException | ParseException | FileNotFoundException ignored) {
        }
        return tasks;
    }
}
