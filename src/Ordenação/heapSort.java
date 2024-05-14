package Ordenação;
import java.io.*;
import java.util.*;

public class heapSort {
  private int roomId;
  private int hostId;
  private String roomType;
  private String country;
  private String city;
  private String neighborhood;
  private int reviews;
  double overallSatisfaction;
  int accommodates;
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

  public heapSort() {
  }

  public heapSort(int roomId2, int hostId2, String roomType2, String country2, String city2, String neighborhood2,
      int reviews2, double overallSatisfaction2, int accommodates2, double bedrooms2, double price2,
      String propertyType2) {
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

  public heapSort clone() {
    heapSort clone = new heapSort();
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

  public static void sort(heapSort[] arr, int n) {

    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(arr, n, i);

    for (int i = n - 1; i > 0; i--) {

      heapSort temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, i, 0);
    }
  }

  static void heapify(heapSort[] arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && (arr[l].reviews > arr[largest].reviews ||
        (arr[l].reviews == arr[largest].reviews && arr[l].roomId > arr[largest].roomId)))
      largest = l;

    if (r < n && (arr[r].reviews > arr[largest].reviews ||
        (arr[r].reviews == arr[largest].reviews && arr[r].roomId > arr[largest].roomId)))
      largest = r;

    if (largest != i) {
      heapSort swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    File arquivo = new File("/tmp/dados_airbnb.txt");
    heapSort[] quartos = new heapSort[127992];

    try (BufferedReader lerAirbnb = new BufferedReader(new FileReader(arquivo))) {
      String line;
      lerAirbnb.readLine();
      int index = 0;
      while ((line = lerAirbnb.readLine()) != null && index < quartos.length) {
        heapSort heapSort = new heapSort();
        heapSort.ler(line);
        quartos[index] = heapSort;
        index++;
      }
      lerAirbnb.close();
      int numeroQuartos = sc.nextInt();
      heapSort[] quartosFiltrados = new heapSort[numeroQuartos];
      for (int i = 0; i < numeroQuartos; i++) {
        String pesquisa = sc.next();
        for (heapSort heapSort : quartos) {
          if (heapSort.roomId == Integer.parseInt(pesquisa)) {
            quartosFiltrados[i] = heapSort;
          }
        }
      }
      sort(quartosFiltrados, numeroQuartos);

      for (heapSort heapSort : quartosFiltrados) {
        heapSort.imprimir();
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

    sc.close();
  }
}