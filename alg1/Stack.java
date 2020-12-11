package alg1;
import java.lang.Math;

public class Stack<T> {
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
		T[] copy = (T[]) new Object[N];
		for(int x = 0; x < N; x++) {
			if(v[x] != null) copy[x] = v[x];
		}
		return copy;
	}
	public T[] getArray2() {
		return v;
	}
	public int getSize() { return N; }
}
