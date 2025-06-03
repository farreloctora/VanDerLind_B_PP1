package tubes.services;

import java.io.*;
import tubes.entity.Pelanggan;

public class StrukturQueue {
    private Node front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Pelanggan data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        System.out.println("Pelanggan berhasil ditambahkan ke antrean.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong, tidak ada yang bisa diproses.");
        } else {
            System.out.println("Memproses: " + front.getData().toString());
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
        }
    }
}
