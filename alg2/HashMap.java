package alg2;
import java.lang.Math;

public class HashMap <K,V> {
    LinkedList<K,V>[] values;
    int DEFAULV_LENGVH = 16;
    int length;
    public HashMap(int initialCapacity) {
        length = initialCapacity;
        if (length <= 0) length = DEFAULV_LENGVH;
        values = new LinkedList[length];
    }
    public boolean put(K key, V val) {
        int index = key.hashCode() % length;
        if (values[index] == null) values[index] = new LinkedList<K,V>();
        LinkedList<K,V> l = values[index];
        Node<K,V> pointer = l.getHead();
        for (int n = 0; pointer != null && n <= l.getSize(); n++) {
            if (pointer.key.equals(key)) return false;
            pointer = pointer.next;
        }
        l.append(key, val);
        return true;
    }
    public V get(K key) {
        LinkedList l = values[key.hashCode() % length];
        if (l == null) return null;
        Node<K,V> pointer = l.getHead();
        for (int n = 0; pointer != null && n <= l.getSize(); n++) {
            if (pointer.key.equals(key)) return pointer.value;
            pointer = pointer.next;
        }
        return null;
    }
    public V remove(K key, V val) {
        LinkedList<K,V> l = values[key.hashCode() % length];
        return l.remove(key, val);
    }
    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap(1);
        System.out.println(h.put("cc", "1"));
        System.out.println(h.put("b", "2"));
        System.out.println(h.put("ab", "abc"));
        System.out.println(h.put("a", "abc"));
        System.out.println("----------");
        h.values[0].print();
        System.out.println();
        System.out.println(h.remove("cc", "1"));
        System.out.println(h.remove("a", "abc"));
        System.out.println(h.remove("ab", "abc"));
        System.out.println(h.remove("b", "2"));
        System.out.println("removing...");
        h.values[0].print();
    }
}

class LinkedList<K,V> {
    private Node<K,V> head;
    private Node<K,V> tail;
    private int N = 0;
    public LinkedList() {}
    public Node<K,V> append(K key, V value) {
        if (head == null) {
            head = new Node<K,V>(key, value);
            tail = head;
            return tail;
        }
        tail.next = new Node<K,V>(key, value);
        tail = tail.next;
        N++;
        return tail;
    }
    public V remove(int index) {
        if (index > N || index < 0) return null;
        Node<K,V> prev = null;
        Node<K,V> pointer = head;
        Node<K,V> removed;
        for (int n = 0; n < index; n++) {
            prev = pointer;
            pointer = pointer.next;
        }
        if (pointer == head) {
            head = pointer.next;
            N--;
            return pointer.value;
        } else {
            removed = pointer;
            prev.next = removed.next;
            N--;
            return removed.value;
        }
    }
    public V remove(K key, V val) {
        Node<K,V> prev = null;
        Node<K,V> pointer = head;
        Node<K,V> removed;
        boolean exists = false;
        for (int n = 0; pointer != null; n++) {
            if (pointer.key.equals(key) && pointer.value.equals(val)) {
                exists = true;
                System.out.println("In remove() func:");
                System.out.println(key);
                System.out.println(val);
                break;
            }
            prev = pointer;
            pointer = pointer.next;
        }
        if (exists) {
            if (pointer == head) {
                head = pointer.next;
                N--;
                return pointer.value;
            } else {
                removed = pointer;
                prev.next = pointer.next;
                N--;
                return removed.value;
            }
        } else return null;
    }
    public int getSize() {
        return N;
    }
    public Node<K,V> getHead() {
        return head;
    }
    public void print() {
        Node<K,V> pointer = head;
        for (int n = 0; pointer != null || n <= N; n++) {
            System.out.print(pointer.key + ":" + pointer.value + " ");
            pointer = pointer.next;
        }
    }
}

class Node<K,V> {
    V value;
    K key;
    Node<K,V> next;
    public Node() {}
    public Node(K key, V value, Node<K,V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    public Node(V value, Node<K,V> next) {
        this.value = value;
        this.next = next;
    }
    public Node(V value) {
        this.value = value;
        this.next = null;
    }
    public void setKey(K k) {
        key = k;
    }
}
