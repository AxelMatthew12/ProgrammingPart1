package TebakKata;
import java.util.Scanner;

public class TebakKata{
    
    public static void Dasboard(){
        System.out.println("=========== T E B A K ===========");
        System.out.println("||           K A T A           ||");
        System.out.println("---------------------------------");
        System.out.println("|| 1. MASUK KE GAME            ||");
        System.out.println("|| 2. KELUAR DARI GAME         ||");
        System.out.println("---------------------------------");
        System.out.println("||Pilihan anda                 ||");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilih;
        do {
            Dasboard();
            
        }
    }
}
