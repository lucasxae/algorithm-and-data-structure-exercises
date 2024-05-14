package expressaoMatematica;
/*
 * Implemente um programa, em Java, que receba uma expressão matemática e imprima, na saída padrão, a mesma na notação polonesa reversa. 
 * É obrigatório o uso, em seu programa, de pilhas implementadas por meio de células auto- referenciadas.
   A entrada padrão é composta por várias linhas sendo que a última apresenta apenas a palavra FIM. 
   A saída padrão contém o resultado da conversão da linha de entrada correspondente
 */
import java.util.NoSuchElementException;
import java.util.Scanner;

public class expression {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static String mathExpression(String expressao) {
        Pilha<Character> pilha = new Pilha<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < expressao.length(); i++) {
            char item = expressao.charAt(i);

            if (Character.isWhitespace(item)) {
                continue;
            } else if (Character.isLetterOrDigit(item)) {
                output.append(item + " ");
            } else if (isOperator(item)) {
                while (!pilha.vazia() && isOperator(pilha.consultarTopo())
                        && precedence(pilha.consultarTopo()) >= precedence(item)) {
                    output.append(pilha.desempilhar() + " ");
                }
                pilha.empilhar(item);
            } else if (item == '(') {
                pilha.empilhar(item);
            } else if (item == ')') {
                while (!pilha.vazia() && pilha.consultarTopo() != '(') {
                    output.append(pilha.desempilhar() + " ");
                }
                pilha.desempilhar();
            }
        }

        while (!pilha.vazia()) {
            output.append(pilha.desempilhar() + " ");
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String linha;

        while (!(linha = scanner.nextLine()).equals("FIM")) {
            String resultado = mathExpression(linha);
            System.out.println(resultado);
        }

        scanner.close();
    }
}

class Pilha<E> {

    private Celula<E> topo;
    private Celula<E> fundo;

    public Pilha() {

        Celula<E> sentinela = new Celula<E>();
        fundo = sentinela;
        topo = sentinela;

    }

    public boolean vazia() {
        return fundo == topo;
    }

    public void empilhar(E item) {

        topo = new Celula<E>(item, topo);
    }

    public E desempilhar() {

        E desempilhado = consultarTopo();
        topo = topo.getProximo();
        return desempilhado;

    }

    public E consultarTopo() {

        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }

        return topo.getItem();

    }

    public int tamanho() {

        int tamanho = 0;
        Celula<E> celulaAuxiliar = topo;

        while (celulaAuxiliar != fundo) {
            tamanho++;
            celulaAuxiliar = celulaAuxiliar.getProximo();
        }

        return tamanho;
    }

}

class Celula<T> {

    private final T item;
    private Celula<T> proximo;

    public Celula() {
        this.item = null;
        setProximo(null);
    }

    public Celula(T item) {
        this.item = item;
        setProximo(null);
    }

    public Celula(T item, Celula<T> proximo) {
        this.item = item;
        this.proximo = proximo;
    }

    public T getItem() {
        return item;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }
}
