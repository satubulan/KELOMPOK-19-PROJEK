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
        return null; // Jika tidak ditemukan, mengembalikan null
    }

    // Ini dipake buat update data jemaah, semisal ada kesalahan input atau penggantian jemaah manual oleh ahli waris
    public static void updateData(LinkedList list, String nomorPendaftaran) {
        Scanner scanner = new Scanner(System.in); 

        Searching data = new Searching();
        Node temp = data.cariJemaah(list, nomorPendaftaran);

        if (temp == null) return;

        System.out.println("Ingin melakukan update data apa?");
        System.out.println("1. Nama jemaah");
        System.out.println("2. Status pembayaran");
        System.out.println("3. Jenis kelamin");
        System.out.println("4. Umur");
        System.out.println("5. Tanggal pembayaran");
        System.out.println("6. Ahli waris");

        int pilihan = scanner.nextInt();
        scanner.nextLine();  
        if (pilihan == 0) return;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan nama baru: ");
                temp.Nama = scanner.nextLine();
                System.out.println("Nama berhasil diubah.");
                break;

            case 2:
                System.out.print("Masukkan status pembayaran baru (true/lunas, false/belum): ");
                temp.StatusPembayaran = scanner.nextBoolean();
                System.out.println("Status pembayaran berhasil diubah.");
                break;

            case 3:
                System.out.print("Masukkan jenis kelamin baru: ");
                temp.JenisKelamin = scanner.nextLine();
                System.out.println("Jenis kelamin berhasil diubah.");
                break;

            case 4:
                System.out.print("Masukkan umur baru: ");
                temp.Umur = scanner.nextInt();
                System.out.println("Umur berhasil diubah.");
                break;

            case 5:
                System.out.print("Masukkan tanggal pembayaran baru (yyyy-MM-dd): ");
                temp.TanggalPendaftaran = scanner.nextLine();
                System.out.println("Tanggal pembayaran berhasil diubah.");
                break;

            case 6:
                System.out.print("Anda ingin mengganti ahli waris yang mana? ");
                System.out.println("1. Ahli waris pertama");
                System.out.println("2. Ahli waris kedua");

                int pilihanAhliWaris = scanner.nextInt();
                scanner.nextLine();  

                if (pilihanAhliWaris == 1) {
                    System.out.print("Masukkan nama ahli waris pertama yang baru: ");
                    temp.ahliWaris1 = scanner.nextLine(); 
                    System.out.println("Ahli waris pertama berhasil diubah.");
                } else if (pilihanAhliWaris == 2) {
                    System.out.print("Masukkan nama ahli waris kedua yang baru: ");
                    temp.ahliWaris2 = scanner.nextLine();  
                    System.out.println("Ahli waris kedua berhasil diubah.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}
