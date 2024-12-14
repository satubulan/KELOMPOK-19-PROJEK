import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList link = new LinkedList();
        Stack riwayatPembayaran = new Stack();
        Queue antreanKeberangkatan = new Queue();

        link.addData("A2897", "2018-09-11", true, "ibrahim", "Laki-laki", 89, "Yanti", "Yanto");
        link.addData("B3456", "2021-08-12", false, "Fatimah", "Perempuan", 75, "Yanta", "Yante");
        link.addData("C8909", "2016-07-10", true, "Ahmad", "Laki-laki", 35, "Yonge", "Yayat");
        
        while (true) {
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
                    String tanggal = LocalDate.now().toString();
                    System.out.print("Status Pembayaran (true/lunas, false/belum): ");
                    boolean status = scanner.nextBoolean();
                    scanner.nextLine(); 
                    System.out.print("Jenis kelamin: ");
                    String jenis = scanner.nextLine();
                    System.out.print("Umur: ");
                    int umur = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Nama Ahli Waris 1: ");
                    String ahliWaris1 = scanner.nextLine();
                    System.out.print("Nama Ahli Waris 2: ");
                    String ahliWaris2 = scanner.nextLine();
                    link.addData(nomor, tanggal, status, nama, jenis, umur, ahliWaris1, ahliWaris2);

                case 2:
                    System.out.print("Masukkan nomor pendaftaran jemaah yang ingin di-update datanya: ");
                    String update = scanner.nextLine();
                    Searching.updateData(link, update);
                    break;

                case 3:
                    System.out.print("Masukkan nomor pendaftaran jemaah yang ingin dihapus: ");
                    String hapusPendaftaran = scanner.nextLine();
                    link.hapusJemaah(hapusPendaftaran);
                    break;

                case 4:
                    System.out.println("Filter: ");
                    System.out.println("1. Urutkan berdasarkan tanggal pendaftaran");
                    System.out.println("2. Urutkan berdasarkan nama");
                    System.out.println("3. Urutkan berdasarkan nomor pendaftaran");
                    System.out.print("Pilih menu: ");
                    int pilihanFilter = scanner.nextInt();
                    scanner.nextLine(); 
                    if (pilihanFilter == 1){
                        Sorting.sortByTanggal(link);
                    } else if (pilihanFilter == 2){
                        Sorting.sortByNama(link);
                    }else if (pilihanFilter == 3){
                        Sorting.sortByNoPendaftaran(link);
                    } else {
                        System.out.println("Input tidak valid.");
                    }
                    break;

                case 5:
                    System.out.print("Tanggal Pembayaran (format: yyyy-mm-dd): ");
                    String tanggal2 = scanner.nextLine();
                    System.out.print("Jumlah Pembayaran: ");
                    double jumlah = scanner.nextDouble();
                    riwayatPembayaran.push(tanggal2, jumlah);
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

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
