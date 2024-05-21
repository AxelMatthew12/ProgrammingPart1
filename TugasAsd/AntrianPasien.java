package TugasAsd;
import java.util.Scanner;

public class AntrianPasien {
    class Node {
        String nama;
        String noAntrian;
        Node previous;
        Node next;

        public Node(String nama, String noAntrian) {
            this.nama = nama;
            this.noAntrian = noAntrian;
        }
    }

    Node head, tail = null;

    public void addNode(String nama, String noAtrian) {
        Node newNode = new Node(nama, noAtrian);
        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void printNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print("Nama        | "+ "\t" +"No Antrian      |"+"\n");
            System.out.println(current.nama + "\t" + "\t" + current.noAntrian);
            current = current.next;
        }
        System.out.println();
    }

    public void removeNode(String nama) {
        if (head == null) {
            System.out.println("Double Linked list is empty");
            return;
        }
        if (head.nama.equals(nama)) {
            head = head.next;
            head.previous = null;
            return;
        }
        if (tail.nama.equals(nama)) {
            tail = tail.previous;
            tail.next = null;
            return;
        }
        Node current = head;
        while (current != null) {
            {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return;
            }
        }
        System.out.println("Node with name "+ nama + "not found in the line");
    }
    public String peek() {
        if (head == null) {
            return "Antrian kosong";
        } else {
            return "Antrian pertama: " + head.nama + " - " + head.noAntrian;
        }
    }
    public void peekAll() {
        Node current = head;
        System.out.println("Isi Linked List:");
        while (current != null) {
            System.out.println(current.nama + " " + current.noAntrian);
            current = current.next;
        }
        System.out.println();
    }
}

class Testing{
    
        public static void Menu() {
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengantri Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("+++++++++++++++++++++++++++++++++");
            System.out.println("Masukkan Pilihan anda: ");
            System.out.println("---------------------------------");
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            AntrianPasien antri = new AntrianPasien();
            int pilih;
            String nama;
            boolean lanjut = true;
            do {
                Menu();
                pilih = sc.nextInt();
                sc.nextLine(); 
    
                switch (pilih) {
                    case 1:
                        do {
                            System.out.println("Masukkan nama (Ketik 'selesai' untuk mengakhiri ): ");
                            nama = sc.nextLine();
                            if (!nama.equalsIgnoreCase("selesai")) {
                                System.out.println("Masukkan no Antrian: ");
                                String noAntrian = sc.nextLine();
                                antri.addNode(nama, noAntrian);
                            }
                        } while (!nama.equalsIgnoreCase("selesai"));
                        antri.printNodes();
                        break;
    
                    case 2:
                        System.out.println("Masukkan nama untuk menghapus antrian: ");
                        String namaHapus = sc.nextLine();
                        antri.removeNode(namaHapus);
                        System.out.println("Antrian untuk " + namaHapus + " telah dihapus.");
                        break;
    
                    case 3:
                        antri.peekAll();
                        break;
                        // System.out.println(antri.peek());
                        // break;
    
                    case 4:
                        antri.peekAll();
                        break;
    
                    default:
                        lanjut = false;
                        break;
                }
            } while (lanjut);
            sc.close();
        }
    }
