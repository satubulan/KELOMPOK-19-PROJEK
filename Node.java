public class Node {
    String nomorPendaftaran;
    String TanggalPendaftaran;
    Boolean StatusPembayaran;
    String Nama;
    String JenisKelamin;
    int Umur;
    Node next;
    Node prev;

    public Node ( String nomor, String tanggal, Boolean status, String nama, String jenis, int umur){
        this.nomorPendaftaran = nomor;
        this.TanggalPendaftaran = tanggal;
        this.StatusPembayaran = status;
        this.Nama = nama;
        this.JenisKelamin = jenis;
        this.Umur = umur;

    }
    
}
