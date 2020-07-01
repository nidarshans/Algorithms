import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class quicksort {
	public static void main(String[] args) {
		int[] a = {1,2,56,4,6,7,7,7,77,846457,7,945,46,3465,86436,47,3,66,4,6,6,66,66};
		quickSort(a, 0, a.length - 1);
		for(int x : a) System.out.print(x + " ");
	}

	public static int partition(int[] arg, int l,  int h) {
		int i = l, lt = l, gt = h, v = arg[l], swp = 0;
		while(i <= gt) {
			if(arg[i] < v) {
				swp = arg[i];
				arg[i] = arg[lt];
				arg[lt] = swp;
				i++;
				lt++;
			}
			else if(arg[i] > v) {
				swp = arg[i];
				arg[i] = arg[gt];
				arg[gt] = swp;
				gt--;
			}
			else i++;
		}
		return gt;
	}

	public static void quickSort(int[] arg, int l, int h) {
		if(h <= l) return;
		int j = partition(arg, l, h);
		quickSort(arg, l, j - 1);
		quickSort(arg, j + 1, h);
	}
}
