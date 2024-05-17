package Java;
import java.util.Scanner;
public class MainResto {
  
    public static void Menu(){
        System.out.println("=========CE SATU LA CAFE=========");
        System.out.println("1. Add Antrian");
        System.out.println("2. Addpesanan");
        System.out.println("3. Cek Antrian Pembeli & Pesanan");
        System.out.println("4. Hapus Antrian");
        System.out.println("5. Hapus Pesanan");
        System.out.println("6. Cetak Rekaman Antrian & Pesanan");
        System.out.println("-----------------------------------");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HandleAntrian dl_list = new HandleAntrian();
        int pilih;
        String nama;
        do {
            Menu();
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("Masukkan nama (Ketik 'selesai' untuk mengakhiri ): ");
                    nama= sc.nextLine();
                    while (!nama.equalsIgnoreCase("selesai")) {
                        System.out.println("Masukkan nomor HP: ");
                        String noHp = sc.nextLine();
                        dl_list.addNode(nama, noHp);
                         System.out.println("Masukkan nama (Ketik 'selesai' untuk mengakhiri ):");
                        nama = sc.nextLine();
                
                        }
                        dl_list.printNodes();
                        sc.close();
                        
                    
                }
                    break;
            } while(pilih==1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6);
        }
    }
