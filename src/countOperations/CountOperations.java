package countOperations;

import java.util.Random;

public class CountOperations {
    public static void main(String[] args) {
        String input = "o rato roeu a roupa do rei de roma e qwe qwe qwe ewq ewq ewa";
        System.out.println(replaceLetters(input));
    }

    public static String replaceLetters(String str) {
        Random random = new Random(4); // Seed = 4

        if (str.isEmpty()) {
            return "";
        }

        char firstLetter = str.charAt(0);
        char secondLetter = generateRandomLetter(random);

        String rest = replaceLetters(str.substring(1));
        if (firstLetter == ' ') {
            return " " + rest;
        } else if (str.length() == 1) {
            return String.valueOf(secondLetter);
        } else {
            return (firstLetter == 'q') ? secondLetter + rest : firstLetter + rest;
        }
    }

    public static char generateRandomLetter(Random random) {
        return (char) (random.nextInt(26) + 'a');
    }
}
