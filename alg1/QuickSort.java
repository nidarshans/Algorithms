package alg1;
import java.lang.Math;

public class QuickSort {
	public static void main(String[] args) {}

	public static double partition(double[] arg, double l,  double h) {
		int i = (int)l, lt = (int)l, gt = (int)h;
		double v = arg[(int)l], swp = 0;
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

	public static void quickSort(double[] arg, double l, double h) {
		if(h <= l) return;
		double j = partition(arg, l, h);
		quickSort(arg, l, j - 1);
		quickSort(arg, j + 1, h);
	}
}
