public class Sorting {
    
    // Sorting berdasarkan tanggal pendaftaran menggunakan Bubble Sort
    public static void sortByTanggal(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return; 
        }

        boolean swapped;
        do {
            swapped = false;
            Node temp = linkedList.head;
            while (temp != null && temp.next != null) {
                if (temp.TanggalPendaftaran.compareTo(temp.next.TanggalPendaftaran) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        linkedList.display();
    }

    // Sorting berdasarkan nama menggunakan Bubble Sort
    public static void sortByNama(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return; 
        }

        boolean swapped;
        do {
            swapped = false;
            Node temp = linkedList.head;
            while (temp != null && temp.next != null) {
                if (temp.Nama.compareTo(temp.next.Nama) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        linkedList.display();
    }

    // Sorting berdasarkan nama menggunakan Bubble Sort
    public static void sortByNoPendaftaran(LinkedList linkedList) {
        if (linkedList.head == null || linkedList.head.next == null) {
            return; 
        }

        boolean swapped;
        do {
            swapped = false;
            Node temp = linkedList.head;
            while (temp != null && temp.next != null) {
                if (temp.nomorPendaftaran.compareTo(temp.next.nomorPendaftaran) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
        linkedList.display();
    }

    // Ini metode untuk membantu proses penukaran data antara dua node
    private static void swapData(Node node1, Node node2) {
        String tempNomor = node1.nomorPendaftaran;
        String tempTanggal = node1.TanggalPendaftaran;
        Boolean tempStatus = node1.StatusPembayaran;
        String tempNama = node1.Nama;
        String tempJenis = node1.JenisKelamin;
        int tempUmur = node1.Umur;

        node1.nomorPendaftaran = node2.nomorPendaftaran;
        node1.TanggalPendaftaran = node2.TanggalPendaftaran;
        node1.StatusPembayaran = node2.StatusPembayaran;
        node1.Nama = node2.Nama;
        node1.JenisKelamin = node2.JenisKelamin;
        node1.Umur = node2.Umur;

        node2.nomorPendaftaran = tempNomor;
        node2.TanggalPendaftaran = tempTanggal;
        node2.StatusPembayaran = tempStatus;
        node2.Nama = tempNama;
        node2.JenisKelamin = tempJenis;
        node2.Umur = tempUmur;
    }
}
