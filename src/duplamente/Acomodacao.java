// package duplamente;

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

  public static void ordenar(Acomodacao[] acomodacoes, int comeco, int fim) {
    int part;
    if (comeco < fim) {
      part = particionar(acomodacoes, comeco, fim);
      ordenar(acomodacoes, comeco, part - 1);
      ordenar(acomodacoes, part + 1, fim);
    }
  }

  public static int particionar(Acomodacao[] acomodacoes, int comeco, int fim) {
    Acomodacao pivot = acomodacoes[fim];
    int i = comeco - 1;
    for (int j = comeco; j < fim; j++) {
      if (acomodacoes[j].price < pivot.price) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
      if (acomodacoes[j].price == pivot.price &&
          acomodacoes[j].roomType.compareTo(pivot.roomType) < 0) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
      if (acomodacoes[j].price == pivot.price && acomodacoes[j].roomType.equals(pivot.roomType)
          && acomodacoes[j].roomId < pivot.roomId) {
        i++;
        trocarPosicao(acomodacoes, i, j);
      }
    }
    trocarPosicao(acomodacoes, i + 1, fim);
    return (i + 1);

  }

  public static void trocarPosicao(Acomodacao[] acomodacoes, int i, int j) {
    Acomodacao temp = acomodacoes[i];
    acomodacoes[i] = acomodacoes[j];
    acomodacoes[j] = temp;
  }

  public static int compare(Acomodacao a1, Acomodacao a2) {
    if (a1.getPrice() != a2.getPrice()) {
      return Double.compare(a1.getPrice(), a2.getPrice());
    } else {
      int roomTypeComparison = a1.getRoomType().compareTo(a2.getRoomType());
      if (roomTypeComparison != 0) {
        return roomTypeComparison;
      } else {
        return Integer.compare(a1.getRoomId(), a2.getRoomId());
      }
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    File arquivo = new File("/tmp/dados_airbnb.txt");
    Acomodacao[] quartos = new Acomodacao[127992];
    ListaDupla<Acomodacao> lista = new ListaDupla<>();

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

      int numeroQuartos = sc.nextInt();

      Acomodacao[] quartosFiltrados = new Acomodacao[numeroQuartos];
      for (int i = 0; i < numeroQuartos; i++) {
        String pesquisa = sc.next();
        for (Acomodacao acomodacao : quartos) {
          if (acomodacao.roomId == Integer.parseInt(pesquisa)) {
            quartosFiltrados[i] = acomodacao;
            break;
          }
        }
      }
      Acomodacao.ordenar(quartosFiltrados, 0, quartosFiltrados.length - 1);

      for (Acomodacao acomodacao : quartosFiltrados) {
        lista.inserirFinal(acomodacao);
      }

      for (int i = 0; i < quartosFiltrados.length; i++) {
        System.out.println("[" + i + "] " + quartosFiltrados[i].toString());
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    sc.close();
  }
}

class ListaDupla<E> {

  private Celula<E> primeiro;
  private Celula<E> ultimo;
  private int tamanho;

  public ListaDupla() {

    Celula<E> sentinela = new Celula<>();

    this.primeiro = this.ultimo = sentinela;
    this.tamanho = 0;
  }

  public boolean vazia() {

    return (this.primeiro == this.ultimo);
  }

  public void inserirFinal(E novo) {

    Celula<E> novaCelula = new Celula<>(novo, this.ultimo, null);

    this.ultimo.setProximo(novaCelula);
    this.ultimo = novaCelula;

    this.tamanho++;

  }

  public E removerFinal() {

    Celula<E> removida, penultima;

    if (vazia())
      throw new IllegalStateException("Não foi possível remover o último item da lista: "
          + "a lista está vazia!");

    removida = this.ultimo;

    penultima = this.ultimo.getAnterior();
    penultima.setProximo(null);

    removida.setAnterior(null);

    this.ultimo = penultima;

    this.tamanho--;

    return (removida.getItem());
  }
}

class Celula<T> {

  private final T item;
  private Celula<T> anterior;
  private Celula<T> proximo;

  public Celula() {
    this.item = null;
    setAnterior(null);
    setProximo(null);
  }

  public Celula(T item) {
    this.item = item;
    setAnterior(null);
    setProximo(null);
  }

  public Celula(T item, Celula<T> anterior, Celula<T> proximo) {
    this.item = item;
    this.anterior = anterior;
    this.proximo = proximo;
  }

  public T getItem() {
    return item;
  }

  public Celula<T> getAnterior() {
    return anterior;
  }

  public void setAnterior(Celula<T> anterior) {
    this.anterior = anterior;
  }

  public Celula<T> getProximo() {
    return proximo;
  }

  public void setProximo(Celula<T> proximo) {
    this.proximo = proximo;
  }
}
