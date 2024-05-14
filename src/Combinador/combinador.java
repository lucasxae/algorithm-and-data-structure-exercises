package Combinador;

/*
 * Implemente um método, em Java, denominado combinador, que receba duas strings.
 *  Esse método deve ser capaz de combinar as duas strings recebidas como parâmetros, 
 * alternando as letras de cada string, da seguinte forma: comece com a primeira letra da 
 * primeira string, seguida pela primeira letra da segunda string, continue com a segunda 
 * letra da primeira string, e assim sucessivamente. As letras restantes da cadeia mais longa 
 * devem ser adicionadas ao fim da string resultante, que deve ser retornada.
 * 
    A entrada padrão é composta por várias linhas sendo que a última apresenta apenas a 
    palavra FIM. A saída padrão contém a string resultante para cada linha de entrada.
 */

public class combinador {
    public static void main(String[] args) {
        String string1 = "Too";
        String string2 = "Pcder";
        System.out.println(combinador(string1, string2));
    }

    private static String combinador(String string1, String string2) {

        int totalSize = string1.length() + string2.length();
        String result = "";
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < totalSize; i++) {

            if (countA < string1.length()) {
                result += string1.charAt(countA);
                if (countA + 1 < string1.length())
                    result += string1.charAt(countA + 1);
                countA += 2;
            }
            if (countB < string2.length()) {
                result += string2.charAt(countB);
                if (countB + 1 < string2.length())
                    result += string2.charAt(countB + 1);
                countB += 2;
            }
        }
        return result;
    }
}
