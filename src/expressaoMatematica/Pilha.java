package expressaoMatematica;

import java.util.NoSuchElementException;

public class Pilha<E> {

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

    // 1
    public void concatenar(Pilha<E> pilha) {

        Celula<E> celulaAuxiliar = pilha.topo;

        while (celulaAuxiliar != pilha.fundo) {
            empilhar(celulaAuxiliar.getItem());
            celulaAuxiliar = celulaAuxiliar.getProximo();
        }
    }

    // 2
    public int obterNumeroItens() {
        int tamanho = 0;
        Celula<E> celulaAuxiliar = topo;
        while (celulaAuxiliar != fundo) {
            tamanho++;
            celulaAuxiliar = celulaAuxiliar.getProximo();
        }
        return tamanho;
    }

    // 3
    public Pilha<E> inverter() {
        Pilha<E> pilhaAuxiliar = new Pilha<E>();
        Celula<E> celulaAuxiliar = topo;
        while (topo != fundo) {
            pilhaAuxiliar.empilhar(celulaAuxiliar.getItem());
            celulaAuxiliar = celulaAuxiliar.getProximo();
        }
        return pilhaAuxiliar;
    }

}
