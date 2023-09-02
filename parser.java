import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
 public static int sizefile(String fileName) throws FileNotFoundException {
  File file = new File(fileName);
  Scanner sc = new Scanner(file);
  int size = 0;
  sc.nextLine();
  while (sc.hasNextLine()) {
   sc.nextLine();
   size++;
  }
  sc.close();
  return size;
 }

 public static void readfile(String[] nameArr, double[] balArr, int[] accArr, String fileName, int size) throws FileNotFoundException {
  File file = new File(fileName);
  Scanner sc = new Scanner(file);
  int i = 0;
  sc.nextLine();
  while (sc.hasNextLine()) {
   String line = sc.nextLine();
   String[] parts = line.split(",");
   accArr[i] = Integer.parseInt(parts[0]);
   nameArr[i] = parts[1];
   balArr[i] = Double.parseDouble(parts[2]);
   i++;
  }
  sc.close();
  
 }
 public static void displayarr(String[] nameArr, double[] balArr, int[] accArr, String fileName, int size){
  for (int i = 0; i < size; i++) {
   System.out.println("Account ID: " + accArr[i] + ", Name: " + nameArr[i] + ", Balance: " + balArr[i]);}
 }
 public static void updateacc(int[] accArr, double[] balArr,int ID,double amount,int size) {
  for (int i = 0; i < size; i++) {
          if (ID == accArr[i]) {
               balArr[i] += amount;
               break;
          } else if (i == size - 1) {
               System.out.printf("%d does not exist\n", ID);
          }
    }
 }
 public static void main(String[] args) throws FileNotFoundException {
  String fileName = "test.txt";
  int size = sizefile(fileName);
  String[] nameArr = new String[size];
  double[] balArr = new double[size];
  int[] accArr = new int[size];

  readfile(nameArr, balArr, accArr, fileName, size);
  displayarr(nameArr, balArr, accArr, fileName, size);
  updateacc(accArr, balArr,1,200.3,size);
  System.out.println("------------------------------------------------------------");
  displayarr(nameArr, balArr, accArr, fileName, size);
 }
}