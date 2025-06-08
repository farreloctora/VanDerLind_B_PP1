
package tubes;

import java.util.Scanner;
import tubes.entity.Pelanggan;
import tubes.services.StrukturQueue;
import tubes.util.FileUtil;

public class QueueMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StrukturQueue antrean = new StrukturQueue();
        FileUtil.loadFromFile(antrean);

        int pilihan;

        do {
            System.out.println("\n=== Sistem Antrean Pengambilan Barang ===");
            System.out.println("1. Tambah Pelanggan ke Antrean");
            System.out.println("2. Lihat Antrean");
            System.out.println("3. Proses Pelanggan");
            System.out.println("4. Cancel Antrean berdasarkan ID");
            System.out.println("5. Lihat Panjang Antrean");
            System.out.println("6. Reset Antrean");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            String inputPilihan = input.nextLine();
            if (inputPilihan.matches("\\d+")) {
                pilihan = Integer.parseInt(inputPilihan);
            } else {
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = input.nextLine();
              
                    if (nama.trim().isEmpty()) {
                        System.out.println("\nNama tidak boleh kosong!");
                        break;
                    }
                  
                    if (nama.trim().matches("\\d+")) {
                        System.out.println("\nNama tidak boleh berupa angka!");
                        break;
                    }
                    Pelanggan baru = new Pelanggan(nama);
                    antrean.enqueue(baru);
                    System.out.println("\nAntrean Berhasil ditambahkan"); 
                    break;
                case 2:
                    antrean.display();
                    break;
                case 3:
                    Pelanggan diproses = antrean.dequeue();
                    if (diproses == null) {
                        System.out.println("\nAntrean kosong, tidak ada yang bisa diproses.");
                    } else {
                        System.out.println("\nMemproses: " + diproses.toString());
                    }
                    break;
                case 4:
                    System.out.print("Masukkan ID antrean yang ingin dibatalkan: ");
                    String inputId = input.nextLine();
                    if (inputId.matches("\\d+")) {
                        int id = Integer.parseInt(inputId);
                        boolean result = antrean.cancelById(id);
                        if (result) {
                            System.out.println("\nAntrean dengan ID " + id + " berhasil dibatalkan.");
                        } else {
                            System.out.println("\nID tidak ditemukan dalam antrean.");
                        }
                    } else {
                        System.out.println("\nInput ID tidak valid!");
                    }
                    break;
                case 5:
                    System.out.println("\nPanjang antrean saat ini: " + antrean.size()); 
                    break;
                case 6:
                    antrean.resetQueue();
                    break;
                case 7:
                    System.out.println("\nKeluar dari program..."); 
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!"); 
            }

        } while (pilihan != 7);

        input.close();
    }
} 
