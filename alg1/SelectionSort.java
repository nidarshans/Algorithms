package alg1;
import java.lang.Math;

public class SelectionSort {
	public static void main(String[] args) {}
	public void selectionSort(int[] l) {
		int min = 0;
		int swp = 0;
		int temp = 0;
		for(int a = 0; a < l.length; a++) {
			min = l[a];
			for(int b = a + 1; b < l.length; b++) {
				if(l[b] < min) {
					min = l[b];
					swp = b;
				}
			}
			temp = l[a];
			l[a] = min;
			l[swp] = temp;
		}
	}

}
