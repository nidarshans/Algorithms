import java.lang.Math;

public class binheap {
	public static void main(String[] args) {
		BinaryHeap B = new BinaryHeap(10);
		for(int x = 0; x < 9; x++) B.insert((int)(Math.random() * 100));
		B.insert(5);
		for(int x : B.getArray()) System.out.print(x + " ");
		System.out.println();
		B.decreasePriority(5);
		for(int x : B.getArray()) System.out.print(x + " ");
		System.out.println();
		B.flush();
	}
}

class BinaryHeap { //Currently MinBinaryHeap
	public int[] a;
	private int N = 0;
	public BinaryHeap(int N) {
		a = new int[N+1];
		a[0] = 0;
	}
	// < ----- ESSENTIAL FUNCTIONS ----- >
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
		for(int k = o; k > 1 && (a[k/2] > a[k]); k = k/2)
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
			if(j < length && (a[j] > a[j+1])) j++;
			if(a[k] <= a[j]) break;
			swap(k,j);
			k = j;
		}
	}
	public int deleteMin() {
		int min = a[1];
		swap(1,N--);
		sink(1, N);
		a[N+1] = 99999;
		return min;
	}
	// < ----- UTILITY FUNCTIONS ----- >
	public void decreasePriority(int element) {
		int i = 0;
		int deviation = ((a[1] + a[N]) / 2) - element;
		if(deviation >= 0) {
			for(int x = 1; x <= N; x++) {
				if(a[x] == element) i = x;
			}
		}
		if(deviation < 0) {
			for(int x = N; x >= 1; x--) {
				if(a[x] == element) i = x;
			}
		}
		swap(i, N);
		sink(i, --N);
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public void flush() {
		while(N > 0) System.out.print(deleteMin() + " ");
		System.out.println();
	}
	public int[] getArray() {
		int[] copy = new int[N];
		for(int x = 1; x <= N; x++) copy[x-1] = a[x];
		return copy;
	}
	public int[] getArray2() {
		return a;
	}
}
