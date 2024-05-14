package Ordenação;
import java.io.*;
import java.util.*;

public class AcomodacaoQuick {

  // #region Atributos

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
  static Scanner scanner;

  // #endregion

  // #region Construtores

  public AcomodacaoQuick() {
    this.roomId = 0;
    this.hostId = 0;
    this.roomType = "";
    this.country = "";
    this.city = "";
    this.neighborhood = "";
    this.reviews = 0;
    this.overallSatisfaction = 0.0;
    this.accommodates = 0;
    this.bedrooms = 0.0;
    this.price = 0.0;
    this.propertyType = "";
  }

  public AcomodacaoQuick(int roomId, int hostId, String roomType, String country, String city, String neighborhood,
      int reviews,
      double overallSatisfaction, int accommodates, double bedrooms, double price, String propertyType) {
    this.roomId = roomId;
    this.hostId = hostId;
    this.roomType = roomType;
    this.country = country;
    this.city = city;
    this.neighborhood = neighborhood;
    this.reviews = reviews;
    this.overallSatisfaction = overallSatisfaction;
    this.accommodates = accommodates;
    this.bedrooms = bedrooms;
    this.price = price;
    this.propertyType = propertyType;
  }

  // #endregion

  // #region Getters e Setters

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

  // #endregion

  // #region Métodos Auxiliares

  /**
   * Método que verifica a quantidade de linhas do arquivo para popular o vetor de
   * acomodações.
   * 
   * @param arquivo diretório do arquivo
   * @return quantidade de linhas do arquivo
   */
  private static int contarLinhasArquivo(String arquivo) throws IOException {
    try (LineNumberReader linhasLidas = new LineNumberReader(new FileReader(arquivo))) {
      linhasLidas.skip(Long.MAX_VALUE);
      return linhasLidas.getLineNumber();
    }
  }

  // #endregion

  // #region Métodos de Negócio

  /**
   * Método que clona uma acomodação.
   * 
   * @return acomodação clonada
   */
  public AcomodacaoQuick clone() {
    return new AcomodacaoQuick(this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighborhood,
        this.reviews, this.overallSatisfaction, this.accommodates, this.bedrooms, this.price, this.propertyType);
  }

  /**
   * Método que imprime os dados formatados da acomodação.
   */
  public void imprimir() {
    System.out.println("[" + this.roomId + " ## " + this.hostId + " ## " + this.roomType + " ## " + this.country
        + " ## "
        + this.city + " ## " + this.neighborhood + " ## " + this.reviews + " ## " + this.overallSatisfaction + " ## "
        + this.accommodates + " ## " + this.bedrooms + " ## " + this.price + " ## " + this.propertyType + "]");
  }

  /**
   * Método que recebe uma String de dados da acomodação, divide pelo caractere de
   * espaço e armazena o dado em sua respectiva variável.
   * 
   * @param entrada String única da linha do arquivo contendo os dados da
   *                acomodação
   */
  public void ler(String entrada) {
    String[] entradaPadrao = entrada.split("\t");
    setRoomId(Integer.parseInt(entradaPadrao[0]));
    setHostId(Integer.parseInt(entradaPadrao[1]));
    setRoomType(entradaPadrao[2]);
    setCountry(entradaPadrao[3]);
    setCity(entradaPadrao[4]);
    setNeighborhood(entradaPadrao[5]);
    setReviews(Integer.parseInt(entradaPadrao[6]));
    setOverallSatisfaction(Double.parseDouble(entradaPadrao[7]));
    setAccommodates(Integer.parseInt(entradaPadrao[8]));
    setBedrooms(Double.parseDouble(entradaPadrao[9]));
    setPrice(Double.parseDouble(entradaPadrao[10]));
    setPropertyType(entradaPadrao[11]);
  }

  /**
   * Método que lê o arquivo e armazena os dados tratados em um vetor de
   * acomodações.
   * 
   * @param arquivo     diretório do arquivo
   * @param acomodacoes vetor de acomodações
   * @throws IOException exceção de leitura de arquivo
   */
  public static void lerArquivo(String arquivo, AcomodacaoQuick[] acomodacoes) throws IOException {
    try (BufferedReader lerArquivo = new BufferedReader(new FileReader(arquivo))) {
      String line;
      lerArquivo.readLine();
      int index = 0;
      while ((line = lerArquivo.readLine()) != null && index < acomodacoes.length) {
        AcomodacaoQuick acomodacao = new AcomodacaoQuick();
        acomodacao.ler(line);
        acomodacoes[index] = acomodacao;
        index++;
      }
      lerArquivo.close();
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
  }

  public static void trocarPosicao(AcomodacaoQuick[] acomodacoes, int i, int j) {
    AcomodacaoQuick temp = acomodacoes[i];
    acomodacoes[i] = acomodacoes[j];
    acomodacoes[j] = temp;
  }

  public static int particionar(AcomodacaoQuick[] acomodacoes, int comeco, int fim) {
    AcomodacaoQuick pivot = acomodacoes[fim];
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

  public static void ordenar(AcomodacaoQuick[] acomodacoes, int comeco, int fim) {
    int part;
    if (comeco < fim) {
      part = particionar(acomodacoes, comeco, fim);
      ordenar(acomodacoes, comeco, part - 1);
      ordenar(acomodacoes, part + 1, fim);
    }
  }

  // #endregion

  public static void main(String[] args) throws IOException {
    String arquivo = "/tmp/dados_airbnb.txt";
    scanner = new Scanner(System.in);
    AcomodacaoQuick[] acomodacoes = new AcomodacaoQuick[contarLinhasArquivo(arquivo)];
    lerArquivo(arquivo, acomodacoes);

    int numQuartos = scanner.nextInt();
    AcomodacaoQuick[] quartosFiltrados = new AcomodacaoQuick[numQuartos];

    for (int i = 0; i < numQuartos; i++) {
      String busca = scanner.next();
      for (AcomodacaoQuick acomodacao : acomodacoes) {
        if (acomodacao.getRoomId() == Integer.parseInt(busca)) {
          quartosFiltrados[i] = acomodacao;
          break;
        }
      }
    }
    ordenar(quartosFiltrados, 0, numQuartos - 1);

    for (AcomodacaoQuick acomodacao : quartosFiltrados) {
      acomodacao.imprimir();
    }
    scanner.close();
  }
}