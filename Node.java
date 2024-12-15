public class Node {
    String nomorPendaftaran;
    String TanggalPendaftaran;
    boolean StatusPembayaran;
    String Nama;
    String JenisKelamin;
    int Umur; 
    Node next;
    TreeNode ahliWarisRoot;

    public Node(String nomorPendaftaran, String TanggalPendaftaran, boolean StatusPembayaran, String Nama, String JenisKelamin, int Umur, String ahliWarisPertama, String ahliWarisKedua){
        this.nomorPendaftaran = nomorPendaftaran;
        this.TanggalPendaftaran = TanggalPendaftaran;
        this.StatusPembayaran = StatusPembayaran;
        this.Nama = Nama;
        this.JenisKelamin = JenisKelamin;
        this.Umur = Umur; 
        this.next = null;

        this.ahliWarisRoot = new TreeNode(ahliWarisPertama);
        if (ahliWarisKedua != null && !ahliWarisKedua.isEmpty()) {
            this.ahliWarisRoot.addChild(new TreeNode(ahliWarisKedua));
        }
        
        this.next = null;
    } 
    public void displayTree() {
        if (ahliWarisRoot == null) {
            System.out.println("  Tidak ada ahli waris.");
        } else {
            ahliWarisRoot.displayTree(0);
        }
    }
}