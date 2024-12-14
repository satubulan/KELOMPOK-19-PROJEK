public class Stack {
        static class Node {
            String tanggal2;
            double jumlah;
            Node next;
    
            Node(String tanggal, double jumlah) {
                this.tanggal2 = tanggal;
                this.jumlah = jumlah;
                this.next = null;
            }
        }
    
        Node top;
    
        public Stack() {
            top = null;
        }
 
        public void push(String tanggal, double jumlah) {
            Node newNode = new Node(tanggal, jumlah);
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
                    System.out.println("Tanggal: " + temp.tanggal2 + ", Jumlah: Rp" + temp.jumlah);
                    temp = temp.next;
                }
            }
        }
    }
    
