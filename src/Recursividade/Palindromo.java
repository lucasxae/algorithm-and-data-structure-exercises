package Recursividade;
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String numberToCount = sc.nextLine();
        while (!numberToCount.equals("FIM")) {
            System.out.println(palindromo(numberToCount, 0));
            numberToCount = sc.nextLine();
        }
    }

    public static String palindromo(String word, int position) {
        char[] letras = word.toCharArray();
        if ((letras[position] == letras[letras.length - 1 - position]) && (position <= letras.length / 2)) {
            return palindromo(word, position + 1);
        } else if (letras[position] == letras[letras.length - 1 - position]) {
            return "SIM";
        } else {
            return "NAO";
        }

    }
}