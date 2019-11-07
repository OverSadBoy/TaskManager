package net.lab;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable {
    private String name;
    private String description;
    private Date notificationDate;
    private String contacts;

    public Task(String name, String description, Date notificationDate, String contacts) {
        this.name = name;
        this.description = description;
        this.notificationDate = notificationDate;
        this.contacts = contacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
