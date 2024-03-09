package JAVA;
import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Main main= new Main();
        main.getNama();
        
        System.out.println("Masukkan nama anda: ");
        main.age= sc.nextInt();
        System.out.println("Umur anda adalah: " + main.age);
       
}
}
