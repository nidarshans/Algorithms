import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class stackqueue {
	public static void main(String[] args) {
		Queue<String> q = new Queue<String>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
	}

}

class Stack<T> {
	private T[] v = (T[]) new Object[3];
	private int N = 0;
	public Stack() {}
	private void resize(int L) {
		T[] copy = (T[]) new Object[L];
		for(int x = 0; x < N; x++) {
			copy[x] = v[x];
		}
		v = copy;
	}
	public void push(T Q) {
		if(N == v.length) resize(v.length * 2);
		v[N++] = Q;
	}
	public T pop() {
		T item = v[--N];
		v[N] = null;
		if(N > 0 && N <= v.length / 4) resize(v.length / 2);
		return item;
	}
	public boolean isEmpty() { 
		return N == 0; 
	}
	public T[] getArray() {
		int L = 0;
		for(int x = 0; x < v.length; x++) {
			if(v[x] != null) L++;
			else break;
		}
		T[] copy = (T[]) new Object[L];
		for(int x = 0; x < L; x++) copy[x] = v[x];
		return copy;
	}
}

class Queue<T> {
	private T[] q = (T[]) new Object[3];
	private int head = 0;
	private int tail = 0;
	public Queue() {}
	private void resize(int L) {
                T[] copy = (T[]) new Object[L];
		for(int x = head; x < tail; x++) copy[x - head] = q[x];
		q = copy;
		tail = tail - head;
		head = 0;
        }
	public void enqueue(T w) {
		if(tail == q.length) resize(q.length * 2);
		q[tail++] = w;
	}
	public T dequeue() {
		T item = q[head++];
		if(tail - head <= q.length / 4) resize(q.length / 2);
		return item;
	}
	public boolean isEmpty() { 
		return q[head] == null; 
	}
	public T[] getArray() {
		int L = 0;
                for(int x = 0; x < q.length; x++) {
                        if(q[x] != null) L++;
                        else break;
                }
                T[] copy = (T[]) new Object[L];
                for(int x = 0; x < L; x++) copy[x] = q[x];
                return copy;
	}
}

