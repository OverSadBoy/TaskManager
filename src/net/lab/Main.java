package net.lab;

import net.lab.controller.TaskJournal;
import net.lab.view.UserInterface;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
         UserInterface form = new UserInterface(new ArrayList(),new TaskJournal());
    }
}
