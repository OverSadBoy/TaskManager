package net.lab.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    private final String name;
    private final String description;
    private final Date notificationDate;
    private final String contacts;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yy");

    public Task(String name, String description, Date notificationDate, String contacts) {
        this.name = name;
        this.description = description;
        this.notificationDate = notificationDate;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public String getContacts() {
        return contacts;
    }


}
