package alg2;
import java.lang.Math;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int N = 0;
    public LinkedList(T value) {
        head = new Node<T>(value);
        tail = head;
        N++;
    }
    public LinkedList() {}
    public void append(T value) {
        if (head == null) {
            head = new Node<T>(value);
            tail = head;
            return;
        }
        tail.next = new Node<T>(value);
        tail = tail.next;
        N++;
    }
    public void add(T value, int index) {
        if (index > N || index < 0) return;
        Node<T> pointer = head;
        if (index == 0) {
            head = new Node<T>(value, pointer);
            N++;
            return;
        }
        for (int n = 0; n < index - 1; n++) {
            pointer = pointer.next;
        }
        pointer.next = new Node<T>(value, pointer.next);
        N++;
    }
    public Node<T> remove(int index) {
        if (index > N || index < 0) return null;
        Node<T> pointer = head;
        Node<T> removed;
        for (int n = 0; n < index - 1; n++) {
            pointer = pointer.next;
        }
        removed = pointer.next;
        pointer.next = pointer.next.next;
        removed.next = null;
        N--;
        return removed;
    }
    public int getSize() {
        return N;
    }
    public void print() {
        Node<T> pointer = head;
        for (int n = 0; n < N; n++) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }
}

class Node<T> {
    T value;
    Node<T> next;
    public Node() {}
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
