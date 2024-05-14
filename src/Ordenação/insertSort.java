package Ordenação;

import java.io.*;
import java.util.*;

public class insertSort {
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

    public insertSort() {
    }

    public insertSort(int roomId2, int hostId2, String roomType2, String country2, String city2, String neighborhood2,
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

    public insertSort clone() {
        insertSort clone = new insertSort();
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

    public static void sort(insertSort[] array, int n) {
        for (int i = 1; i < n; i++) {
            insertSort tmp = array[i];
            int j = i - 1;

            // Ordenar por accommodates
            while (j >= 0 && (array[j].accommodates > tmp.accommodates
                    || (array[j].accommodates == tmp.accommodates && array[j].roomId > tmp.roomId))) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File arquivo = new File("/tmp/dados_airbnb.txt");
        insertSort[] quartos = new insertSort[127992];
        try (BufferedReader lerAirbnb = new BufferedReader(new FileReader(arquivo))) {
            String line;
            lerAirbnb.readLine();
            int index = 0;
            while ((line = lerAirbnb.readLine()) != null && index < quartos.length) {
                insertSort acomodacao = new insertSort();
                acomodacao.ler(line);
                quartos[index] = acomodacao;
                index++;
            }
            lerAirbnb.close();

            int numeroQuartos = sc.nextInt();
            insertSort[] quartosFiltrados = new insertSort[numeroQuartos];
            for (int i = 0; i < numeroQuartos; i++) {
                String pesquisa = sc.next();
                for (insertSort insertSort : quartos) {
                    if (insertSort.roomId == Integer.parseInt(pesquisa)) {
                        quartosFiltrados[i] = insertSort;
                    }
                }
            }
            sort(quartosFiltrados, numeroQuartos);

            for (insertSort insertSort : quartosFiltrados) {
                insertSort.imprimir();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        sc.close();
    }
}