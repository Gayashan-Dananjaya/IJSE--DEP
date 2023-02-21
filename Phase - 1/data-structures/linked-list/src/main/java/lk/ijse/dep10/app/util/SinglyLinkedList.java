package lk.ijse.dep10.app.util;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(String value) {
        if (head == null) {
            head = new Node(Integer.parseInt(value), null);
            tail = head;
        } else {
            Node temp = new Node(Integer.parseInt(value), null);
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = head;
        size = 0;
    }

    public String get(int index) {
        Node temp = head;
        if (index < 0) return "Invalid Index";
        for (int i = 0; i < index; i++) {
            if (temp == null) return "Invalid Index";
            temp = temp.next;
        }
        return Integer.toString(temp.data);
    }

    public boolean contains(String input) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == Integer.parseInt(input)) {
                return true;
            }
        }
        return false;
    }

    public void remove(int index) {
        if (index == 0 && size == 1) {
            head = null;
            tail = head;
            size--;
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        if (index == size - 1) {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    @Override
    public String toString() {
//        return super.toString();
        String data = "[";
        Node temp = head;
        while (temp != null) {
            data += Integer.toString(temp.data) + ", ";
            temp = temp.next;
        }

        data += "\b\b]";
        return data;
    }

    public void set(int index, int value) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = value;
    }

//    public int indexOf(int value) {
//
//    }
}

class Node {
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = this;
    }
}
