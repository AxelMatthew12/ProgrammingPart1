package Java;

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
            return "Antrian pertama: " + head.nama + " - " + head.noHp;
        }
    }
    
}


