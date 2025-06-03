package tubes.services;

import tubes.entity.Pelanggan;
import tubes.util.FileUtil;

public class StrukturQueue {
    private Node front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public Node getFront() {
        return front;
    }

    public void enqueue(Pelanggan data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        FileUtil.saveToFile(this);
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
            FileUtil.saveToFile(this);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrean kosong.");
        } else {
            System.out.println("=== Daftar Pelanggan dalam Antrean ===");
            Node current = front;
            int no = 1;
            while (current != null) {
                System.out.println(no + ". " + current.getData().toString());
                current = current.getNext();
                no++;
            }
        }
    }

    public int size() {
        int count = 0;
        Node current = front;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public void resetQueue() {
        front = null;
        rear = null;
        Pelanggan.resetCounter();
        System.out.println("Antrean telah direset.");
        FileUtil.saveToFile(this);
    }
} 
