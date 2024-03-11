package JAVA;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);

       Main main= new Main();

       System.out.println("Masukkan nama: ");
       main.nama= sc.nextLine();

       System.out.println("Masukkan NIM anda: ");
       main.nim= sc.nextLine();

       System.out.println("Masukkan umur anda: ");
       main.age= sc.nextInt();

       main.display();

       sc.close();
}
}
