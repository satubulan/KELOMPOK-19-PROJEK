public class LinkedList {
    Node head;
    public void addData(String nomorPendaftaran, String TanggalPendaftaran, boolean StatusPembayaran, 
    String Nama, String JenisKelamin, int Umur, String ahliWarisPertama, String ahliWarisKedua, String Penyakit) {
        
        Node newNode = new Node(nomorPendaftaran, TanggalPendaftaran, StatusPembayaran, 
        Nama, JenisKelamin, Umur, ahliWarisPertama, ahliWarisKedua, Penyakit);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public boolean cekNomorPendaftaran(String nomorPendaftaran) {
        Node temp = head;
        while (temp != null) {
            if (temp.nomorPendaftaran.equals(nomorPendaftaran)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean cekNama(String Nama) {
        Node temp = head;
        while (temp != null) {
            if (temp.Nama.equalsIgnoreCase(Nama)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void bayar(String nomorPendaftaran, String tanggal, int jumlah, String metode) {
        Node temp = head;
        while (temp != null && !temp.nomorPendaftaran.equals(nomorPendaftaran)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Nomor pendaftaran tidak ditemukan.");
        } else {
            temp.riwayatPembayaran.push(tanggal, jumlah, metode);
            if (temp.riwayatPembayaran.totalPembayaran() >= 56000000) {
                temp.StatusPembayaran = true;
            }
            System.out.println("Pembayaran berhasil dilakukan.");
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
    
    public void display() {
        Node temp = head;

        System.out.println("=====================================================");
        System.out.println("                DETAIL DATA JEMAAH                   ");
        System.out.println("=====================================================");
        while (temp != null) {
            System.out.println("Nomor Pendaftaran   : " + temp.nomorPendaftaran);
            System.out.println("Nama Jemaah         : " + temp.Nama);
            System.out.println("Jenis Kelamin       : " + temp.JenisKelamin);
            System.out.println("Umur                : " + temp.Umur);
            System.out.println("Tanggal Pendaftaran : " + temp.TanggalPendaftaran);
            System.out.println("Status Pembayaran   : " + (temp.StatusPembayaran ? "Lunas" : "Belum Lunas"));
            System.out.println("Penyakit            : " + temp.Penyakit );
            System.out.println("-----------------------------------------------------");
            temp.displayTree();
            System.out.println("-----------------------------------------------------");
            temp = temp.next;
        }
    }
    public void showPaymentHistory(){
        Node temp = head;
        System.out.println("=====================================================");
        System.out.println("                RIWAYAT PEMBAYARAN                   ");
        System.out.println("=====================================================");
        while (temp != null) {
            System.out.println("Nomor Pendaftaran: " + temp.nomorPendaftaran);
            System.out.println("Nama Jemaah: " + temp.Nama);
            System.out.println("-----------------------------------------------------");
            temp.riwayatPembayaran.tampilkanRiwayat();
            System.out.println("Status Pembayaran: " + (temp.StatusPembayaran ? "Lunas" : "Belum Lunas"));
            System.out.println
            ("-----------------------------------------------------");
            temp = temp.next;
        }
    }
}