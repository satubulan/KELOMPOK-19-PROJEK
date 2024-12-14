import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList link = new LinkedList();
        Stack riwayatPembayaran = new Stack();
        Queue antreanKeberangkatan = new Queue();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Jemaah");
            System.out.println("2. Hapus Jemaah");
            System.out.println("3. Tampilkan Calon Jemaah");
            System.out.println("4. Tambah Transaksi Pembayaran");
            System.out.println("5. Batalkan Transaksi Pembayaran");
            System.out.println("6. Tampilkan Riwayat Pembayaran");
            System.out.println("7. Tambah Ke Antrean Keberangkatan");
            System.out.println("8. Proses Keberangkatan Jemaah");
            System.out.println("9. Tampilkan Antrean");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            if (pilihan == 0) break;

            switch (pilihan) {
                case 1:
                    System.out.print("Nama Jemaah: ");
                    String nama = scanner.nextLine();
                    System.out.print("Nomor Pendaftaran: ");
                    String nomor = scanner.nextLine();
                    System.out.print("Tanggal Pendaftaran (format: yyyy-mm-dd): ");
                    String tanggal = scanner.nextLine();
                    System.out.print("Status Pembayaran (true/lunas, false/belum): ");
                    boolean status = scanner.nextBoolean();
                    System.out.print("jenis kelamin: ");
                    String jenis = scanner.nextLine();
                    System.out.print("Umur ");
                    int umur = scanner.nextInt();
                    link.addData(nomor, tanggal, status, nama, jenis, umur);
                    break;

                case 2:
                    System.out.print("Masukkan nomor pendaftaran jemaah yang ingin dihapus: ");
                    String hapusPendaftaran = scanner.nextLine();
                    link.hapusJemaah(hapusPendaftaran);
                    break;

                case 3:
                    System.out.println("Data Calon Jemaah:");
                    link.addData("A2897", "2018-09-11", true, "ibrahim", "Laki-laki", 89);
                    link.addData("B3456", "2021-08-12", false, "Fatimah", "Perempuan", 75);
                    link.addData("C8909", "2016-07-10", true, "Ahmad", "Laki-laki", 35);
                    link.display();
                    break;

                case 4:
                    System.out.print("Tanggal Pembayaran (format: yyyy-mm-dd): ");
                    String tanggal2 = scanner.nextLine();
                    System.out.print("Jumlah Pembayaran: ");
                    double jumlah = scanner.nextDouble();
                    riwayatPembayaran.push(tanggal2, jumlah);
                    break;

                case 5:
                    riwayatPembayaran.pop();
                    break;

                case 6:
                    riwayatPembayaran.tampilkanRiwayat();
                    break;

                case 7:
                    System.out.print("Nama Jemaah yang akan dimasukkan antrean: ");
                    String antreanNama = scanner.nextLine();
                    antreanKeberangkatan.enqueue(antreanNama);
                    break;

                case 8:
                    antreanKeberangkatan.dequeue();
                    break;

                case 9:
                    antreanKeberangkatan.tampilkanAntrean();
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
   
