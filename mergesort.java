import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class mergesort {
	public static void main(String[] args) {
		int[] a = new int[5000];
		int[] b = new int[a.length];
		for(int x = 0; x < a.length; x++) a[x] = (int)(Math.random() * 10000);
		sort(a,b,0,13);
		for(int x = 0; x < 10; x++) {
			System.out.println(a[x] + " ");			
		}
	}

	public static void merge(int[] arg, int[] aux, int l, int m, int h) {
		for(int x = 0; x < aux.length; x++) {
			aux[x] = arg[x];
		}
		for(int i = l, x = l, j = m + 1; x <= h; x++) {
			if(j > h) arg[x] = aux[i++];
			else if(i > m) arg[x] = aux[j++];
			else if(aux[i] < aux[j]) arg[x] = aux[i++];
			else if(aux[i] > aux[j]) arg[x] = aux[j++];
			else if(aux[i] == aux[j]) arg[x] = aux[i++];
			else {}
		}
	}

	public static void sort(int[] arg, int[] aux, int l, int h) {
		if(l >= h) return;
		int mid = (l + h) / 2;
		sort(arg, aux, l, mid);
		sort(arg, aux, mid + 1, h);
		merge(arg, aux, l, mid, h);
	}
}
