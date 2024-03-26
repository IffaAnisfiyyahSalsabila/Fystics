public class Kacamata {
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

class KacamataAnak extends Kacamata {
    public KacamataAnak(String namaKacamata, double hargaKacamata) {
        super(namaKacamata, hargaKacamata);
    }
}

class KacamataDewasa extends Kacamata {
    public KacamataDewasa(String namaKacamata, double hargaKacamata) {
        super(namaKacamata, hargaKacamata);
    }
}

class KacamataFashion extends KacamataDewasa {
    public KacamataFashion(String namaKacamata, double hargaKacamata) {
        super(namaKacamata, hargaKacamata);
    }
}
