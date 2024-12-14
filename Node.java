public class Node {
    String nomorPendaftaran;
    String TanggalPendaftaran;
    boolean StatusPembayaran;
    String Nama;
    String JenisKelamin;
    int Umur;
    String ahliWaris1;  
    String ahliWaris2;  
    Node next;

    public Node(String nomorPendaftaran, String TanggalPendaftaran, boolean StatusPembayaran, 
    String Nama, String JenisKelamin, int Umur, String ahliWaris1, String ahliWaris2) {
        this.nomorPendaftaran = nomorPendaftaran;
        this.TanggalPendaftaran = TanggalPendaftaran;
        this.StatusPembayaran = StatusPembayaran;
        this.Nama = Nama;
        this.JenisKelamin = JenisKelamin;
        this.Umur = Umur;
        this.ahliWaris1 = ahliWaris1; 
        this.ahliWaris2 = ahliWaris2; 
        this.next = null;
    }
}
