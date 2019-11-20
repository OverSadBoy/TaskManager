package net.lab;

import net.lab.controller.Controller;
import net.lab.model.Model;
import net.lab.view.MainView;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Model model = new Model();
        MainView view = new MainView(model);
        Controller controller = new Controller(model,view);
    }
}
