package net.lab.view;

import javax.swing.*;

public class UserInterface {
    public static void createForm(JFrame form, int width, int height) {
        form.setSize(width, height);
        form.setResizable(false);
        form.setDefaultCloseOperation(form.EXIT_ON_CLOSE);
        form.setVisible(true);
    }

}
