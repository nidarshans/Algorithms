import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class selectionsort {
	public static void main(String[] args) {
		
	}
	public void sort(int[] l) {
		int min;
		int swp;
		int temp;
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
