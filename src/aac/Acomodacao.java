package aac;

import java.io.*;
import java.util.*;

public class Acomodacao {
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

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public int getHostId() {
    return hostId;
  }

  public void setHostId(int hostId) {
    this.hostId = hostId;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public int getReviews() {
    return reviews;
  }

  public void setReviews(int reviews) {
    this.reviews = reviews;
  }

  public double getOverallSatisfaction() {
    return overallSatisfaction;
  }

  public void setOverallSatisfaction(double overallSatisfaction) {
    this.overallSatisfaction = overallSatisfaction;
  }

  public int getAccommodates() {
    return accommodates;
  }

  public void setAccommodates(int accommodates) {
    this.accommodates = accommodates;
  }

  public double getBedrooms() {
    return bedrooms;
  }

  public void setBedrooms(double bedrooms) {
    this.bedrooms = bedrooms;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  public Acomodacao() {
  }

  public Acomodacao(int roomId2, int hostId2, String roomType2, String country2, String city2, String neighborhood2,
      int reviews2, double overallSatisfaction2, int accommodates2, double bedrooms2, double price2,
      String propertyType2) {
    this.roomId = roomId2;
    this.hostId = hostId2;
    this.roomType = roomType2;
    this.country = country2;
    this.city = city2;
    this.neighborhood = neighborhood2;
    this.reviews = reviews2;
    this.overallSatisfaction = overallSatisfaction2;
    this.accommodates = accommodates2;
    this.bedrooms = bedrooms2;
    this.price = price2;
    this.propertyType = propertyType2;
  }

  @Override
  public Acomodacao clone() {
    Acomodacao clone = new Acomodacao();
    clone.setRoomId(this.roomId);
    clone.setHostId(this.hostId);
    clone.setRoomType(this.roomType);
    clone.setCountry(this.country);
    clone.setCity(this.city);
    clone.setNeighborhood(this.neighborhood);
    clone.setReviews(this.reviews);
    clone.setOverallSatisfaction(this.overallSatisfaction);
    clone.setAccommodates(this.accommodates);
    clone.setBedrooms(this.bedrooms);
    clone.setPrice(this.price);
    clone.setPropertyType(this.propertyType);
    return clone;
  }

  @Override
  public String toString() {
    return String.format("[%d ## %d ## %s ## %s ## %s ## %s ## %d ## %.1f ## %d ## %.1f ## %.1f ## %s]",
        this.roomId,
        this.hostId,
        this.roomType,
        this.country,
        this.city,
        this.neighborhood,
        this.reviews,
        this.overallSatisfaction,
        this.accommodates,
        this.bedrooms,
        this.price,
        this.propertyType);
  }

  public void imprimir() {
    String formatado = String.format("[%d ## %d ## %s ## %s ## %s ## %s ## %d ## %.1f ## %d ## %.1f ## %.1f ## %s]",
        this.roomId,
        this.hostId,
        this.roomType,
        this.country,
        this.city,
        this.neighborhood,
        this.reviews,
        this.overallSatisfaction,
        this.accommodates,
        this.bedrooms,
        this.price,
        this.propertyType);
    System.out.println(formatado);
  }

  public void ler(String entrada) {
    String[] leitura = entrada.split("\t");
    setRoomId(Integer.parseInt(leitura[0]));
    setHostId(Integer.parseInt(leitura[1]));
    setRoomType(leitura[2]);
    setCountry(leitura[3]);
    setCity(leitura[4]);
    setNeighborhood(leitura[5]);
    setReviews(Integer.parseInt(leitura[6]));
    setOverallSatisfaction(Double.parseDouble(leitura[7]));
    setAccommodates(Integer.parseInt(leitura[8]));
    setBedrooms(Double.parseDouble(leitura[9]));
    setPrice(Double.parseDouble(leitura[10]));
    setPropertyType(leitura[11]);
  }

  public static void sort(Acomodacao[] array, int n) {
    for (int i = (n - 1); i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j].overallSatisfaction == array[j + 1].overallSatisfaction && array[j].roomId > array[j + 1].roomId) {
          Acomodacao temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
        if (array[j].overallSatisfaction > array[j + 1].overallSatisfaction) {
          Acomodacao temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    File arquivo = new File("/tmp/dados_airbnb.txt");
    Acomodacao[] quartos = new Acomodacao[127992];
    Lista<Acomodacao> lista = new Lista<>();

    try (BufferedReader lerAirbnb = new BufferedReader(new FileReader(arquivo))) {
      String line;
      lerAirbnb.readLine();
      int index = 0;
      while ((line = lerAirbnb.readLine()) != null && index < quartos.length) {
        Acomodacao acomodacao = new Acomodacao();
        acomodacao.ler(line);
        quartos[index] = acomodacao;
        index++;
      }

      String pesquisa;
      while (!(pesquisa = sc.next()).equals("FIM")) {
        for (Acomodacao acomodacao : quartos) {
          if (acomodacao.getRoomId() == Integer.parseInt(pesquisa)) {
            lista.inserirInicio(acomodacao);
          }
        }
      }

      int numeroComandos = sc.nextInt();
      for (int i = 0; i < numeroComandos; i++) {
        String comando = sc.next();
        if (comando.equals("II")) {
          String id = sc.next();
          for (Acomodacao acomodacao : quartos) {
            if (acomodacao.getRoomId() == Integer.parseInt(id)) {
              lista.inserirInicio(acomodacao);
            }
          }
        } else if (comando.equals("RF")) {
          Acomodacao removida = lista.removerFinal();
          System.out.println("(R) " + removida.getRoomId());
        }
      }

      lista.imprimir();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    sc.close();
  }
}

class Lista<E> {

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
      System.out.println("[" + pos + "] " + aux.getItem().toString());
      aux = aux.getProximo();
      pos++;
    }
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
