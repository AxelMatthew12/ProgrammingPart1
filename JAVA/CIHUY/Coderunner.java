package JAVA.CIHUY;
import java.util.Scanner;
public class Coderunner {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Main main= new Main();
        System.out.println(" =========== Selamat datang ========= ");
        System.out.println(" ||     Masukkan nama anda :       || ");
        main.nama= sc.nextLine();
        System.out.println(" ||      Masukkan umur anda :      || ");
        main.umur= sc.nextLine();
        

        main.Display();
    }
}
