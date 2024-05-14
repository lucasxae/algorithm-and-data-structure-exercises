package Recursividade;
import java.util.Scanner;

public class IsRecursivo {

    public static boolean soVogais(String palavra) {
        if (palavra.length() == 0) {
            return true;
        }
        char c = Character.toLowerCase(palavra.charAt(0));
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return soVogais(palavra.substring(1));
        } else {
            return false;
        }
    }

    public static boolean soConsoantes(String palavra) {
        if (palavra.length() == 0) {
            return true;
        }
        char c = Character.toLowerCase(palavra.charAt(0));
        if ((c >= 'a' && c <= 'z') && !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
            return soConsoantes(palavra.substring(1));
        } else {
            return false;
        }
    }

    public static boolean soNumero(String palavra) {
        if (palavra.length() == 0) {
            return true;
        }
        char c = palavra.charAt(0);
        if (c >= '0' && c <= '9') {
            return soNumero(palavra.substring(1));
        } else {
            return false;
        }
    }

    public static Boolean soNumeroReal(String palavra) {
        return soNumeroReal(palavra, 0, 0);
    }
    
    private static Boolean soNumeroReal(String palavra, int countDot, int countComma) {
        if (palavra.length() == 0) {
            return true;
        }
        char c = palavra.charAt(0);
        if (c == '.') {
            countDot++;
        }
        if (c == ',') {
            countComma++;
        }
        if (countDot > 1 || countComma > 1) {
            return false;
        }
        if ((c >= '0' && c <= '9') || c == '.' || c == ',') {
            return soNumeroReal(palavra.substring(1), countDot, countComma);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        while (texto.equals("FIM") == false) {
            String X1 = soVogais(texto) ? "SIM" : "NAO";
            String X2 = soConsoantes(texto) ? "SIM" : "NAO";
            String X3 = soNumero(texto) ? "SIM" : "NAO";
            String X4 = soNumeroReal(texto) ? "SIM" : "NAO";

            System.out.println(X1 + " " + X2 + " " + X3 + " " + X4);
            texto = sc.nextLine();
        }

    }
}