import java.util.ArrayList;
import java.util.Scanner;

public class Fystics {
    private static ArrayList<String> stockKacamata = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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

    private static void tambahStokKacamata() {
        System.out.println("\nTambah Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata: ");
        String namaKacamata = scanner.nextLine();
        stockKacamata.add(namaKacamata);
        System.out.println("Stok kacamata berhasil ditambahkan.");
    }

    private static void tampilkanSemuaStokKacamata() {
        System.out.println("\nSemua Data Stok Kacamata di FYStics Optik:");
        if (stockKacamata.isEmpty()) {
            System.out.println("Stok kacamata kosong.");
        } else {
            for (String kacamata : stockKacamata) {
                System.out.println("- " + kacamata);
            }
        }
    }
    

    private static void perbaruiStokKacamata() {
        System.out.println("\nPerbarui Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata yang akan diperbarui: ");
        String oldKacamata = scanner.nextLine();
        System.out.print("Masukkan nama kacamata baru: ");
        String newKacamata = scanner.nextLine();
        if (stockKacamata.contains(oldKacamata)) {
            int index = stockKacamata.indexOf(oldKacamata);
            stockKacamata.set(index, newKacamata);
            System.out.println("Data stok kacamata berhasil diperbarui.");
        } else {
            System.out.println("Data stok kacamata tidak ditemukan.");
        }
    }

    private static void hapusStokKacamata() {
        System.out.println("\nHapus Data Stok Kacamata");
        System.out.print("Masukkan nama kacamata yang akan dihapus: ");
        String kacamataToRemove = scanner.nextLine();
        if (stockKacamata.contains(kacamataToRemove)) {
            stockKacamata.remove(kacamataToRemove);
            System.out.println("Data stok kacamata berhasil dihapus.");
        } else {
            System.out.println("Data stok kacamata tidak ditemukan.");
        }
    }
}
