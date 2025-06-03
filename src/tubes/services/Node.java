package tubes.services;

import tubes.entity.Pelanggan;

public class Node {
    private Pelanggan data;
    private Node next;

    public Node(Pelanggan data) {
        this.data = data;
        this.next = null;
    }

    public Pelanggan getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
