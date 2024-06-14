package SitesWeb;


import java.util.*;

class Site {
  private String nome;
  private String endereco;
  private int acessos;

  public Site(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
    this.acessos = 0;
  }

  public String getNome() {
    return nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public int getAcessos() {
    return acessos;
  }

  public void incrementarAcesso() {
    acessos++;
  }
}

class Lista<E> {
  private final E[] lista;
  private final int primeiro;
  private int ultimo;

  @SuppressWarnings("unchecked")
  public Lista(int tamanho) {
    lista = (E[]) new Object[tamanho];
    this.ultimo = this.primeiro = 0;
  }

  public boolean vazia() {
    return (this.primeiro == this.ultimo);
  }

  public boolean cheia() {
    return (this.ultimo == this.lista.length);
  }

  public void inserir(E novo, int posicao) {
    if (cheia())
      throw new IllegalStateException("Não foi possível inserir o item na lista: a lista está cheia!");

    if ((posicao < 0) || (posicao > this.ultimo))
      throw new IndexOutOfBoundsException("Não foi possível inserir o item na lista: a posição informada é inválida!");

    for (int i = this.ultimo; i > posicao; i--)
      lista[i] = lista[i - 1];

    lista[posicao] = novo;
    this.ultimo++;
  }

  public E remover(int posicao) {
    E removido;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o item da lista: a lista está vazia!");

    if ((posicao < 0) || (posicao >= this.ultimo))
      throw new IndexOutOfBoundsException("Não foi possível remover o item da lista: a posição informada é inválida!");

    removido = lista[posicao];
    this.ultimo--;

    for (int i = posicao; i < this.ultimo; i++)
      lista[i] = lista[i + 1];

    return removido;
  }

  public void moverParaInicio(int posicao) {
    if (vazia())
      throw new IllegalStateException("Não foi possível mover o item para o início da lista: a lista está vazia!");

    if ((posicao < 0) || (posicao >= this.ultimo))
      throw new IndexOutOfBoundsException(
          "Não foi possível mover o item para o início da lista: a posição informada é inválida!");

    E item = lista[posicao];
    for (int i = posicao; i > 0; i--)
      lista[i] = lista[i - 1];

    lista[0] = item;
  }

  public void buscarItem(E item) {
    if (vazia()) {
      return;
    }
    for (int i = 0; i < this.ultimo; i++) {
      Site site = (Site) lista[i];

      if (site.getNome().equals(((Site) item).getNome())) {
        site.incrementarAcesso();
        moverParaInicio(i);
        System.out.println(site.getEndereco());
        break;
      }
      if (i == this.ultimo - 1)
        System.out.println("O item procurado nao foi encontrado!");
    }

  }

  public void imprimir() {
    for (int i = 0; i < this.ultimo; i++) {
      Site site = (Site) lista[i];
      System.out.println("Nome: [" + site.getNome() + "]");
      System.out.println("Endereco: [" + site.getEndereco() + "]");
      System.out.println("Numero de acessos: " + site.getAcessos());
    }
  }
}

public class teste {
  static Scanner scanner;

  public static void main(String[] args) {
    int qtdSites;
    scanner = new Scanner(System.in);
    qtdSites = scanner.nextInt();
    scanner.nextLine();

    Lista<Site> lista = new Lista<>(qtdSites);

    for (int i = 0; i < qtdSites; i++) {
      String linha = scanner.nextLine();
      String[] partes = linha.split(" - ");
      String nome = partes[0];
      String endereco = partes[1];
      Site site = new Site(nome, endereco);
      lista.inserir(site, i);
    }

    String entrada = scanner.nextLine();
    Site site = new Site(entrada, "");
    while (!entrada.equals("FIM")) {
      site = new Site(entrada, "");
      lista.buscarItem(site);
      entrada = scanner.nextLine();
    }
    lista.imprimir();
  }
}

