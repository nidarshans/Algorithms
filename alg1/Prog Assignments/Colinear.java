import java.io.File;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Colinear {
	public static double slope(int[] p1, int[] p2) {
		double dY = (p2[1]-p1[1]);
		double dX = (p2[0]-p1[0]);
		if(dX != 0) return dY/dX;
		else if (dX == dY) return 1001;
		else return 999.0;
	}

	public static int colinear(int[][] grid, int[] O) {
		int count = 0;
		int count2 = 0;
		double[] slopes = new double[grid.length];
		for(int i = 0; i < grid.length; i++) {
			slopes[i] = slope(O, grid[i]);
		}
		quicksort q = new quicksort();
		q.quickSort(slopes, 0, slopes.length - 1);
		for(double s : slopes) System.out.println(s);
		for(int i = 0; i < slopes.length - 1; i++) {
			if(slopes[i] == slopes[i+1]) {
				count2 += 2;
			}
			else {
				count = Math.max(count, count2);
				count2 = 0;
			}
		}
		return (count + 1);
	}

	public static void main(String[] args) {
		int[][] grid = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		int[] O = grid[0];
		System.out.println(colinear(grid, O));
	}
}
