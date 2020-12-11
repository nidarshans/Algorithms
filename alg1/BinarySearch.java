package alg1;
import java.lang.Math;

public class BinarySearch {
	public static void main(String[] args) {}

	public static int binarySearch(int[] args, int num) {
		int min = 0, max = args.length - 1;
		int avg = 0;
		int L = (int) Math.ceil(Math.log((double)(args.length - 1)) / Math.log(2.0));
		System.out.println("l: " + L);
		for(int i = 0; i < L; i++) {
			avg = (min + max) / 2;
			if(args[avg] == num) return avg;
		       	if(args[avg] < num) min = avg - 1;
			if(args[avg] > num) max = avg + 1;
			System.out.println(avg);
		}
		if(args[avg] < num) {
			for(int x = avg; x < args.length; x++) {
				if(args[x] == num) avg = x;
			}
		}
		if(args[avg] > num) {
			for(int x = avg; x >= 0; x--) {
				if(args[x] == num) avg = x;
			}
		}
		if(avg == num) return avg;
		return -1;
	}

}
