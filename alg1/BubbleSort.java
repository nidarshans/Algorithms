package alg1;
import java.lang.Math;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[args.length];
		for(int z = 0; z < args.length; z++) {
			array[z] = Integer.parseInt(args[z]);
		}
		while(true) {
			if(bubbleSort(array) == false) break;
		}
		for(int x : array) System.out.println(x);
	}

	public static boolean bubbleSort(int[] arg) {
		boolean swapped = false;
		for(int x = 0; x < arg.length - 1; x++) {
			if(arg[x] > arg[x+1]) {
				int temp = arg[x];
				arg[x] = arg[x+1];
				arg[x+1] = temp;
				swapped = true;
			}
		}
		return swapped;
	}

}
