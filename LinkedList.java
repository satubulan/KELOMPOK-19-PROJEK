public class LinkedList {
    Node head;
    public void addData(String nomorPendaftaran, String TanggalPendaftaran, boolean StatusPembayaran, 
    String Nama, String JenisKelamin, int Umur, TreeNode child) {
        
        Node newNode = new Node(nomorPendaftaran, TanggalPendaftaran, StatusPembayaran, 
        Nama, JenisKelamin, Umur, child);
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
            System.out.println("Nama Jemaah: " + temp.Nama);
            System.out.println("Jenis Kelamin: " + temp.JenisKelamin);
            System.out.println("Tanggal Pendaftaran: " + temp.TanggalPendaftaran);
            System.out.println("Status Pembayaran: " + temp.StatusPembayaran);
            System.out.println("Ahli Waris:");
            if (temp.child != null) {
                temp.child.displayTree(0); // Memanggil displayTree dari TreeNode
            } else {
                System.out.println("Tidak ada ahli waris.");
            }
            
            temp = temp.next;
        
        }
    } 
    public Node findByName(String var1) {
        for(Node var2 = this.head; var2 != null; var2 = var2.next) {
           if (var2.Nama.equalsIgnoreCase(var1)) {
              return var2;
           }
        }
  
        return null;
     }
}
