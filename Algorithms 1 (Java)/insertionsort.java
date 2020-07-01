
import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class insertionsort {
	public static void main(String[] args) {
		int[] array = new int[args.length];
                for(int z = 0; z < args.length; z++) {
                        array[z] = Integer.parseInt(args[z]);
                }
		shellSort(array);
		System.out.print("FINAL:");
		for(int x : array) System.out.print(x + ",");
		System.out.println();
	}

	public static void insertionSort(int[] arg) {
		//Insertion sort is just shell sort with h = 1
		int key = 0;
		for(int i = 1; i < arg.length; i++) {
			int index = i - 1;
			key = arg[i];
			while(index >= 0 && arg[index] > key) {
				arg[index + 1] = arg[index];
				index--;
			}
			arg[index + 1] = key;
		}
	}

	public static void shellSort(int[] arg) {
		int N = arg.length;
		int h = N/2;
		int b; //Eqv to index in insertion sort
		int key;
		while(h >= 1) {
			for(int a = h; a < N; a++) {
				/* Starts off at a = h otherwise subsequent b -= h decrements
				 * will give a negative index value */ 
				key = arg[a];
				//b >= h because the b -= h will give a negative index for array
				for(b = a; b >= h && key < arg[b - h]; b -= h) {
					arg[b] = arg[b - h]; //Same function as in insertion sort
				}
				arg[b] = key;
			}
			h /= 2; //Decrement h to give more accurate results
		}
	}
}
