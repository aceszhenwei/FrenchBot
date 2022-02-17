package com.company;

import java.text.Normalizer;
import java.util.*;

public class pnd {

    String[][] listOfPnD= {{"Je", "peux", "p"}, {"Tu", "peux", "p"}, {"Elle", "peut", "p"}, {"Il", "peut", "p"},
            {"On", "peut", "p"}, {"Nous", "pouvons", "p"}, {"Vous", "pouvez", "p"}, {"Elles", "peuvent", "p"},
            {"Ils", "peuvent", "p"}, {"Je", "dois", "d"}, {"Tu", "dois", "d"}, {"Elle", "doit", "d"},
            {"Il", "doit", "d"}, {"On", "doit", "d"}, {"Nous", "devons", "d"}, {"Vous", "devez", "d"},
            {"Elles", "doivent", "d"}, {"Ils", "doivent", "d"}};

    public void basicPnD(Scanner scanner) {
        ArrayList<String[]> arr = new ArrayList<>(Arrays.asList(listOfPnD));
        int score = 0;
        int upperBound = 18;
        Random rand = new Random();
        while (upperBound > 0) {
            int randInt = rand.nextInt(upperBound);
            if (arr.get(randInt)[2].equals("p")) {
                System.out.println("Under pouvoir, " + arr.get(randInt)[0] + ":");
            }
            else {
                System.out.println("Under devoir, " + arr.get(randInt)[0] + ":");
            }
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
        System.out.println("You got " + score + " out of 18");
    }

}
