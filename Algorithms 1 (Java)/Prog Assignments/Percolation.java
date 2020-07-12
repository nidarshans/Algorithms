import java.lang.Math;

public class Percolation {
	private int N = 0;
	private int O = 0;
	private int d = 0;
	public QuickUnion qu;
	private boolean[][] site;
	    // creates n-by-n grid, with all sites initially blocked
	public Percolation(int n) {
		N = (n * n) + 1;
		d = n;
		site = new boolean[N][N];
		for(int a = 1; a < N; a++) {
			for(int b = 1; b < N; b++) {
				site[a][b] = false;
			}
		}
		qu = new QuickUnion(N);
	}

	public int I(int r, int c) { return ((r - 1) * d) + c; }
	    // opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		if(!isOpen(row,col)) {
			site[row][col] = true;
			if(isOpen(row-1,col)) qu.union(I(row,col), I(row-1,col));
			if(isOpen(row+1,col)) qu.union(I(row,col), I(row+1,col));
			if(isOpen(row,col-1)) qu.union(I(row,col), I(row,col-1));
			if(isOpen(row,col+1)) qu.union(I(row,col), I(row,col+1));
			O++;
		}
		else System.out.println("Site is already open!");
	}
	    // is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if(row < 1 || row > d || col < 1 || col > d) return false;
		else return site[row][col];
	}
	    // is the site (row, col) full?
	public boolean isFull(int row, int col) {
		for(int i = 1; i <= d; i++) {
			if(qu.connected(I(row,col), I(1,i))) return true;
		}
		return false;
	}
	    // returns the number of open sites
	public int numberOfOpenSites() {
		return O;
	}
	    // does the system percolate?
	public boolean percolates() {
		for(int i = 1; i <= d; i++) {
			if(isFull(d,i)) return true;
		}
		return false;
	}
	    // main function
	public static void main(String[] args) {
		Percolation p = new Percolation(4);
		p.open(1,4);
		p.open(2,4);
		p.open(3,4);
		p.open(4,4);
		System.out.println();
		System.out.println(p.percolates());
	} 
}
