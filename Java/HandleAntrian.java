package Java;
import java.util.Scanner;

public class HandleAntrian {
    class Node {
        String nama;
        String noHp;
        Node previous;
        Node next;

        public Node(String nama, String noHp) {
            this.nama = nama;
            this.noHp = noHp;
        }
    }

    Node head, tail = null;

    public void addNode(String nama, String noHp) {
        Node newNode = new Node(nama, noHp);
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
            System.out.print("Nama        | "+ "\t" +"No HP      |"+"\n");
            System.out.println(current.nama + "\t" + "\t" + current.noHp);
            current = current.next;
        }
        System.out.println();
    }
}


