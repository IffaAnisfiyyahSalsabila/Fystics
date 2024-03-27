import java.util.Scanner;

class Karyawan {
    protected String nama;
    protected int jamKerja;
    protected double gaji;
    protected double bonus;

    public Karyawan(String nama, int jamKerja) {
        this.nama = nama;
        this.jamKerja = jamKerja;
    }

    public void hitungGaji() {
        if (jamKerja >= 1 && jamKerja <= 8) {
            gaji = 500000;
            bonus = 100000;
        } else if (jamKerja >= 9 && jamKerja <= 16) {
            gaji = 1500000;
            bonus = 300000;
        } else if (jamKerja >= 17 && jamKerja <= 24) {
            gaji = 3000000;
            bonus = 500000;
        } else {
            System.out.println("Jam kerja tidak valid.");
            return;
        }
    }

    public void tampilkanGaji() {
        double totalGaji = gaji + bonus;
        System.out.println("\n===== Hasil Perhitungan Gaji =====");
        System.out.println("Nama Karyawan: " + nama);
        System.out.println("Jam Kerja: " + jamKerja + " jam");
        System.out.println("Gaji: Rp " + gaji);
        System.out.println("Bonus: Rp " + bonus);
        System.out.println("Total Gaji: Rp " + totalGaji);
    }
}

class KaryawanMagang extends Karyawan {
    public KaryawanMagang(String nama, int jamKerja) {
        super(nama, jamKerja);
        hitungGaji();
    }
}

class KaryawanBaru extends Karyawan {
    public KaryawanBaru(String nama, int jamKerja) {
        super(nama, jamKerja);
        hitungGaji();
    }
}

class KaryawanTetap extends Karyawan {
    public KaryawanTetap(String nama, int jamKerja) {
        super(nama, jamKerja);
        hitungGaji();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama karyawan: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jam kerja: ");
        int jamKerja = input.nextInt();

        Karyawan karyawan;
        if (jamKerja >= 1 && jamKerja <= 8) {
            karyawan = new KaryawanMagang(nama, jamKerja);
        } else if (jamKerja >= 9 && jamKerja <= 16) {
            karyawan = new KaryawanBaru(nama, jamKerja);
        } else if (jamKerja >= 17 && jamKerja <= 24) {
            karyawan = new KaryawanTetap(nama, jamKerja);
        } else {
            System.out.println("Jam kerja tidak valid.");
            return;
        }

        karyawan.tampilkanGaji();
    }
}
