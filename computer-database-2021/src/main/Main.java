package main;

import controller.Controller;

public class Main {

    public static void main(String[] args) {

        while (true) {
            new Controller().action();
        }
    }
}
