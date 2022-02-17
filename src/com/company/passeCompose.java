package com.company;

import java.text.Normalizer;
import java.util.*;

public class passeCompose {

    String[][] listOfWords = {{"Faire","Fait"}, {"Prendre", "Pris"}, {"Apprendre", "Appris"},
            {"Comprendre", "Compris"}, {"Rire", "Ri"}, {"Sourire", "Souri"}, {"Dormir", "Dormi"},
            {"Lire", "Lu"}, {"Écrire", "Écrit"}, {"Dire", "Dit"}, {"Boire", "Bu"}, {"Croire", "Cru"},
            {"Voir", "Vu"}, {"Pouvoir", "Pu"}, {"Vouloir", "Voulu"}, {"Savoir", "Su"}, {"Devoir", "Dû"},
            {"Être", "Été"}, {"Avoir", "Eu"}, {"Choisir", "Choisi"}, {"Finir", "Fini"}, {"Mourir", "Mort"},
            {"Retourner", "Retourné"}, {"Sortir", "Sorti"}, {"Venir", "Venu"}, {"Arriver", "Arrivé"},
            {"Naître", "Né"}, {"Descendre", "Descendu"}, {"Entrer", "Entré"}, {"Tomber", "Tombé"},
            {"Rester", "Resté"}, {"Aller", "Allé"}, {"Monter", "Monté"}, {"Partir", "Parti"}, {"Passer", "Passé"}};

    public void basicPasseCompose(Scanner scanner) {
        ArrayList<String[]> arr = new ArrayList<>(Arrays.asList(listOfWords));
        int score = 0;
        int upperBound = 35;
        Random rand = new Random();
        while (upperBound > 0) {
            int randInt = rand.nextInt(upperBound);
            System.out.println("What is the passe compose of: " + arr.get(randInt)[0]);
            // Get input
            String accentedInput = scanner.nextLine();
            // Normalize Input
            String input = accentedInput.toLowerCase(Locale.ROOT);
            input = Normalizer.normalize(input, Normalizer.Form.NFD);
            String receivedAnswer = input.replaceAll("[^\\p{ASCII}]", "");
            // Get Answer
            String accentedAnswer = arr.get(randInt)[1].toLowerCase(Locale.ROOT);
            // Normalize Answer
            String answer = Normalizer.normalize(accentedAnswer, Normalizer.Form.NFD);
            answer = answer.replaceAll("[^\\p{ASCII}]", "");
            upperBound -= 1;
            if (receivedAnswer.equals("exit")) {
                System.out.println("Aw. Leaving so soon?");
                break;
            }
            else if (receivedAnswer.equals(answer)) {
                System.out.println("Correct! It is indeed: " + arr.get(randInt)[1]);
                score += 1;
                arr.remove(randInt);
            }
            else {
                System.out.println("Incorrect. The answer is: " + arr.get(randInt)[1]);
                arr.remove(randInt);
            }
        }
        System.out.println("You got " + score + " out of 35");
    }
}
