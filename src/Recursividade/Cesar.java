package Recursividade;
import java.util.Scanner;

public class Cesar {

    public static char[] criptografar(char[] separacao, int unidade) {
        
        

        if(unidade >= separacao.length){
            return separacao;
        }
        
        
        if(separacao.equals(' ')){
            separacao[unidade] = '#';
            criptografar(separacao, unidade + 1);
        }

        if(separacao.equals('-')){
            separacao[unidade] = '0';
            criptografar(separacao, unidade);
        }else{
            separacao[unidade] = (char)(separacao[unidade] + 3);
            return criptografar(separacao, unidade + 1);
        }
        return separacao;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String texto = sc.nextLine();
        

        while (!texto.equals("FIM")) {
            char[] separacao = texto.toCharArray();
            System.out.println(criptografar(separacao, 0));
            texto = sc.nextLine();
        
        }
        sc.close();
    }
}