import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList link = new LinkedList();
        Stack riwayatPembayaran = new Stack();
        Queue antreanKeberangkatan = new Queue();

        link.addData("A2897", "2018-09-11", true, "ibrahim", "Laki-laki", 89, "Yanti", "Yanto", "Jantung");
        link.addData("B3456", "2021-08-12", false, "Fatimah", "Perempuan", 75, "Yanta", "Yante", "Asma");
        link.addData("C8909", "2016-07-10", true, "Ahmad", "Laki-laki", 35, "Yonge", "Yayat", "-");
        
        System.out.println("  .-'''-.    ____     ________    ____     ________   .---.       ,-----.    .--.      .--. ");
        System.out.println(" / _     \\ .'  __ `. |        | .'  __ `. |        |  | ,_|     .'  .-,  '.  |  |_     |  | ");
        System.out.println("(`' )/`--'/   '  \\  \\|   .----'/   '  \\  \\|   .----',-./  )    / ,-.|  \\ _ \\ | _( )_   |  | ");
        System.out.println("(_ o _).   |___|  /  ||  _|____ |___|  /  ||  _|____ \\  '_ '`) ;  \\  '_ /  | :|(_ o _)  |  | ");
        System.out.println(" (_,_). '.    _.-`   ||_( )_   |   _.-`   ||_( )_   | > (_)  ) |  _`,/ \\ _/  || (_,_) \\ |  | ");
        System.out.println(".---.  \\  :.'   _    |(_ o._)__|.'   _    |(_ o._)__|(  .  .-' : (  '\\_/ \\   ;|  |/    \\|  | ");
        System.out.println("\\    `-'  ||  _( )_  ||(_,_)    |  _( )_  ||(_,_)     `-'`-'|___\\ `\"/  \\ ) / |  '  /\\  `  | ");
        System.out.println(" \\       / \\ (_ o _) /|   |     \\ (_ o _) /|   |       |        \'. \\_/``\".'  |    /  \\    | ");
        System.out.println("  `-...-'   '.(_,_).' '---'      '.(_,_).' '---'       `--------`  '-----'    `---'    `---` ");
    
        while (true) {
            System.out.println("==========================================");
            System.out.println("          MENU PELAYANAN JEMAAH          ");
            System.out.println("==========================================");
            System.out.println("| No |             Menu                 |");
            System.out.println("==========================================");
            System.out.println("| 1  | Tambah Jemaah                    |");
            System.out.println("==========================================");
            System.out.println("| 2  | Update Data Jemaah               |");
            System.out.println("==========================================");
            System.out.println("| 3  | Hapus Jemaah                     |");
            System.out.println("==========================================");
            System.out.println("| 4  | Tampilkan Calon Jemaah           |");
            System.out.println("==========================================");
            System.out.println("| 5  | Tambah Transaksi Pembayaran      |");
            System.out.println("==========================================");
            System.out.println("| 6  | Batalkan Transaksi Pembayaran    |");
            System.out.println("==========================================");
            System.out.println("| 7  | Tampilkan Riwayat Pembayaran     |");
            System.out.println("==========================================");
            System.out.println("| 8  | Tambah Ke Antrean Keberangkatan  |");
            System.out.println("==========================================");
            System.out.println("| 9  | Proses Keberangkatan Jemaah      |");
            System.out.println("==========================================");
            System.out.println("| 10 | Tampilkan Antrean                |");
            System.out.println("==========================================");
            System.out.println();
            System.out.print("Pilih menu (0-10): ");
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
                    System.out.println("Penyakit: ");
                    String penyakit = scanner.nextLine();
                    System.out.print("Nama Ahli Waris 1: ");
                    String ahliWarisPertama = scanner.nextLine();
                    System.out.print("Nama Ahli Waris 2: ");
                    String ahliWarisKedua = scanner.nextLine();
                    link.addData(nomor, tanggal, status, nama, jenis, umur, ahliWarisPertama, ahliWarisKedua, penyakit);
                    System.out.println("Data jemaah berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("=====================================================");
                    System.out.println("   UPDATE DATA JEMAAH BERDASARKAN NOMOR PENDAFTARAN   ");
                    System.out.println("=====================================================");
                    System.out.print("Masukkan nomor pendaftaran jemaah yang ingin di-update datanya: ");
                    String update = scanner.nextLine();
                    Searching.updateData(link, update);
                    break;

                case 3:
                    System.out.println("=====================================================");
                    System.out.println("   HAPUS DATA JEMAAH BERDASARKAN NOMOR PENDAFTARAN   ");
                    System.out.println("=====================================================");
                    System.out.print("Masukkan nomor pendaftaran jemaah yang ingin dihapus: ");
                    String hapusPendaftaran = scanner.nextLine();
                    link.hapusJemaah(hapusPendaftaran);
                    break;

                case 4:
                    System.out.println("==============================================");
                    System.out.println("              FILTER DATA JEMAAH              ");
                    System.out.println("==============================================");
                    System.out.println("1. Urutkan berdasarkan tanggal pendaftaran");
                    System.out.println("2. Urutkan berdasarkan nama");
                    System.out.println("3. Urutkan berdasarkan nomor pendaftaran");
                    System.out.println("==============================================");
                    System.out.print("Pilih menu (1-3): ");
                
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
                    System.out.println("==============================================");
                    System.out.println("          TANGGAL DAN JUMLAH PEMBAYARAN      ");
                    System.out.println("==============================================");
                    System.out.print("Tanggal Pembayaran (format: yyyy-mm-dd): ");
                    String tanggal2 = scanner.nextLine();
                    System.out.println("----------------------------------------------");
                    System.out.print("Jumlah Pembayaran: ");
                    double jumlah = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Metode Pembayaran (cash/transfer): ");
                    String Metode = scanner.nextLine();
                    riwayatPembayaran.push(tanggal2, jumlah, Metode);
                    break;

                case 6:
                    riwayatPembayaran.pop();
                    break;

                case 7:
                    riwayatPembayaran.tampilkanRiwayat();
                    break;

                case 8:
                    System.out.println("==============================================");
                    System.out.println("      MASUKKAN NAMA JEMAAH KE ANTREAN        ");
                    System.out.println("==============================================");
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