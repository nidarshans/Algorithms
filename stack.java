import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class stack {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("Hello");
		s.push("World");
		System.out.println(s.pop().length());
	}

}

class Stack<T> {
	private T[] v = (T[]) new Object[10];
	private int N = 0;
	public Stack() {}
	public void resize(int L) {
		T[] copy = (T[]) new Object[L];
		for(int x = 0; x < L && x < v.length; x++) {
			copy[x] = v[x];
		}
		v = copy;
	}
	public void push(T Q) {
		if(N == v.length) resize(v.length * 2);
		else v[N++] = Q;
	}
	public T pop() {
		T item = v[--N];
		v[N] = null;
		if(N > 0 && N <= v.length / 4) resize(v.length / 2);
		return item;
	}
}
