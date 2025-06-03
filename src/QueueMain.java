package tubes;

import java.util.Scanner;
import tubes.entity.Pelanggan;
import tubes.services.StrukturQueue;

public class QueueMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StrukturQueue antrean = new StrukturQueue();

        int pilihan;

        do {
            System.out.println("\n=== Sistem Antrean Pengambilan Barang ===");
            System.out.println("1. Tambah Pelanggan ke Antrean");
            System.out.println("2. Lihat Antrean");
            System.out.println("3. Proses Pelanggan");
            System.out.println("4. Reset Antrean");
            System.out.println("5. Lihat Panjang Antrean");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String inputPilihan = input.nextLine();
            if (inputPilihan.matches("\d+")) {
                pilihan = Integer.parseInt(inputPilihan);
            } else {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input.nextLine();
                    Pelanggan baru = new Pelanggan(nama);
                    antrean.enqueue(baru);
                    break;
                case 2:
                    antrean.display();
                    break;
                case 3:
                    antrean.dequeue();
                    break;
                case 4:
                    antrean.resetQueue();
                    break;
                case 5:
                    System.out.println("Panjang antrean saat ini: " + antrean.size());
                    break;
                case 6:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 6);

        input.close();
    }
}
