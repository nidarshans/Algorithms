import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class stack {
	public static void main(String[] args) {
		Stack R = new Stack();
		R.push(10);
		R.push(30);
		R.push(50);
		R.pop();
		R.print();	
	}

}

class Stack {
	private int[] v = new int[10];
	private int N = 0;
	public Stack() {}
	public void resize(int L) {
		int[] copy = new int[L];
		for(int x = 0; x < L && x < v.length; x++) {
			copy[x] = v[x];
		}
		v = copy;
	}
	public void push(int Q) {
		if(N == v.length) resize(v.length * 2);
		else v[N++] = Q;
	}
	public int pop() {
		int item = v[--N];
		v[N] = -1;
		if(N > 0 && N <= v.length / 4) resize(v.length / 2);
		return item;
	}
	public void print() {
		for(int x : v) { System.out.print(x + ","); }
	}
}
