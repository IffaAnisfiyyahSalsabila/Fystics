import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Displayable {
    static void displayInfoStatic(String nama, double harga) {
        System.out.println("Kacamata Dewasa: " + nama + " (Rp" + harga + ")");
    }

    static void displayDetailStatic(String nama, double harga) {
        System.out.println("Detail Kacamata Dewasa:");
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
    }
}

public final class App {
    private static final ArrayList<Kacamata> stockKacamata = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int jumlahStokKacamata = 0; 

    public static int getJumlahStokKacamata() {
        return jumlahStokKacamata;
    }

    private static void tambahJumlahStokKacamata(int jumlah) {
        jumlahStokKacamata += jumlah;
    }

    private static void kurangiJumlahStokKacamata(int jumlah) {
        jumlahStokKacamata -= jumlah;
    }

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        boolean appIsRunning = true;

        while (appIsRunning) {
            System.out.println("=== FYStics Optik ===");
            System.out.println("1. Tambah Stok Kacamata");
            System.out.println("2. Tampilkan Semua Stok Kacamata");
            System.out.println("3. Perbarui Stok Kacamata");
            System.out.println("4. Hapus Stok Kacamata");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int menuChoice = scanner.nextInt();
                scanner.nextLine();

                switch (menuChoice) {
                    case 1:
                        tambahStokKacamata();
                        break;
                    case 2:
                        tampilkanSemuaStokKacamata();
                        break;
                    case 3:
                        perbaruiStokKacamata();
                        break;
                    case 4:
                        hapusStokKacamata();
                        break;
                    case 5:
                        appIsRunning = false;
                        break;
                    default:
                        System.out.println("Menu tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukan tidak valid. Mohon masukkan angka.");
                scanner.nextLine(); 
            }
        }

        scanner.close();
    }

    private static void tambahStokKacamata() {
        System.out.println("\nTambah Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata: ");
        String namaKacamata = scanner.nextLine();
        System.out.print("Masukkan harga kacamata: ");

        try {
            double hargaKacamata = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Masukkan jumlah kacamata: ");
            int jumlahKacamata = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < jumlahKacamata; i++) {
                Kacamata kacamata = new KacamataDewasa(namaKacamata, hargaKacamata);
                stockKacamata.add(kacamata);
                tambahJumlahStokKacamata(1);
            }

            System.out.println("Stok kacamata (" + jumlahKacamata + " buah) berhasil ditambahkan.");
        } catch (InputMismatchException e) {
            System.out.println("Input harga kacamata tidak valid. Mohon masukkan angka.");
            scanner.nextLine();
        }
    }

    private static void tampilkanSemuaStokKacamata() {
        System.out.println("\nSemua Data Stok Kacamata di FYStics Optik:");
        if (stockKacamata.isEmpty()) {
            System.out.println("Stok kacamata kosong.");
        } else {
            for (int i = 0; i < stockKacamata.size(); i++) {
                Kacamata kacamata = stockKacamata.get(i);
                Displayable.displayInfoStatic(kacamata.getNamaKacamata(), kacamata.getHargaKacamata());
                System.out.println(); 
            }
        }
    }

    private static void perbaruiStokKacamata() {
        System.out.println("\nPerbarui Data Stok Kacamata");
        System.out.print("Masukkan nomor urutan kacamata yang akan diperbarui: ");

        try {
            int nomorUrutan = scanner.nextInt();
            scanner.nextLine();

            if (nomorUrutan > 0 && nomorUrutan <= stockKacamata.size()) {
                System.out.print("Masukkan nama kacamata baru: ");
                String newNamaKacamata = scanner.nextLine();
                System.out.print("Masukkan harga kacamata baru: ");
                double newHargaKacamata = scanner.nextDouble();
                scanner.nextLine();

                Kacamata kacamata = stockKacamata.get(nomorUrutan - 1);
                kacamata.setNamaKacamata(newNamaKacamata);
                kacamata.setHargaKacamata(newHargaKacamata);

                System.out.println("Data stok kacamata berhasil diperbarui.");
            } else {
                System.out.println("Nomor urutan kacamata tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Mohon masukkan angka.");
            scanner.nextLine(); 
        }
    }

    private static void hapusStokKacamata() {
        System.out.println("\nHapus Data Stok Kacamata");
        tampilkanSemuaStokKacamata();
        System.out.print("Masukkan nomor urutan kacamata yang akan dihapus: ");

        try {
            int nomorUrutan = scanner.nextInt();
            scanner.nextLine();

            if (nomorUrutan > 0 && nomorUrutan <= stockKacamata.size()) {
                Kacamata kacamata = stockKacamata.remove(nomorUrutan - 1);
                kurangiJumlahStokKacamata(1);
                System.out.println("Data stok kacamata berhasil dihapus:");
                Displayable.displayInfoStatic(kacamata.getNamaKacamata(), kacamata.getHargaKacamata());
            } else {
                System.out.println("Nomor urutan kacamata tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Mohon masukkan angka.");
            scanner.nextLine(); 
        }
    }


    public static abstract class Kacamata {
        private String namaKacamata;
        private double hargaKacamata;

        public Kacamata(String namaKacamata, double hargaKacamata) {
            this.namaKacamata = namaKacamata;
            this.hargaKacamata = hargaKacamata;
        }

        public String getNamaKacamata() {
            return namaKacamata;
        }

        public void setNamaKacamata(String namaKacamata) {
            this.namaKacamata = namaKacamata;
        }

        public double getHargaKacamata() {
            return hargaKacamata;
        }

        public void setHargaKacamata(double hargaKacamata) {
            this.hargaKacamata = hargaKacamata;
        }
    }

    public static class KacamataDewasa extends Kacamata {
        public KacamataDewasa(String namaKacamata, double hargaKacamata) {
            super(namaKacamata, hargaKacamata);
        }
    }
}
