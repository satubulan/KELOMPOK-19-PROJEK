public class Queue {
    class Node {
        String nama;
        Node next;

        Node(String nama) {
            this.nama = nama;
            this.next = null;
        }
    }

    Node front, rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(String nama) {
        Node newNode = new Node(nama);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Antrean kosong.");
            return;
        }
        System.out.println("Jemaah yang berangkat: " + front.nama);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public void tampilkanAntrean() {
        if (front == null) {
            System.out.println("Antrean kosong.");
        } else {
            Node temp = front;
            while (temp != null) {
                System.out.print(temp.nama + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}