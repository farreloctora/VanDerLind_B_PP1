package tubes.util;

import java.io.*;
import tubes.entity.Pelanggan;
import tubes.services.StrukturQueue;
import tubes.services.Node;

public class FileUtil {
    private static final String FILE_NAME = "antrean_data.txt";

    public static void saveToFile(StrukturQueue queue) {
        try (FileWriter writer = new FileWriter(FILE_NAME);
             BufferedWriter bw = new BufferedWriter(writer)) {
            
            if (queue.isEmpty()) {
                bw.write("Antrian kosong");
                return;
            }

            Node current = queue.getFront();
            while (current != null) {
                Pelanggan pelanggan = current.getData();
                String data = pelanggan.getIdAntrean() + "," + pelanggan.getNama();
                bw.write(data);
                bw.newLine();
                current = current.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error saat menyimpan data: " + e.getMessage());
        }
    }

    public static void loadFromFile(StrukturQueue queue) {
        try (FileReader reader = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(reader)) {
            
            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals("Antrian kosong")) {
                    return;
                }
                String[] data = line.split(",");
                if (data.length == 2) {
                    int id = Integer.parseInt(data[0]);
                    maxId = Math.max(maxId, id);
                    String nama = data[1];
                    Pelanggan pelanggan = new Pelanggan(nama);
                    pelanggan.setIdAntrean(id);
                    queue.enqueue(pelanggan);
                }
            }
            // Set counter ke nilai setelah ID terbesar
            Pelanggan.setCounter(maxId + 1);
        } catch (IOException e) {
            // Jika file belum ada, buat file baru
            try {
                new FileWriter(FILE_NAME).close();
            } catch (IOException ex) {
                System.out.println("Error saat membuat file baru: " + ex.getMessage());
            }
        }
    }
}
