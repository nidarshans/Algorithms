import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class binaryheap {
	public static void main(String[] args) {
		BinaryHeap o = new BinaryHeap(10); 
		for(int x = 1; x < 10; x++) {
			o.insert((int)(Math.random() * 200));
		}
		for(int x : o.a) System.out.print(x + " ");
		System.out.println();
		o.sort();
		for(int x : o.a) System.out.print(x + " ");
                System.out.println();	
	}
}

class BinaryHeap {
	public int[] a;
	private int N = 0;
	public BinaryHeap(int N) {
		a = new int[N];
	}
	public void sort() {
		int L = a.length - 1;
		while(L > 1) {
			swap(1, L--);
			sink(1, L);
		}
	}
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private void swim(int o) {
		for(int k = o; k > 1 && (a[k/2] < a[k]); k = k/2)
			swap(k, k/2);
	}
	public void insert(int V) {
		a[++N] = V;
		swim(N);
	}
	private void sink(int k, int length) {
		int j = 2 * k;
		while(2 * k <= length) {
			j = 2 * k;
			if(j < length && (a[j] < a[j+1])) j++;
			if(a[k] >= a[j]) break;
			swap(k,j);
			k = j;
		}
	}
	public void deleteMax() {
		swap(1,N--);
		sink(1, N);
		a[N+1] = 99999;
	}
}
