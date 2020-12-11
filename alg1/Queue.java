package alg1;
import java.lang.Math;

public class Queue<T> {
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
	public void decreasePriority() {
		T item = dequeue();
		enqueue(item);
	}
	public T[] getArray() {
        T[] copy = (T[]) new Object[tail-head+1];
        for(int x = head; x < tail; x++) {
			if(q[x] != null) copy[x] = q[x];
		}
        return copy;
	}
	public T[] getArray2() {
		return q;
	}
	public int getSize() {
		if(q[head] == null) return 0;
		else return tail-head+1;
	}
}
