package com.company;

import java.util.*;

public class FrenchBot {

    String[][] listOfWords = {{"Faire","Fait"}, {"Prendre", "Pris"}, {"Apprendre", "Appris"},
            {"Comprendre", "Compris"}, {"Rire", "Ri"}, {"Sourire", "Souri"}, {"Dormir", "Dormi"},
            {"Lire", "Lu"}, {"Écrire", "Écrit"}, {"Dire", "Dit"}, {"Boire", "Bu"}, {"Croire", "Cru"},
            {"Voir", "Vu"}, {"Pouvoir", "Pu"}, {"Vouloir", "Voulu"}, {"Savoir", "Su"}, {"Devoir", "Dû"},
            {"Être", "Été"}, {"Avoir", "Eu"}, {"Choisir", "Choisi"}, {"Finir", "Fini"}, {"Mourir", "Mort"},
            {"Retourner", "Retourné"}, {"Sortir", "Sorti"}, {"Venir", "Venu"}, {"Arriver", "Arrivé"},
            {"Naître", "Né"}, {"Descendre", "Descendu"}, {"Entrer", "Entré"}, {"Tomber", "Tombé"},
            {"Rester", "Resté"}, {"Aller", "Allé"}, {"Monter", "Monté"}, {"Partir", "Parti"}, {"Passer", "Passé"}};

    public FrenchBot() {
    }

    public boolean welcome() {
        System.out.println("Hello! I'm your French passe compose assistant!");
        System.out.println("Type 'start' to begin, or 'exit' to end anytime");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("start")) {
                return true;
            }
            else if (input.equals("exit")){
                return false;
            }
            else {
                System.out.println("Sorry, can you repeat that?");
            }
        }
    }

    public void basicPasseCompose(Scanner scanner, ArrayList<String[]> arr) {
        int score = 0;
        int upperBound = 36;
        Random rand = new Random();
        while (upperBound > 0) {
            int randInt = rand.nextInt(upperBound);
            System.out.println("What is the passe compose of: " + arr.get(randInt)[0]);
            String input = scanner.nextLine();
            String answer = arr.get(randInt)[1].toLowerCase(Locale.ROOT);
            String receivedAnswer = input.toLowerCase(Locale.ROOT);
            upperBound -= 1;
            if (receivedAnswer.equals("exit")) {
                System.out.println("Aw. Leaving so soon?");
                break;
            }
            else if (receivedAnswer.equals(answer)) {
                System.out.println("Correct!");
                score += 1;
                arr.remove(randInt);
            }
            else {
                System.out.println("Incorrect. The answer is: " + arr.get(randInt)[1]);
                arr.remove(randInt);
            }
        }
        System.out.println("You got " + score + " out of 36");
    }

    public ArrayList<String[]> setUp(ArrayList<String[]> arr, String[][] wordList) {
        arr.addAll(Arrays.asList(wordList));
        return arr;
    }


    public static void main(String[] args) {
        FrenchBot bot = new FrenchBot();
        Scanner scanner = new Scanner(System.in);
        boolean start = bot.welcome();
        // Begin
        if (start) {
            ArrayList<String[]> wordArray = bot.setUp(new ArrayList<>(), bot.listOfWords);
            bot.basicPasseCompose(scanner, wordArray);
        }
    }
}
