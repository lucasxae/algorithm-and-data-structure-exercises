package aac;

public class Lista<E> {

    private Celula<E> primeiro;
    private Celula<E> ultimo;
    private int tamanho;

    public Lista() {

        Celula<E> sentinela = new Celula<>();

        this.primeiro = this.ultimo = sentinela;
        this.tamanho = 0;
    }

    public boolean vazia() {

        return (this.primeiro == this.ultimo);
    }

    public void inserir(E novo, int posicao) {

        Celula<E> anterior, novaCelula, proximaCelula;

        if ((posicao < 0) || (posicao > this.tamanho))
            throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: "
                    + "a posição informada é inválida!");

        anterior = this.primeiro;
        for (int i = 0; i < posicao; i++)
            anterior = anterior.getProximo();

        novaCelula = new Celula<>(novo);

        proximaCelula = anterior.getProximo();

        anterior.setProximo(novaCelula);
        novaCelula.setProximo(proximaCelula);

        if (posicao == this.tamanho) // a inserção ocorreu na última posição da lista
            this.ultimo = novaCelula;

        this.tamanho++;
    }

    public E remover(int posicao) {

        Celula<E> anterior, celulaRemovida, proximaCelula;

        if (vazia())
            throw new IllegalStateException("Não foi possível remover o item da lista: "
                    + "a lista está vazia!");

        if ((posicao < 0) || (posicao >= this.tamanho))
            throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: "
                    + "a posição informada é inválida!");

        anterior = this.primeiro;
        for (int i = 0; i < posicao; i++)
            anterior = anterior.getProximo();

        celulaRemovida = anterior.getProximo();

        proximaCelula = celulaRemovida.getProximo();

        anterior.setProximo(proximaCelula);
        celulaRemovida.setProximo(null);

        if (celulaRemovida == this.ultimo)
            this.ultimo = anterior;

        this.tamanho--;

        return (celulaRemovida.getItem());
    }

    public void inserirInicio(E item) {
        Celula<E> novaCelula, proximaCelula;
        novaCelula = new Celula<>(item);

        proximaCelula = this.primeiro.getProximo();

        primeiro.setProximo(novaCelula);
        novaCelula.setProximo(proximaCelula);

        tamanho++;

    }

    public E removerFinal() {
        Celula<E> removiCelula, aux;
        aux = this.primeiro;

        for (int i = 0; i < tamanho - 1; i++)
            aux = aux.getProximo();

        removiCelula = aux.getProximo();

        aux.setProximo(null);

        this.ultimo = aux;

        this.tamanho--;

        return (removiCelula.getItem());

    }

    public void imprimir() {
        Celula<E> aux = this.primeiro.getProximo();
        int pos = 0;

        while (aux != null) {
            System.out.println("Posição: " + pos + ", Valor: " + aux.getItem().toString());
            aux = aux.getProximo();
            pos++;
        }
    }

}