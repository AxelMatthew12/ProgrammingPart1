package Java;
import java.util.Scanner;

public class MainResto {

    public static void Menu() {
        System.out.println("=========CE SATU LA CAFE=========");
        System.out.println("1. Add Antrian");
        System.out.println("2. Hapus Antrian");
        System.out.println("3. Lihat Antrian Pertama");
        System.out.println("4. Cetak Rekaman Antrian & Pesanan");
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HandleAntrian dl_list = new HandleAntrian();
        int pilih;
        String nama;
        boolean lanjut = true;
        do {
            Menu();
            pilih = sc.nextInt();
            sc.nextLine(); // Membersihkan newline dari input sebelumnya

            switch (pilih) {
                case 1:
                    do {
                        System.out.println("Masukkan nama (Ketik 'selesai' untuk mengakhiri ): ");
                        nama = sc.nextLine();
                        if (!nama.equalsIgnoreCase("selesai")) {
                            System.out.println("Masukkan nomor HP: ");
                            String noHp = sc.nextLine();
                            dl_list.addNode(nama, noHp);
                        }
                    } while (!nama.equalsIgnoreCase("selesai"));
                    dl_list.printNodes();
                    break;

                case 2:
                    System.out.println("Masukkan nama untuk menghapus antrian: ");
                    String namaHapus = sc.nextLine();
                    dl_list.removeNode(namaHapus);
                    System.out.println("Antrian untuk " + namaHapus + " telah dihapus.");
                    break;

                case 3:
                    System.out.println(dl_list.peek());
                    break;

                case 4:
                    // Cetak rekaman antrian dan pesanan di sini
                    break;

                default:
                    lanjut = false;
                    break;
            }
        } while (lanjut);
        sc.close();
    }
}
