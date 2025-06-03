package tubes.entity;

public class Pelanggan {
    private String nama;
    private static int counter = 1;
    private int idAntrean;

    public Pelanggan(String nama) {
        this.nama = nama;
        this.idAntrean = counter++;
    }

    public String getNama() {
        return nama;
    }

    public int getIdAntrean() {
        return idAntrean;
    }

    public void setIdAntrean(int idAntrean) {
        this.idAntrean = idAntrean;
    }

    public static void resetCounter() {
        counter = 1;
    }

    public static void setCounter(int value) {
        counter = value;
    }

    public String toString() {
        return "ID Antrean: " + idAntrean + ", Nama Pelanggan: " + nama;
    }
}
