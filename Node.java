// Node.java
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
            this.ahliWarisRoot.addSibling(new TreeNode(ahliWarisKedua)); 
        }
    }

    // Menampilkan pohon ahli waris
    public void displayTree() {
        if (ahliWarisRoot == null) {
            System.out.println("  Tidak ada ahli waris.");
        } else {
            ahliWarisRoot.displayTree(0); 
        }
    }

    // Menambahkan ahli waris baru sebagai child atau sibling
    public void tambahAhliWaris(String namaBaru, boolean sebagaiAnak) {
        TreeNode ahliWarisBaru = new TreeNode(namaBaru);
        if (sebagaiAnak) {
            this.ahliWarisRoot.addChild(ahliWarisBaru); 
        } else {
            this.ahliWarisRoot.addSibling(ahliWarisBaru); 
        }
    }
}