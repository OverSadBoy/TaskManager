package net.lab;

import net.lab.controller.Controller;
import net.lab.model.Model;
import net.lab.view.MainView;

public class Main {

    public static void main(String[] args) {
        new Controller(new Model(), new MainView());
    }
}
