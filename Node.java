public class Node {
    String nomorPendaftaran;
    String TanggalPendaftaran;
    boolean StatusPembayaran;
    String Nama;
    String JenisKelamin;
    int Umur;
    Node next;                 
    String relationship;       
    TreeNode child; 
             

    public Node(String nomorPendaftaran, String TanggalPendaftaran, boolean StatusPembayaran, 
                String Nama, String JenisKelamin, int Umur, TreeNode  Child) {
        this.nomorPendaftaran = nomorPendaftaran;
        this.TanggalPendaftaran = TanggalPendaftaran;
        this.StatusPembayaran = StatusPembayaran;
        this.Nama = Nama;
        this.JenisKelamin = JenisKelamin;
        this.Umur = Umur;
        
        this.child = child;
        this.next = null;
    }
    
}
