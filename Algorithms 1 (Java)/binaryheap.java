import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class binaryheap {
	public static void main(String[] args) {
	
	}
}

class BinaryHeap {
	private int[] a;
	private int N = 0;
	public BinaryHeap(int N) {
		a = new int[N];
	}
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	private void swim(int o) {
		for(int k = o; k > 1 && a[k/2] < a[k]; k = k/2)
			swap(k, k/2);
	}
	public void insert(int V) {
		a[++N] = V;
		swim(N);
	}
	private void sink(int k) {
		int j = 2 * k;
		while(2 * k <= N) {
			j = 2 * k;
			if(j < N && (a[j] < a[j+1])) j++;
			if(a[k] >= a[j]) break;
			swap(k,j);
			k = j;
		}
	}
	public void deleteMax() {
		swap(1,N--);
		sink(1);
		a[N+1] = 99999;
	}
}
