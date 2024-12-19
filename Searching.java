import java.util.Scanner;
public class Searching {
    // Mencari data jemaah berdasarkan nomor pendaftaran menggunakan linear search
    public Node cariJemaah(LinkedList linkedList, String nomorPendaftaran) {
        Node temp = linkedList.head;
        while (temp != null) {
            if (temp.nomorPendaftaran.equals(nomorPendaftaran)) {
                System.out.println("Data ditemukan:");
                System.out.println("Nomor Pendaftaran: " + temp.nomorPendaftaran);
                System.out.println("Tanggal Pembayaran: " + temp.TanggalPendaftaran);
                System.out.println("Status Pembayaran: " + temp.StatusPembayaran);
                System.out.println("Nama Pendaftar: " + temp.Nama);
                System.out.println("Jenis Kelamin: " + temp.JenisKelamin);
                System.out.println("Umur: " + temp.Umur);
                return temp;  
            }
            temp = temp.next;
        }
        System.out.println("Jemaah dengan nomor pendaftaran " + nomorPendaftaran + " tidak ditemukan.");
        System.out.println("Silahkan cek kembali data yang di-inputkan.");
        return null; 
    }

    //buat bantu nyari parent cucu
    public static TreeNode findParentByName(TreeNode node, String nama) {
        if (node == null) {
            return null;
        }
    
        if (node.namaAhliWaris.equalsIgnoreCase(nama)) {
            return node;
        }
    
        TreeNode sibling = findParentByName(node.nextSibling, nama);
        if (sibling != null) {
            return sibling;
        }
    
        return findParentByName(node.firstChild, nama);
    }
    

    // Ini dipake buat update data jemaah, semisal ada kesalahan input atau penggantian jemaah manual oleh ahli waris
    public static void updateData(LinkedList list, String nomorPendaftaran) {
        Scanner scanner = new Scanner(System.in);

        Searching data = new Searching();
        Node temp = data.cariJemaah(list, nomorPendaftaran);

        if (temp == null) return;
        System.out.println("\n===========================");
        System.out.println("      UPDATE DATA JEMAAH     ");
        System.out.println("===========================\n");

        System.out.println("Pilih data yang ingin diubah:");
        System.out.println("1. Nama Jemaah");
        System.out.println("2. Status Pembayaran");
        System.out.println("3. Jenis Kelamin");
        System.out.println("4. Umur");
        System.out.println("5. Tanggal Pembayaran");
        System.out.println("6. Ahli Waris");
        System.out.print("\nMasukkan pilihan (1-6): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  

        if (pilihan == 0) return;

        System.out.println("\n-------------------------------------");

        switch (pilihan) {
            case 1:
                System.out.println("\n=============================");
                System.out.println("      UPDATE NAMA JEMAAH     ");
                System.out.println("=============================");
                System.out.print("Masukkan nama baru: ");
                temp.Nama = scanner.nextLine();
                System.out.println("\nNama berhasil diubah.");
                break;

            case 2:
                System.out.println("\n=============================");
                System.out.println("  UPDATE STATUS PEMBAYARAN  ");
                System.out.println("=============================");
                System.out.print("Masukkan status pembayaran baru (true/lunas, false/belum): ");
                temp.StatusPembayaran = scanner.nextBoolean();
                System.out.println("\nStatus pembayaran berhasil diubah.");
                break;

            case 3:
                System.out.println("\n=============================");
                System.out.println("     UPDATE JENIS KELAMIN    ");
                System.out.println("=============================");
                System.out.print("Masukkan jenis kelamin baru: ");
                temp.JenisKelamin = scanner.nextLine();
                System.out.println("\nJenis kelamin berhasil diubah.");
                break;

            case 4:
                System.out.println("\n=============================");
                System.out.println("        UPDATE UMUR          ");
                System.out.println("=============================");
                System.out.print("Masukkan umur baru: ");
                temp.Umur = scanner.nextInt();
                System.out.println("\nUmur berhasil diubah.");
                break;

            case 5:
                System.out.println("\n=============================");
                System.out.println("  UPDATE TANGGAL PEMBAYARAN  ");
                System.out.println("=============================");
                System.out.print("Masukkan tanggal pembayaran baru (yyyy-MM-dd): ");
                scanner.nextLine(); 
                temp.TanggalPendaftaran = scanner.nextLine();
                System.out.println("\nTanggal pembayaran berhasil diubah.");
                break;

                case 6:
                    System.out.println("\n=============================");
                    System.out.println("      UPDATE AHLI WARIS     ");
                    System.out.println("=============================");
                    System.out.print("Apakah Anda ingin menambah ahli waris baru atau hanya memperbarui ahli waris yang ada? (tambah/update): ");
                    String jawaban = scanner.nextLine().trim().toLowerCase();

                    if (jawaban.equals("tambah")) {
                        if (temp.ahliWarisRoot == null) {
                            System.out.print("Masukkan nama ahli waris pertama: ");
                            String newAhliWaris = scanner.nextLine();
                            temp.ahliWarisRoot = new TreeNode(newAhliWaris); 
                            System.out.println("Ahli waris pertama berhasil ditambahkan.");
                        } else {
                            System.out.println("Daftar ahli waris saat ini:");
                            int index = 1;
                            TreeNode currentNode = temp.ahliWarisRoot;

                            while (currentNode != null) {
                                System.out.println(index + ". " + currentNode.namaAhliWaris);
                                if (currentNode.firstChild != null) {
                                    TreeNode childNode = currentNode.firstChild;
                                    int childIndex = 1;
                                    while (childNode != null) {
                                        System.out.println("|_" + childIndex + " " + childNode.namaAhliWaris);
                                        childNode = childNode.nextSibling;
                                        childIndex++;
                                    }
                                }
                                currentNode = currentNode.nextSibling;
                                index++;
                            }

                            System.out.print("\nMasukkan nama ahli waris baru: ");
                            String newAhliWaris = scanner.nextLine();
                            
                            System.out.print("Apakah ahli waris baru akan menjadi anak atau cucu? (anak/cucu): ");
                            String posisi = scanner.nextLine().trim().toLowerCase();

                            if (posisi.equals("anak")) {
                                temp.tambahAhliWaris(newAhliWaris, false);
                                System.out.println("Ahli waris baru berhasil ditambahkan sebagai anak.");
                            } else if (posisi.equals("cucu")) {
                                System.out.println("Masukkan nama parent: ");
                                String namaParent = scanner.nextLine();
                            
                                TreeNode parentNode = findParentByName(temp.ahliWarisRoot, namaParent);
                            
                                if (parentNode != null) {
                                    System.out.println("Parent ditemukan: " + parentNode.namaAhliWaris);
                                    parentNode.addChild(new TreeNode(newAhliWaris));  
                                    System.out.println("Cucu berhasil ditambahkan.");
                                } else {
                                    System.out.println("Parent dengan nama " + namaParent + " tidak ditemukan.");
                                }
                            } else {
                                System.out.println("Pilihan posisi tidak valid. Harus memilih antara 'anak' atau 'cucu'.");
                            }
                        }
                    } else if (jawaban.equals("update")) {
                        if (temp.ahliWarisRoot == null) {
                            System.out.println("Belum ada ahli waris yang terdaftar.");
                            System.out.print("Ingin menambah ahli waris? (y/n): ");
                            char addHeir = scanner.next().charAt(0);
                            scanner.nextLine(); 
                            if (addHeir == 'y' || addHeir == 'Y') {
                                System.out.print("Masukkan nama ahli waris pertama: ");
                                String newAhliWaris = scanner.nextLine();
                                temp.ahliWarisRoot = new TreeNode(newAhliWaris); 
                                System.out.println("Ahli waris pertama berhasil ditambahkan.");
                            }
                        } else {
                            System.out.println("Daftar ahli waris saat ini:");
                            int index = 1;
                            TreeNode currentNode = temp.ahliWarisRoot;
                            while (currentNode != null) {
                                System.out.println(index + ". " + currentNode.namaAhliWaris);
                                if (currentNode.firstChild != null) {
                                    TreeNode childNode = currentNode.firstChild;
                                    int childIndex = 1;
                                    while (childNode != null) {
                                        System.out.println("|_" + childIndex + " " + childNode.namaAhliWaris);
                                        childNode = childNode.nextSibling;
                                        childIndex++;
                                    }
                                }
                                currentNode = currentNode.nextSibling;
                                index++;
                            }

                            System.out.println("\nPilih ahli waris yang ingin diubah (masukkan nomor ahli waris): ");
                            int pilihHeir = scanner.nextInt();
                            scanner.nextLine(); 
                            
                            currentNode = temp.ahliWarisRoot;
                            for (int i = 1; i < pilihHeir; i++) {
                                currentNode = currentNode.nextSibling;  
                            }

                            if (currentNode != null) {
                                System.out.print("Masukkan nama ahli waris yang baru: ");
                                String newHeirName = scanner.nextLine();
                                currentNode.namaAhliWaris = newHeirName;
                                System.out.println("Ahli waris berhasil diubah.");
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                        }
                    } else {
                        System.out.println("Pilihan tidak valid. Harus memilih antara 'tambah' atau 'update'.");
                    }
                    break;


            default:
                System.out.println("\nPilihan tidak valid.");
                break;
        }

        System.out.println("\n-------------------------------------");
        System.out.println("       Pembaruan data selesai!          ");
        System.out.println("-------------------------------------\n");
    }
}