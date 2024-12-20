public class Stack {
    class Node {
        String tanggal2;
        double jumlah;
        String Metode;
        Node next;

        Node(String tanggal, double jumlah, String metode) {
            this.tanggal2 = tanggal;
            this.jumlah = jumlah;
            this.Metode = metode;
            this.next = null;
        }
    }

    Node top;

    public Stack() {
        top = null;
    }

    public void push(String tanggal, double jumlah, String metode) {
        Node newNode = new Node(tanggal, jumlah, metode);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (top == null) {
            System.out.println("Tidak ada transaksi untuk dibatalkan.");
        } else {
            System.out.println("Pembayaran tanggal " + top.tanggal2 + " dengan jumlah Rp" + top.jumlah + " dibatalkan.");
            top = top.next;
        }
    }
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Riwayat pembayaran kosong.");
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.println("Tanggal                         : " + temp.tanggal2);
                System.out.println("Jumlah                          : Rp" + temp.jumlah);
                System.out.println("Metode Pembayaran cash/transfer : " + temp.Metode);
                temp = temp.next;
            }
        }
    }
        public int totalPembayaran() {
            int total = 0;
            Node temp = top;
            while (temp != null) {
                total += temp.jumlah;
                temp = temp.next;
            }
            return total;
    }
}