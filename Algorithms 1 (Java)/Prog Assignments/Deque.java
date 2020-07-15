import java.lang.Math;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Deque<Item> {
	Node<Item> head = new Node(null);
	Node<Item> tail = head;
	int N = 0;
	public Deque() {}
	public boolean isEmpty() {
		if(N > 0) return false;
		return true;
	}

	public int size() { return N; }

	public void addFirst(Item item) throws IllegalArgumentException {
		if(item == null) throw new IllegalArgumentException();
		if(head.val == null) {
			head.val = item;
			N++;
		}
		else {
			head.prev = new Node(item);
			head.prev.next = head;
			head = head.prev;
			N++;
		}
	}

	public void addLast(Item item) throws IllegalArgumentException {
		if(item == null) throw new IllegalArgumentException();
		else {
			tail.next = new Node(item);
			tail.next.prev = tail;
			tail = tail.next;
			N++;
		}
	}

	public Item removeFirst() throws NoSuchElementException {
		if(N == 0) throw new NoSuchElementException();
		Item value = head.val;
		head = head.next;
		head.prev = null;
		N--;
		return value;
	}

	public Item removeLast() throws NoSuchElementException {
		if(N == 0) throw new NoSuchElementException();
		Item value = tail.val;
		tail = tail.prev;
		tail.next = null;
		N--;
		return value;
	}

	public static void main(String[] args) {
		Deque<String> q = new Deque<String>();
		try {
			q.addFirst("A");
			q.addFirst("B");
			q.addLast("C");
			q.addLast("K");
			q.removeLast();
			q.removeFirst();
			Node<String> temp = q.head;
			for(int i = 0; i < q.N; i++) {
				System.out.println(temp.val);
				temp = temp.next;
			}
		}
		catch(Exception e) { e.printStackTrace(); }
	}

}

class Node<T> {
	public T val;
	public Node next, prev;
	public Node(T arg) {
		val = arg;
	}
}
