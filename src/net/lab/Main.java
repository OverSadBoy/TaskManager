package net.lab;

import net.lab.view.MainForm;

public class Main {

    public static void main(String[] args) {
        UserInterface.createForm(new MainForm("Task Manager"), 640, 480);
    }
}
