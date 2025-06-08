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

    //Not yet committed update
    public Pelanggan dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Pelanggan data = front.getData();
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
            FileUtil.saveToFile(this);
            return data;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("\nAntrean kosong.");
        } else {
            System.out.println("\n=== Daftar Pelanggan dalam Antrean ===");
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

    public boolean cancelById(int id) {
        if (isEmpty()) {
            return false; 
        }
        if (front.getData().getIdAntrean() == id) { 
            dequeue(); 
            return true; 
        }
        Node prev = front;
        Node curr = front.getNext();
        while (curr != null) {
            if (curr.getData().getIdAntrean() == id) { 
                prev.setNext(curr.getNext()); 
                if (curr == rear) {
                    rear = prev; 
                }
                FileUtil.saveToFile(this); 
                return true; 
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false; 
    }
    
    public void resetQueue() {
        front = null;
        rear = null;
        Pelanggan.resetCounter();
        System.out.println("\nAntrean telah direset."); 
        FileUtil.saveToFile(this);
    }
} 
