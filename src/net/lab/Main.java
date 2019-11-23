package net.lab;

import net.lab.controller.Controller;
import net.lab.model.Model;
import net.lab.view.MainView;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        MainView view = new MainView();
        Controller controller = new Controller(model, view);
    }
}
