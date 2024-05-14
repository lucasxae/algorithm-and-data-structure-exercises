package readFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class readFiles {

   private int roomId;
   private int hostId;
   private String roomType;
   private String country;
   private String city;
   private String neighbourhood;
   private int reviews;
   private double overallSatisfaction;
   private int accommodates;
   private double bedrooms;
   private double price;
   private String propertyType;

   public readFiles(int roomId, int hostId, String roomType, String country, String city, String neighbourhood,
         int reviews, double overallSatisfaction, int accommodates, double bedrooms, double price,
         String propertyType) {
      this.roomId = roomId;
      this.hostId = hostId;
      this.roomType = roomType;
      this.country = country;
      this.city = city;
      this.neighbourhood = neighbourhood;
      this.reviews = reviews;
      this.overallSatisfaction = overallSatisfaction;
      this.accommodates = accommodates;
      this.bedrooms = bedrooms;
      this.price = price;
      this.propertyType = propertyType;
   }

   public readFiles() {
      this.roomId = 0;
      this.hostId = 0;
      this.roomType = "";
      this.country = "";
      this.city = "";
      this.neighbourhood = "";
      this.reviews = 0;
      this.overallSatisfaction = 0;
      this.accommodates = 0;
      this.bedrooms = 0;
      this.price = 0;
      this.propertyType = "";
   }

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

   public String getNeighbourhood() {
      return neighbourhood;
   }

   public void setNeighbourhood(String neighbourhood) {
      this.neighbourhood = neighbourhood;
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

   public readFiles clone() {
      return new readFiles(this.roomId, this.hostId, this.roomType, this.country, this.city, this.neighbourhood,
            this.reviews, this.overallSatisfaction, this.accommodates, this.bedrooms, this.price, this.propertyType);
   }

   public void imprimir() {
      System.out.println("[" + this.roomId + " ## " + this.hostId + " ## " + this.roomType + " ## " + this.country
            + " ## " + this.city + " ## " + this.neighbourhood + " ## " + this.reviews + " ## "
            + this.overallSatisfaction
            + " ## " + this.accommodates + " ## " + this.bedrooms + " ## " + this.price + " ## " + this.propertyType
            + "]");
   }

   public void ler(String line) {
      String[] array = line.split("\t");
      setRoomId(Integer.parseInt(array[0]));
      setHostId(Integer.parseInt(array[1]));
      setRoomType(array[2]);
      setCountry(array[3]);
      setCity(array[4]);
      setNeighbourhood(array[5]);
      setReviews(Integer.parseInt(array[6]));
      setOverallSatisfaction(Double.parseDouble(array[7]));
      setAccommodates(Integer.parseInt(array[8]));
      setBedrooms(Double.parseDouble(array[9]));
      setPrice(Double.parseDouble(array[10]));
      setPropertyType(array[11]);
   }

   public static void main(String[] args) throws IOException {
      Scanner sc = new Scanner(System.in);
      File arq = new File("/tmp/dados_airbnb.txt");
      
      readFiles[] readFiles = new readFiles[200000];

      try (BufferedReader br = new BufferedReader(new FileReader(arq))) {
         String line;
         br.readLine();
         int index = 0;

         while ((line = br.readLine()) != null && index < readFiles.length) {
            readFiles rf = new readFiles();
            rf.ler(line);
            readFiles[index] = rf;
            index++;
         }
         br.close();
      } catch (FileNotFoundException e) {
         System.out.println("Error: " + e.getMessage());
      }

      for (int i = 0; i < readFiles.length; i++) {
         String search = sc.nextLine();
         if (search.equals("FIM")) {
            break;
         }
         for (readFiles rf : readFiles) {
            if (rf.getRoomId() == Integer.parseInt(search)) {
               rf.imprimir();
               break;
            }
         }
      }
      sc.close();
   }
}