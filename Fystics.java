import java.util.ArrayList;
import java.util.Scanner;

public class Fystics {
    private ArrayList<Kacamata> stockKacamata = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Kacamata> getStockKacamata() {
        return stockKacamata;
    }

    public void setStockKacamata(ArrayList<Kacamata> stockKacamata) {
        this.stockKacamata = stockKacamata;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Fystics fystics = new Fystics();
        fystics.runApp();
    }

    public void runApp() {
        boolean appIsRunning = true;
        while (appIsRunning) {
            System.out.println("=== FYStics Optik ===");
            System.out.println("1. Tambahkan Stock Kacamata");
            System.out.println("2. Tampilkan Semua Stock Kacamata");
            System.out.println("3. Perbarui Stock Kacamata");
            System.out.println("4. Hapus Kacamata");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
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
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private void tambahStokKacamata() {
        System.out.println("\nTambah Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata: ");
        String namaKacamata = scanner.nextLine();
        System.out.print("Masukkan harga kacamata: ");
        double hargaKacamata = scanner.nextDouble();
        scanner.nextLine();
        Kacamata kacamata = new Kacamata(namaKacamata, hargaKacamata);
        stockKacamata.add(kacamata);
        System.out.println("Stok kacamata berhasil ditambahkan.");
    }

    private void tampilkanSemuaStokKacamata() {
        System.out.println("\nSemua Data Stok Kacamata di FYStics Optik:");
        if (stockKacamata.isEmpty()) {
            System.out.println("Stok kacamata kosong.");
        } else {
            for (Kacamata kacamata : stockKacamata) {
                System.out.println("- " + kacamata.getNamaKacamata() + " (Rp" + kacamata.getHargaKacamata() + ")");
            }
        }
    }

    private void perbaruiStokKacamata() {
        System.out.println("\nPerbarui Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata yang akan diperbarui: ");
        String oldKacamata = scanner.nextLine();
        System.out.print("Masukkan nama kacamata baru: ");
        String newKacamata = scanner.nextLine();
        System.out.print("Masukkan harga kacamata baru: ");
        double newHarga = scanner.nextDouble();
        scanner.nextLine();
        for (Kacamata kacamata : stockKacamata) {
            if (kacamata.getNamaKacamata().equals(oldKacamata)) {
                kacamata.setNamaKacamata(newKacamata);
                kacamata.setHargaKacamata(newHarga);
                System.out.println("Data stok kacamata berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Data stok kacamata tidak ditemukan.");
    }

    private void hapusStokKacamata() {
        System.out.println("\nHapus Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata yang akan dihapus: ");
        String kacamataToRemove = scanner.nextLine();
        for (Kacamata kacamata : stockKacamata) {
            if (kacamata.getNamaKacamata().equals(kacamataToRemove)) {
                stockKacamata.remove(kacamata);
                System.out.println("Data stok kacamata berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data stok kacamata tidak ditemukan.");
    }
}

class Kacamata {
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
