package ArvoreBinaria;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class PraticaABB {

    public static class No<T extends Comparable<T>> {

        private T item;
        private No<T> direita;
        private No<T> esquerda;

        public No() {
            this.setItem(null);
            this.setDireita(null);
            this.setEsquerda(null);
        }

        public No(T item) {
            this.setItem(item);
            this.setDireita(null);
            this.setEsquerda(null);
        }

        public No(T item, No<T> esquerda, No<T> direita) {
            this.setItem(item);
            this.setDireita(direita);
            this.setEsquerda(esquerda);
        }

        public T getItem() {
            return this.item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public No<T> getDireita() {
            return this.direita;
        }

        public void setDireita(No<T> direita) {
            this.direita = direita;
        }

        public No<T> getEsquerda() {
            return this.esquerda;
        }

        public void setEsquerda(No<T> esquerda) {
            this.esquerda = esquerda;
        }

        public boolean ehFolha() {
            return this.esquerda == null && this.direita == null;
        }
    }

    public static class ABB<E extends Comparable<E>> {

        private No<E> raiz;

        public ABB() {
            raiz = null;
        }

        public Boolean vazia() {
            return (this.raiz == null);
        }

        private E pesquisar(No<E> raizArvore, E procurado) {
            int comparacao;

            if (raizArvore == null)
                throw new NoSuchElementException("O item não foi localizado na árvore!");

            comparacao = procurado.compareTo(raizArvore.getItem());

            if (comparacao == 0)
                return raizArvore.getItem();
            else if (comparacao < 0)
                return pesquisar(raizArvore.getEsquerda(), procurado);
            else
                return pesquisar(raizArvore.getDireita(), procurado);
        }

        public E pesquisar(E procurado) {
            return pesquisar(this.raiz, procurado);
        }

        private No<E> adicionar(No<E> raizArvore, E item) {
            int comparacao;

            if (raizArvore == null)
                raizArvore = new No<>(item);
            else {
                comparacao = item.compareTo(raizArvore.getItem());

                if (comparacao < 0)
                    raizArvore.setEsquerda(adicionar(raizArvore.getEsquerda(), item));
                else if (comparacao > 0)
                    raizArvore.setDireita(adicionar(raizArvore.getDireita(), item));
                else
                    throw new RuntimeException("O item já foi inserido anteriormente na árvore.");
            }
            return raizArvore;
        }

        public void adicionar(E item) {
            this.raiz = adicionar(this.raiz, item);
        }

        public void caminhamentoEmOrdem() {
            if (vazia())
                throw new IllegalStateException("A árvore está vazia!");

            caminhamentoEmOrdem(this.raiz);
        }

        private void caminhamentoEmOrdem(No<E> raizArvore) {
            if (raizArvore != null) {
                caminhamentoEmOrdem(raizArvore.getEsquerda());
                System.out.println(raizArvore.getItem());
                caminhamentoEmOrdem(raizArvore.getDireita());
            }
        }

        private No<E> removerNoAntecessor(No<E> itemRetirar, No<E> raizArvore) {
            if (raizArvore.getDireita() != null)
                raizArvore.setDireita(removerNoAntecessor(itemRetirar, raizArvore.getDireita()));
            else {
                itemRetirar.setItem(raizArvore.getItem());
                raizArvore = raizArvore.getEsquerda();
            }
            return raizArvore;
        }

        private No<E> remover(No<E> raizArvore, E itemRemover) {
            int comparacao;

            if (raizArvore == null)
                throw new NoSuchElementException("O item a ser removido não foi localizado na árvore!");

            comparacao = itemRemover.compareTo(raizArvore.getItem());

            if (comparacao == 0) {
                if (raizArvore.getDireita() == null)
                    raizArvore = raizArvore.getEsquerda();
                else if (raizArvore.getEsquerda() == null)
                    raizArvore = raizArvore.getDireita();
                else
                    raizArvore.setEsquerda(removerNoAntecessor(raizArvore, raizArvore.getEsquerda()));
            } else if (comparacao < 0)
                raizArvore.setEsquerda(remover(raizArvore.getEsquerda(), itemRemover));
            else
                raizArvore.setDireita(remover(raizArvore.getDireita(), itemRemover));

            return raizArvore;
        }

        public void remover(E itemRemover) {
            this.raiz = remover(this.raiz, itemRemover);
        }

        public int numFolhas() {
            return numFolhas(this.raiz);
        }

        private int numFolhas(No<E> raizArvore) {
            if (raizArvore == null) {
                return 0;
            } else if (raizArvore.ehFolha()) {
                return 1;
            } else {
                return numFolhas(raizArvore.getEsquerda()) + numFolhas(raizArvore.getDireita());
            }
        }

        public int numNos() {
            return numNos(this.raiz);
        }

        private int numNos(No<E> raizArvore) {
            if (raizArvore == null) {
                return 0;
            } else {
                return 1 + numNos(raizArvore.getEsquerda()) + numNos(raizArvore.getDireita());
            }
        }

        public int obterAltura() {
            return obterAltura(this.raiz);
        }

        private int obterAltura(No<E> raizArvore) {
            if (raizArvore == null) {
                return -1;
            } else {
                int alturaEsquerda = obterAltura(raizArvore.getEsquerda());
                int alturaDireita = obterAltura(raizArvore.getDireita());
                return 1 + Math.max(alturaEsquerda, alturaDireita);
            }
        }
    }

    public static class Acomodacao implements Comparable<Acomodacao> {

        private int roomId;
        private int hostId;
        private String roomType;
        private String country;
        private String city;
        private String neighborhood;
        private int reviews;
        private double overallSatisfaction;
        private int accommodates;
        private double bedrooms;
        private double price;
        private String propertyType;

        public Acomodacao(String[] dados) {
            this.roomId = Integer.parseInt(dados[0]);
            this.hostId = Integer.parseInt(dados[1]);
            this.roomType = dados[2];
            this.country = dados[3];
            this.city = dados[4];
            this.neighborhood = dados[5];
            this.reviews = Integer.parseInt(dados[6]);
            this.overallSatisfaction = Double.parseDouble(dados[7]);
            this.accommodates = Integer.parseInt(dados[8]);
            this.bedrooms = Double.parseDouble(dados[9]);
            this.price = Double.parseDouble(dados[10]);
            this.propertyType = dados[11];
        }

        public int getRoomId() {
            return roomId;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public String getNeighborhood() {
            return neighborhood;
        }

        @Override
        public int compareTo(Acomodacao outra) {
            int cmp = this.country.compareTo(outra.country);
            if (cmp == 0) {
                cmp = this.city.compareTo(outra.city);
                if (cmp == 0) {
                    cmp = this.neighborhood.compareTo(outra.neighborhood);
                    if (cmp == 0) {
                        cmp = Integer.compare(this.roomId, outra.roomId);
                    }
                }
            }
            return cmp;
        }

        public String imprimirDados() {
            return "[" + roomId + " ## " + hostId + " ## " + roomType + " ## " + country + " ## " + city + " ## " +
                    neighborhood + " ## " + reviews + " ## " + overallSatisfaction + " ## " + accommodates + " ## " +
                    bedrooms + " ## " + price + " ## " + propertyType + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File arquivo = new File("/tmp/dados_airbnb.txt");

        final int MAX_ACOMODACOES = 150000;
        Acomodacao[] acomodacoes = new Acomodacao[MAX_ACOMODACOES];
        int qtdAcomodacoes = 0;

        try (Scanner fileScanner = new Scanner(arquivo)) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine() && qtdAcomodacoes < MAX_ACOMODACOES) {
                String linha = fileScanner.nextLine();
                Acomodacao acomodacao = new Acomodacao(linha.split("\t"));
                acomodacoes[qtdAcomodacoes++] = acomodacao;
            }
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("FIM"))
                break;

            int numEntradas = Integer.parseInt(input);
            ABB<Acomodacao> arvore = new ABB<>();

            for (int i = 0; i < numEntradas; i++) {
                int roomId = Integer.parseInt(scanner.nextLine());
                boolean encontrado = false;
                for (int j = 0; j < qtdAcomodacoes; j++) {
                    if (acomodacoes[j] != null && acomodacoes[j].getRoomId() == roomId) {
                        arvore.adicionar(acomodacoes[j]);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("ID " + roomId + " não encontrado.");
                }
            }

            System.out.println("Numero de folhas da arvore: " + arvore.numFolhas());
            System.out.println("Numero de acomodacoes presentes na arvore: " + arvore.numNos());
            System.out.println("Altura da arvore: " + arvore.obterAltura());
        }

        scanner.close();
    }
}
