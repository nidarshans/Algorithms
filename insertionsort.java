
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
		insertionSort(array);
		for(int x : array) System.out.println(x);
	}

	public static void insertionSort(int[] arg) {
		int key = 0;
		int[] temp = new int[arg.length];
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


}
