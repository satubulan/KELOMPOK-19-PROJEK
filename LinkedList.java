public class LinkedList{
    Node head, tail;

    public void addData (String nomor, String tanggal, Boolean status, String nama, String jenis, int umur) {
        Node newNode = new Node(nomor, tanggal, status, nama, jenis, umur);
        if (head == null){
            head = tail = newNode;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }   
    }
    public void hapusJemaah(String nomorPendaftaran) {
        if (head == null) {
            System.out.println("Data kosong");
            return;
        }
        if (head.nomorPendaftaran.equals(nomorPendaftaran)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.nomorPendaftaran.equals(nomorPendaftaran)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Calon jemaah tidak ditemukan");
        } else {
            temp.next = temp.next.next;
        }
    }
    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.println("Nomor Pendaftaran: " + temp.nomorPendaftaran);
            System.out.println("Tanggal Pembayaran: " + temp.TanggalPendaftaran);
            System.out.println("Status Pembayaran: " + temp.StatusPembayaran);
            System.out.println("Nama Pendaftar: " + temp.Nama);
            System.out.println("Jenis Kelamin: " + temp.JenisKelamin);
            System.out.println("Umur: " + temp.Umur);
            temp = temp.next;
            System.out.println();
        }
        System.out.println();
    }   
}
