public class Queue {

    Node front, rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(String Nama) {
        Node newNode = new Node(Nama);
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
        System.out.println("Jemaah yang berangkat: " + front.Nama);
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
                System.out.print(temp.Nama + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}