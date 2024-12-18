// Source code is decompiled from a .class file using FernFlower decompiler.
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      LinkedList link = new LinkedList();
      Stack riwayatPembayaran = new Stack();
      Queue antreanKeberangkatan = new Queue();
      TreeNode familyTree = new TreeNode("Keluarga", "Root");
      TreeNode treeNodeIbrahim = new TreeNode("Ibrahim", "Calon Haji Utama");
      treeNodeIbrahim.addChild("Yanti", "Pasangan");
      treeNodeIbrahim.addChild("Yanto", "Anak");
      link.addData("A2897", "2018-09-11", true, "Ibrahim", "Laki-laki", 89, treeNodeIbrahim);
      TreeNode treeNodeFatimah = new TreeNode("Fatimah", "Calon Haji Utama");
      treeNodeFatimah.addChild("Yanta", "Pasangan");
      treeNodeFatimah.addChild("Yante", "Anak");
      link.addData("B3456", "2021-08-12", false, "Fatimah", "Perempuan", 75, treeNodeFatimah);
      TreeNode treeNodeAhmad = new TreeNode("Ahmad", "Calon Haji Utama");
      treeNodeAhmad.addChild("Fatimah", "Pasangan");
      treeNodeAhmad.addChild("Ali", "Anak");
      treeNodeAhmad.addChild("Hassan", "Cucu");
      link.addData("C8909", "2016-07-10", true, "Ahmad", "Laki-laki", 35, treeNodeAhmad);

      while(true) {
         label74:
         while(true) {
            System.out.println("\nMenu:");
            System.out.println("0. Keluar");
            System.out.println("1. Tambah Jemaah");
            System.out.println("2. Update Data Jemaah");
            System.out.println("3. Hapus Jemaah");
            System.out.println("4. Tampilkan Calon Jemaah");
            System.out.println("5. Tambah Transaksi Pembayaran");
            System.out.println("6. Batalkan Transaksi Pembayaran");
            System.out.println("7. Tampilkan Riwayat Pembayaran");
            System.out.println("8. Tambah Ke Antrean Keberangkatan");
            System.out.println("9. Proses Keberangkatan Jemaah");
            System.out.println("10. Tampilkan Antrean");
            System.out.println("11. Tambah Ahli Waris");
            System.out.println("12. Tampilkan Tree Ahli Waris");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            if (pilihan == 0) {
               scanner.close();
               return;
            }

            String tambahAhliWaris;
            String name;
            String parentName;
            TreeNode parentTreeNode;
            switch (pilihan) {
               case 1:
                  System.out.print("Nama Jemaah: ");
                  String nama = scanner.nextLine();
                  System.out.print("Nomor Pendaftaran: ");
                  String nomor = scanner.nextLine();
                  String tanggal = LocalDate.now().toString();
                  System.out.print("Status Pembayaran (true/lunas, false/belum): ");
                  boolean status = scanner.nextBoolean();
                  scanner.nextLine();
                  System.out.print("Jenis kelamin: ");
                  String jenis = scanner.nextLine();
                  System.out.print("Umur: ");
                  int umur = scanner.nextInt();
                  scanner.nextLine();
                  TreeNode jemaahNode = new TreeNode(nama, "Calon Haji Utama");
                  jemaahNode.addChild("", "Jemaah Utama");

                  while(true) {
                     System.out.print("Tambahkan ahli waris? (y/n): ");
                     tambahAhliWaris = scanner.nextLine();
                     if (tambahAhliWaris.equalsIgnoreCase("n")) {
                        link.addData(nomor, tanggal, status, nama, jenis, umur, jemaahNode);
                        System.out.println("Data jemaah berhasil ditambahkan.");
                        continue label74;
                     }

                     System.out.print("Nama Ahli Waris: ");
                     name = scanner.nextLine();
                     System.out.print("Hubungan dengan Jemaah (misal: Pasangan, Anak, Cucu): ");
                     String relationship = scanner.nextLine();
                     jemaahNode.addChild(name, relationship);
                     System.out.println("Ahli waris berhasil ditambahkan.");
                  }
               case 2:
                  System.out.print("Masukkan nomor pendaftaran jemaah yang ingin di-update datanya: ");
                  tambahAhliWaris = scanner.nextLine();
                  Searching.updateData(link, tambahAhliWaris);
                  break;
               case 3:
                  System.out.print("Masukkan nomor pendaftaran jemaah yang ingin dihapus: ");
                  name = scanner.nextLine();
                  link.hapusJemaah(name);
                  break;
               case 4:
                  System.out.println("Filter: ");
                  System.out.println("1. Urutkan berdasarkan tanggal pendaftaran");
                  System.out.println("2. Urutkan berdasarkan nama");
                  System.out.println("3. Urutkan berdasarkan nomor pendaftaran");
                  System.out.print("Pilih menu: ");
                  int pilihanFilter = scanner.nextInt();
                  scanner.nextLine();
                  if (pilihanFilter == 1) {
                     Sorting.sortByTanggal(link);
                  } else if (pilihanFilter == 2) {
                     Sorting.sortByNama(link);
                  } else if (pilihanFilter == 3) {
                     Sorting.sortByNoPendaftaran(link);
                  } else {
                     System.out.println("Input tidak valid.");
                  }
                  break;
               case 5:
                    System.out.println("==============================================");
                    System.out.println("          TANGGAL DAN JUMLAH PEMBAYARAN      ");
                    System.out.println("==============================================");  
                    System.out.print("Tanggal Pembayaran (format: yyyy-mm-dd): ");
                    String tanggal2 = scanner.nextLine();
                    System.out.println("----------------------------------------------");
                    System.out.print("Jumlah Pembayaran: ");
                    int Jumlah = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Metode Pembayaran (cash/transfer): ");
                    String Metode = scanner.nextLine();
                    riwayatPembayaran.push(tanggal2, Jumlah, Metode);
               break;
               case 6:
                  riwayatPembayaran.pop();
                  break;
               case 7:
                  riwayatPembayaran.tampilkanRiwayat();
                  break;
               case 8:
                  System.out.print("Nama Jemaah yang akan dimasukkan antrean: ");
                  String antreanNama = scanner.nextLine();
                  antreanKeberangkatan.enqueue(antreanNama);
                  break;
               case 9:
                  antreanKeberangkatan.dequeue();
                  break;
               case 10:
                  antreanKeberangkatan.tampilkanAntrean();
                  break;
               case 11:
                  System.out.print("Masukkan nomor pendaftaran jemaah: ");
                  String nomorCari = scanner.nextLine();

                  Node targetNode;
                  for(targetNode = link.head; targetNode != null && !targetNode.nomorPendaftaran.equals(nomorCari); targetNode = targetNode.next) {
                  }

                  if (targetNode == null) {
                     System.out.println("Jemaah tidak ditemukan.");
                  } else {
                     System.out.print("Nama ahli waris (parent): ");
                     parentName = scanner.nextLine();
                     System.out.print("Nama ahli waris baru: ");
                     String childName = scanner.nextLine();
                     parentTreeNode = familyTree.findFamilyRoot(parentName);
                     if (parentTreeNode == null) {
                        System.out.println("Orang tua tidak ditemukan.");
                     } else {
                        parentTreeNode.addChild(childName, "ahli waris");
                        System.out.println("Ahli waris berhasil ditambahkan.");
                     }
                  }
                  break;
               case 12:
                  System.out.print("Masukkan nama jemaah: ");
                  parentName = scanner.nextLine();
                  Node foundNode = link.findByName(parentName);
                  if (foundNode == null) {
                     System.out.println("Jemaah tidak ditemukan.");
                  } else {
                     parentTreeNode = familyTree.findFamilyRoot(foundNode.Nama);
                     if (parentTreeNode == null) {
                        System.out.println("Pohon ahli waris tidak ditemukan.");
                     } else {
                        System.out.println("Tree Ahli Waris untuk " + parentTreeNode.name + ":");
                        parentTreeNode.displayTree(1);
                     }
                  }
                  break;
               default:
                  System.out.println("Pilihan tidak valid.");
            }
         }
      }
   }
}
