package com.company;

import java.util.*;

public class FrenchBot {

    public FrenchBot() {
    }

    public String welcome() {
        System.out.println("Hello! I'm your French passe compose assistant!");
        System.out.println("Type 'passe compose' to begin the Passé Composé test, or " +
                "'pnd' to begin the Pouvoir and Devoir test.");
        System.out.println("Otherwise, type 'exit' to end anytime");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            switch (input) {
                case "passe compose":
                    return "passe compose";
                case "pnd":
                    return "pnd";
                case "exit":
                    return "exit";
                default:
                    System.out.println("Sorry, can you repeat that?");
            }
        }
    }

    public static void main(String[] args) {
        FrenchBot bot = new FrenchBot();
        passeCompose passeCompose = new passeCompose();
        pnd pnd = new pnd();
        Scanner scanner = new Scanner(System.in);
        String start = bot.welcome();
        // Begin
        if (start.equals("passe compose")) {
            passeCompose.basicPasseCompose(scanner);
        }
        else if (start.equals("pnd")) {
            pnd.basicPnD(scanner);
        }
    }
}
